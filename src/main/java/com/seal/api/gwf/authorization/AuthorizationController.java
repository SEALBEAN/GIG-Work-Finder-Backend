package com.seal.api.gwf.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Authorization")
public class AuthorizationController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping("")
    public String CheckAndCreateAccountAndAccountTokenForAuthorization(@RequestParam String email, @RequestParam String role){
            return authorizationService.CheckAndAuthorizationWithEmail(email,role);
    }
}
