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


    public Data CheckAndAuthorizationWithEmail(Data data){
        String result = "";
        String email =data.getEmail();
        String role = data.getRole();
        String picUrl = data.getPicUrl();
        // check email in Applicant table for applicant role
        Token token = new Token();
        token.setEmail(email);
        token.setRole(role);
        token.setPicUrl(picUrl);
        System.out.println(token);
        if ("Recruiter".equals(role)){
            RecruiterEntity recruiterEntity =  recruiterRepository.findByEmail(email);
            if (recruiterEntity == null) {
                recruiterRepository.addRecruiter(
                        data.getName().replace(data.getName().split("")[0], ""), data.getName().split(" ")[0],
                        null, data.getGender(), data.getEmail(), null);
                recruiterEntity =  recruiterRepository.findByEmail(email);
            }
            // have account in database
            token.setId(recruiterEntity.getAccountID());
            token.setName(recruiterEntity.getFirstName() + " " + recruiterEntity.getLastName());
            token.setGender(recruiterEntity.getGender());
        } else
        if ("Applicant".equals(role))
        {
            ApplicantEntity applicantEntity =  applicantRepository.findByEmail(email);
            if (applicantEntity == null) {
                //doesn't has account -> create
                applicantRepository.addApplicant(null,null,
                        data.getName().replace(data.getName().split("")[0], ""), data.getName().split(" ")[0],
                        null, data.getGender(), data.getEmail(), null);
                applicantEntity =  applicantRepository.findByEmail(email);
            }
            token.setId(applicantEntity.getAccountID());
            token.setName(applicantEntity.getFirstName() + " " + applicantEntity.getLastName());
            token.setGender(applicantEntity.getGender());
        }
        else if ("Admin".equals(role))
        {
            AdminEntity adminEntity =  adminRepository.findByEmail(email);
            token.setId(adminEntity.getAccountID());
            token.setName(adminEntity.getFirstName() + " " + adminEntity.getLastName());
            token.setGender(adminEntity.getGender());
        }
        //set data
        String tokenString =  cryptionService.encode(token);
        data.setId(token.getId());
        data.setToken(tokenString);
        return data;
    }
}
