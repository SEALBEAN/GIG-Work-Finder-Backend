package com.seal.api.gwf.service;

import com.seal.api.gwf.entity.JobOfferEntity;
import com.seal.api.gwf.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobOfferService {

    @Autowired
    JobOfferRepository jobOfferRepository;

    public JobOfferEntity findByOfferID(int ID) { return jobOfferRepository.findByOfferID(ID);}

    public List<JobOfferEntity> findByLocationID(int ID){
        return jobOfferRepository.findByLocationID(ID);
    }

    public List<JobOfferEntity> findByAccountID(int ID){
        return jobOfferRepository.findByAccountID(ID);
    }

    public List<JobOfferEntity> getAllJobOffers() {
        return jobOfferRepository.findAll();
    }

}
