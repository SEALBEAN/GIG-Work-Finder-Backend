package com.seal.api.gwf.controller;


import com.seal.api.gwf.entity.ApplicantEntity;
import com.seal.api.gwf.service.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
