package com.seal.api.gwf.authorization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Authorization")
public class AuthorizationController {

    @Autowired
    AuthorizationService authorizationService;
    @PostMapping("")
    public String CheckAndCreateAccountAndAccountTokenForAuthorization(@RequestBody Data data){
            return authorizationService.CheckAndAuthorizationWithEmail(data.email, data.role, data.picUrl);
    }
}
