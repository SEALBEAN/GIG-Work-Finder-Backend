package com.seal.api.gwf.controller;

import com.seal.api.gwf.entity.JobTypeEntity;
import com.seal.api.gwf.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("JobType")
public class JobTypeController {
    @Autowired
    JobTypeService jobTypeService;

    @GetMapping("/GetPopular")
    public List<JobTypeEntity> getPopularJobType() {return jobTypeService.getPopularJobType();}
}
