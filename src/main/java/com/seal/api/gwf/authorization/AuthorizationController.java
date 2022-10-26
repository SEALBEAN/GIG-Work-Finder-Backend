package com.seal.api.gwf.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.security.GeneralSecurityException;

@RestController
@RequestMapping("Authorization")
public class AuthorizationController {

    @Autowired
    AuthorizationService authorizationService;
    @PostMapping("")
    public ResponseEntity<?> CheckAndCreateAccountAndAccountTokenForAuthorization(@RequestBody Data data){
        Data googleData;
        String idTokenString = data.getToken().split(" ")[1].trim();

//        try {
//            googleData = GoogleApiVerifier.VerifyGoogleToken(idTokenString);
//        } catch (IOException exception){
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("IOException!");
//        } catch (GeneralSecurityException exception){
//            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("GeneralSecurityException!");
//        }
//        if (googleData == null ) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fail idToken!");
//        else
            return ResponseEntity.ok(authorizationService.CheckAndAuthorizationWithEmail(data));
    }
    @PostMapping("/google-verifier")
    public ResponseEntity GoogleVerifier(@RequestHeader(value = "Authorization") String idToken){
        Data data;
        String idTokenString = idToken.replace("Bearer ", "");
        System.out.println(idTokenString);
        try {
             data = GoogleApiVerifier.VerifyGoogleToken(idTokenString);
        } catch (IOException exception){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("IOException!");
        } catch (GeneralSecurityException exception){
            return  ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("GeneralSecurityException!");
        }
        if (data == null) return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Fail idToken!");
        else return ResponseEntity.ok(data);
    }
}
