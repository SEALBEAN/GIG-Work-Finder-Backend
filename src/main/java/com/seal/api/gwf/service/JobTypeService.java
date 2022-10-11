package com.seal.api.gwf.service;


import com.seal.api.gwf.dto.create.JobName;
import com.seal.api.gwf.entity.JobTypeEntity;
import com.seal.api.gwf.repository.JobTypeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobTypeService {

    @Autowired
    JobTypeRepository jobTypeRepository;

    @Autowired
    ModelMapper mapper;

    public List<JobTypeEntity> getPopularJobType(int quantity) {
        List<JobTypeEntity> list = jobTypeRepository.getPopularJobType();
        if (quantity == 0 || quantity>= list.size())
            return list;
        else
            return list.subList(0, quantity);
    }

    public List<JobName> getAllJobTypeNames(){
        List<JobTypeEntity> jobNames = jobTypeRepository.getAllJobTypeNames();
        List<JobName> result = new ArrayList<>();
        for (JobTypeEntity joe:
                jobNames) {
            result.add(mapper.map(joe, JobName.class));
        }
        return result;
    }
}
