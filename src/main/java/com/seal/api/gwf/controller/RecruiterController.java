package com.seal.api.gwf.controller;

import com.seal.api.gwf.entity.RecruiterEntity;
import com.seal.api.gwf.service.RecruiterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("Recruiter")
public class RecruiterController {
    @Autowired
    RecruiterService recruiterService;

    @GetMapping("/AID/{id}")
    public RecruiterEntity getByAccountID(@PathVariable int id) { return recruiterService.getByAccountID(id);}
}
