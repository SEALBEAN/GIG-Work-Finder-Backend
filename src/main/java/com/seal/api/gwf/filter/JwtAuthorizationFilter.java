package com.seal.api.gwf.filter;

import com.seal.api.gwf.authorization.ecrytion.CryptionServiceImpl;
import com.seal.api.gwf.authorization.ecrytion.Token;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Component
public class JwtAuthorizationFilter implements Filter {
    Properties guestProperties;
    Properties recruiterProperties;
    Properties applicantProperties;
    public Properties loadProperties(String path) {
        Properties prop = new Properties();

        try (
        InputStream input = new FileInputStream(path)) {


                // load a properties file
                prop.load(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        return prop;



    }
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
        guestProperties = loadProperties("./src/main/java/com/seal/api/gwf/filter/authorizationResources/guest.properties");
        applicantProperties = loadProperties("./src/main/java/com/seal/api/gwf/filter/authorizationResources/applicant.properties");
        recruiterProperties = loadProperties("./src/main/java/com/seal/api/gwf/filter/authorizationResources/recruiter.properties");


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        boolean passed = false;
        String message = "";
        int errorCode = HttpStatus.UNAUTHORIZED.value();
        System.out.println("Url raw: " + request.getRequestURI() + " " + request.getMethod());
        if ("POST".equals(request.getMethod()) || "PUT".equals(request.getMethod()) || "DELETE".equals(request.getMethod())) {
            System.out.println("request: " + request.toString());
            String tokenString = request.getHeader("Authorization");
            String url = request.getRequestURI();
            url = url.replaceAll("[0-9]+", "Number");
            while (url.endsWith("/")) url = url.substring(0,url.length()-1);
            if (url.contains("https://gig-worker-backend.azurewebsites.net")) url = url.substring("https://gig-worker-backend.azurewebsites.net".length()-1);
            System.out.println(url);
            if (!"1".equals(guestProperties.getProperty(url)) || "/Authorization".equals(url)) {
                System.out.println("raw string: " + tokenString);
                if (tokenString != null && !tokenString.isEmpty()) {
                    tokenString = tokenString.trim();

                    tokenString = tokenString.substring(7);

                    System.out.println(tokenString);

                    if (!"undefined".equals(tokenString)) {
                        try {
                            CryptionServiceImpl cryptionServiceImpl = new CryptionServiceImpl();
                            Token token = cryptionServiceImpl.decode(tokenString);
                            System.out.println("This is filter! Request header token decode: \n" + token.getEmail() + " " + token.getRole());
                            if ("Applicant".equals(token.getRole()) && ("1".equals(applicantProperties.getProperty(url)))) {
                                passed = true;
                            } else
                            if ("Recruiter".equals(token.getRole()) && ("1".equals(recruiterProperties.getProperty(url)))) {
                                passed = true;
                            }
                        } catch (Exception e) {
                            message = ("Exception: " + e.getMessage());
                            errorCode = HttpStatus.NOT_FOUND.value();
                        }
                    }
                    else {
//                        System.out.println("This is filter! Token is undefined! ");
//                        filterChain.doFilter(servletRequest, servletResponse);
                        message = "Unauthorized: undefined ";
                        errorCode = HttpStatus.BAD_REQUEST.value();


                    }
                } else {
//                    System.out.println("This is filter! Don't have token! ");
//                    filterChain.doFilter(servletRequest, servletResponse);
                    message = "Unauthorized: null or empty ";
                    errorCode = HttpStatus.UNAUTHORIZED.value();

                }
            } else { //Authorization, guest
                passed = true;
                System.out.println("Authorization");
            }

        }
            else passed =true;

            if (passed)
                filterChain.doFilter(servletRequest, servletResponse);
            else {
                HttpServletResponse response = (HttpServletResponse) servletResponse;
                response.sendError(errorCode, message);
            }

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
