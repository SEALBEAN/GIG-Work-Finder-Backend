package com.seal.api.gwf.authorization;

import com.seal.api.gwf.authorization.ecrytion.CryptionService;
import com.seal.api.gwf.authorization.ecrytion.Token;
import com.seal.api.gwf.entity.AdminEntity;
import com.seal.api.gwf.entity.ApplicantEntity;
import com.seal.api.gwf.entity.RecruiterEntity;
import com.seal.api.gwf.repository.AdminRepository;
import com.seal.api.gwf.repository.ApplicantRepository;
import com.seal.api.gwf.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;


@Service
public class AuthorizationService {
    @Autowired
    ApplicantRepository applicantRepository;
    @Autowired
    RecruiterRepository recruiterRepository;

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    CryptionService cryptionService;


    public Data CheckAndAuthorizationWithEmail(String email, String role, String picUrl){
        String result = "";
        // check email in Applicant table for applicant role
        Token token = new Token();
        token.setEmail(email);
        token.setRole(role);
        token.setPicUrl(picUrl);
        System.out.println(token);
        if ("Recruiter".equals(role)){
            RecruiterEntity recruiterEntity =  recruiterRepository.findByEmail(email);
            token.setName(recruiterEntity.getFirstName() + " " + recruiterEntity.getLastName());
            token.setGender(recruiterEntity.getGender());
        } else
        if ("Applicant".equals(role))
        {
            ApplicantEntity applicantEntity =  applicantRepository.findByEmail(email);
            token.setName(applicantEntity.getFirstName() + " " + applicantEntity.getLastName());
            token.setGender(applicantEntity.getGender());
        }
        else if ("Admin".equals(role))
        {
            AdminEntity adminEntity =  adminRepository.findByEmail(email);
            token.setName(adminEntity.getFirstName() + " " + adminEntity.getLastName());
            token.setGender(adminEntity.getGender());
        }
        //set data
        String tokenString =  cryptionService.encode(token);
        Data data = new Data(tokenString);
        data.setEmail(token.getEmail());
        data.setRole(token.getRole());
        data.setName(token.getName());
        data.setPicUrl(token.getPicUrl());
        data.setGender(token.getGender());
        return data;
    }
}
