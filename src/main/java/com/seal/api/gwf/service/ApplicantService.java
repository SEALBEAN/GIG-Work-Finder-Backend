package com.seal.api.gwf.service;


import com.seal.api.gwf.entity.ApplicantEntity;
import com.seal.api.gwf.repository.ApplicantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    ApplicantRepository applicantRepository;

    public ApplicantEntity getByAccountID(int id) {return applicantRepository.findById(id).get();}

    public List<ApplicantEntity> getAllApplicants () {return applicantRepository.findAll();}
}
