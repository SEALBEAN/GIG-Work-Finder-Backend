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

    public List<JobOfferEntity> getAllJobOffers() {
        return jobOfferRepository.getAll();
    }

    public List<JobOfferEntity> getAllJobOffers(int quantity){
        List<JobOfferEntity> list = jobOfferRepository.getAll();
        int max = list.size();
        if (quantity>=max)
            return list;
        while (max > quantity){
            int randomIndex = (int)Math.floor(Math.random()*(max));
            list.remove(randomIndex);
            max--;
        }
        return list;
    }

    public List<JobOfferEntity> getHurryJobOffers(){
        return jobOfferRepository.getHurryJobOffer();
    }

    public List<JobOfferEntity> getPopularJobOffers(){
        ArrayList<JobOfferEntity> list = (ArrayList<JobOfferEntity>) jobOfferRepository.getAll();
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
