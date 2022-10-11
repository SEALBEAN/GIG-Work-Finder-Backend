package com.seal.api.gwf.service;

import com.seal.api.gwf.dto.create.BusinessAddress;
import com.seal.api.gwf.dto.create.DegreeName;
import com.seal.api.gwf.dto.create.JobName;
import com.seal.api.gwf.entity.BusinessEntity;
import com.seal.api.gwf.entity.DegreeEntity;
import com.seal.api.gwf.entity.JobTypeEntity;
import com.seal.api.gwf.repository.BusinessRepository;
import com.seal.api.gwf.repository.DegreeRepository;
import com.seal.api.gwf.repository.JobTypeRepository;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
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
    @Autowired
    private ModelMapper mapper;

    @Getter
    @Setter
    public class CreateJO {
        List<DegreeName> degreeNames = new ArrayList<>();
        List<JobName> jobNames = new ArrayList<>();
        List<BusinessAddress> businessAddresses = new ArrayList<>();


        public CreateJO(int id) {
            List<DegreeEntity> degreeNames = degreeRepository.getAllDegreeName();
            List<JobTypeEntity> jobNames = jobTypeRepository.getAllJobTypeNames();
            List<BusinessEntity> businessAddresses = businessRepository.getAllBusinessAddress(id);
            for (DegreeEntity de :
                    degreeNames) {
                this.degreeNames.add(mapper.map(de, DegreeName.class));
            }
            for (JobTypeEntity joe:
                 jobNames) {
                this.jobNames.add(mapper.map(joe, JobName.class));
            }
            for (BusinessEntity be :
                    businessAddresses) {
                this.businessAddresses.add(mapper.map(be, BusinessAddress.class));
            }
        }
    }

    public CreateJO getInfo(int id) {
        CreateJO result = new CreateJO(id);
        return result;
    }

}
