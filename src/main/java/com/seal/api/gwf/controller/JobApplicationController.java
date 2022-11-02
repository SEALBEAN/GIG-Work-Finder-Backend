package com.seal.api.gwf.controller;

import com.seal.api.gwf.dto.create.JobApplicationForm;
import com.seal.api.gwf.dto.get.AllJobApplication;
import com.seal.api.gwf.dto.get.AllJobOffer;
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

    @GetMapping("/RIDUnValid/{aid}")
    public List<AllJobApplication> getAllJAByRecruiterIDUnValid(@PathVariable int aid){
        return jobApplicationService.getAllJAByRecruiterID(aid, 0);
    }

    @GetMapping("/RIDValid/{aid}")
    public List<AllJobApplication> getAllJAByRecruiterIDValid(@PathVariable int aid){
        return jobApplicationService.getAllJAByRecruiterID(aid, 1);
    }

    @GetMapping("/RIDFinish/{aid}")
    public List<AllJobApplication> getAllJAByRecruiterIDFinish(@PathVariable int aid){
        return jobApplicationService.getAllJAByRecruiterID(aid, 2);
    }


    @GetMapping("/AppIDUnValid/{aid}")
    public List<AllJobOffer> getAllByAppIDUnValid(@PathVariable int aid){
        return jobApplicationService.getAllByApplicantID(aid, 0);
    }

    @GetMapping("/AppIDValid/{aid}")
    public List<AllJobOffer> getAllByAppIDValid(@PathVariable int aid){
        return jobApplicationService.getAllByApplicantID(aid, 1);
    }

    @GetMapping("/AppIDFinish/{aid}")
    public List<AllJobOffer> getAllByAppIDFinish(@PathVariable int aid){
        return jobApplicationService.getAllByApplicantID(aid, 2);
    }

    @GetMapping("/AppIDCancel/{aid}")
    public List<AllJobOffer> getAllByAppIDCancel(@PathVariable int aid){
        return jobApplicationService.getAllByApplicantID(aid, 3);
    }

    @PostMapping("/ApplyJA")
    public ResponseEntity<?> applyJA(@RequestParam(value = "oid", required = false) Integer oid,
                                     @RequestParam(value = "jaid") int jaid,
                                     @RequestParam(value = "aid") int aid){
        try {
            Integer result = jobApplicationService.applyJA(oid, jaid, aid);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace());
        }
    }
    @PutMapping("/UpdateJA")
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
