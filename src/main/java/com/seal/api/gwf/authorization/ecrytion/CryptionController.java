package com.seal.api.gwf.authorization.ecrytion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/encryption")
public class CryptionController {
    @Autowired
    public CryptionService cryptionService;

    @PostMapping
    public String createTokenJwt(@RequestBody Token token){
        return cryptionService.encode(token);
    }
    @GetMapping
    public Token readTokenJwt(@RequestParam String token){
        return cryptionService.decode(token);
    }

}
