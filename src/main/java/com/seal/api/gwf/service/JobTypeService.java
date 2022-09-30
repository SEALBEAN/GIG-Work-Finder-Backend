package com.seal.api.gwf.service;


import com.seal.api.gwf.entity.JobTypeEntity;
import com.seal.api.gwf.repository.JobOfferRepository;
import com.seal.api.gwf.repository.JobTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobTypeService {

    @Autowired
    JobTypeRepository jobTypeRepository;

    public List<JobTypeEntity> getPopularJobType() {return jobTypeRepository.getPopularJobType();}
}
