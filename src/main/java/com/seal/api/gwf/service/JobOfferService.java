package com.seal.api.gwf.service;

import com.seal.api.gwf.entity.JobOfferEntity;
import com.seal.api.gwf.repository.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    public List<JobOfferEntity> getHurryJobOffers(){
        return jobOfferRepository.getHurryJobOffer();
    }

    public List<JobOfferEntity> getPopularJobOffers(){
        ArrayList<JobOfferEntity> list = (ArrayList<JobOfferEntity>) jobOfferRepository.findAll();
        //calculate popularScore
        for (JobOfferEntity jo :
                list) {
            jo.setPopularScore(jobOfferRepository.calPopularScore(jo.getOfferID()));
        }
        //sort lai theo popularScore DESC
        list.sort(((o1, o2) -> o2.getPopularScore().compareTo(o1.getPopularScore())));
        return list;
    }

}
