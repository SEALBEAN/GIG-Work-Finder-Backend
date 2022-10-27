package com.seal.api.gwf.controller;


import com.seal.api.gwf.dto.create.ApplicantForm;
import com.seal.api.gwf.entity.ApplicantEntity;
import com.seal.api.gwf.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("Applicant")
public class ApplicantController {
    @Autowired
    ApplicantService applicantService;

    @GetMapping("/AID/{id}")
    public ApplicantEntity getByAccountID(@PathVariable int id) {return applicantService.getByAccountID(id);}

    @GetMapping("/ALL")
    public List<ApplicantEntity> getAllApplicants() {return applicantService.getAllApplicants();}

    @PutMapping("/UpdateApp")
    public ResponseEntity<?> updateApp(@RequestBody ApplicantForm app){
        try{
            Integer result = applicantService.updateApp(app);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
