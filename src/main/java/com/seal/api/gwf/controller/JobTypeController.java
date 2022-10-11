package com.seal.api.gwf.controller;

import com.seal.api.gwf.dto.create.JobName;
import com.seal.api.gwf.entity.JobTypeEntity;
import com.seal.api.gwf.service.JobTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("JobType")
public class JobTypeController {
    @Autowired
    JobTypeService jobTypeService;

    @GetMapping("/GetPopular")
    @ResponseBody
    public List<JobTypeEntity> getPopularJobType(@RequestParam(required = false) Integer limit) {
        if (limit == null)
            return jobTypeService.getPopularJobType(10);
        else
            return jobTypeService.getPopularJobType(limit);
    }

    @GetMapping("/GetName")
    @ResponseBody
    public List<JobName> getAllJobTypeNames() {
            return jobTypeService.getAllJobTypeNames();
    }
}
