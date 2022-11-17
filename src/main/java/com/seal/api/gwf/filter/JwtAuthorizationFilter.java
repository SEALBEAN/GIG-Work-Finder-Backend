package com.seal.api.gwf.filter;

import com.seal.api.gwf.authorization.Data;
import com.seal.api.gwf.authorization.ecrytion.CryptionService;
import com.seal.api.gwf.authorization.ecrytion.CryptionServiceImpl;
import com.seal.api.gwf.authorization.ecrytion.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtAuthorizationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println("request: " + request);
        String tokenString = request.getHeader("Authorization");
        if (tokenString!= null && !tokenString.isEmpty()) {
            tokenString = tokenString.trim();
            tokenString.substring(tokenString.indexOf(' ')+1);
            CryptionServiceImpl cryptionServiceImpl = new CryptionServiceImpl();
            Token token = cryptionServiceImpl.decode(tokenString);
            System.out.println("This is filter! Request header token: " + token);
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            System.out.println("This is filter! Don't have token! ");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
