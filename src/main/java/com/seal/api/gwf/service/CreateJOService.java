package com.seal.api.gwf.service;

import com.seal.api.gwf.dto.create.BusinessAddress;
import com.seal.api.gwf.dto.create.DegreeName;
import com.seal.api.gwf.dto.create.JobName;
import com.seal.api.gwf.repository.BusinessRepository;
import com.seal.api.gwf.repository.DegreeRepository;
import com.seal.api.gwf.repository.JobTypeRepository;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class CreateJOService {
    @Autowired
    DegreeRepository degreeRepository;
    @Autowired
    JobTypeRepository jobTypeRepository;
    @Autowired
    BusinessRepository businessRepository;

    @Getter
    @Setter
    public class CreateJO{
        List<DegreeName> degreeNames = degreeRepository.getAllDegreeName();
        List<JobName> jobNames = jobTypeRepository.getAllJobTypeNames();
        List<BusinessAddress> businessAddresses = new ArrayList<>();

        public CreateJO(int id) {
            this.businessAddresses = businessRepository.getAllBusinessAddress(id);
        }
    }

    public CreateJO getInfo(int id){
        CreateJO result = new CreateJO(id);
        return result;
    }

}
