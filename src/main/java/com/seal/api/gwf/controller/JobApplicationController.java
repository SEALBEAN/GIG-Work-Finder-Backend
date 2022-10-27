package com.seal.api.gwf.controller;

import com.seal.api.gwf.dto.create.JobApplicationForm;
import com.seal.api.gwf.dto.create.JobOfferForm;
import com.seal.api.gwf.entity.JobApplicationEntity;
import com.seal.api.gwf.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("JobApp")
public class JobApplicationController {
    @Autowired
    JobApplicationService jobApplicationService;

    @GetMapping("/ALL")
    public List<JobApplicationEntity> getAll() {
        return jobApplicationService.getAll();
    }

    @GetMapping("/OfferID/{oid}")
    public List<JobApplicationEntity> getAllByOfferID(@PathVariable int oid){
        return jobApplicationService.getAllByOfferID(oid);
    }

    @PostMapping("/UpdateJA")
    public ResponseEntity<?> updateJA(@RequestBody JobApplicationForm jaf) {
        try {
            Integer result = jobApplicationService.updateJA(jaf);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace());
        }

    }

}
