package com.seal.api.gwf.authorization;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Collections;

@Component
public class GoogleApiVerifier {

        public static Data VerifyGoogleToken(String idTokenString) throws GeneralSecurityException, IOException {
                HttpTransport transport = new NetHttpTransport();
                JsonFactory jsonFactory = new GsonFactory();
                Data data = null;


                GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jsonFactory)
                        // Specify the CLIENT_ID of the app that accesses the backend:
                        .setAudience(Collections.singletonList("113868114805676880830"))
                        // Or, if multiple clients access the backend:
                        //.setAudience(Arrays.asList(CLIENT_ID_1, CLIENT_ID_2, CLIENT_ID_3))
                        .build();

                // (Receive idTokenString by HTTPS POST)
                if (idTokenString != null) {
                        GoogleIdToken idToken = verifier.verify(idTokenString);
                        if (idToken != null) {
                                data = new Data();
                                Payload payload = idToken.getPayload();

                                // Print user identifier
                                String userId = payload.getSubject();
                                System.out.println("User ID: " + userId);

                                // Get profile information from payload
                                data.setEmail(payload.getEmail());
//                                boolean emailVerified = payload.getEmailVerified();
                                data.setName((String) payload.get("name"));
                                data.setPicUrl((String) payload.get("picture"));
//                                String locale = (String) payload.get("locale");
//                                String familyName = (String) payload.get("family_name");
//                                String givenName = (String) payload.get("given_name");

                                // Use or store profile information
                                // ...
                                System.out.println(data);

                        } else {
                                System.out.println("Invalid ID token.");
                        }
                }
                return data;
        }
}
