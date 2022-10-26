package com.seal.api.gwf.controller;

import com.seal.api.gwf.dto.Recruiter;
import com.seal.api.gwf.entity.RecruiterEntity;
import com.seal.api.gwf.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("Recruiter")
public class RecruiterController {
    @Autowired
    RecruiterService recruiterService;

    @GetMapping("/AID/{id}")
    public RecruiterEntity getByAccountID(@PathVariable int id) { return recruiterService.getByAccountID(id);}

    @PutMapping("/Update")
    public ResponseEntity<?> updateJO(@RequestBody Recruiter re){
//        try{
        Integer result = recruiterService.updateR(re);
        if (result == 1)
            return ResponseEntity.ok(HttpStatus.OK);
        else
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
//        }catch (Exception e){
//            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
//        }
    }
}
