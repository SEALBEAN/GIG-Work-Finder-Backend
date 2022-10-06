package com.seal.api.gwf.service;

import com.seal.api.gwf.dto.JobOffer;
import com.seal.api.gwf.entity.JobOfferEntity;
import com.seal.api.gwf.repository.JobOfferRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobOfferService {

    @Autowired
    JobOfferRepository jobOfferRepository;
    @Autowired
    private ModelMapper mapper;

    public JobOffer findByOfferID(int ID) {
        JobOfferEntity jo =  jobOfferRepository.findByOfferID(ID);
        return mapper.map(jo, JobOffer.class);
    }

    public List<JobOfferEntity> getAllJobOffers(int quantity){
        List<JobOfferEntity> list = jobOfferRepository.getAll();
        int max = list.size();
        if (quantity>=max || quantity == 0)
            return list;
        while (max > quantity){
            int randomIndex = (int)Math.floor(Math.random()*(max));
            list.remove(randomIndex);
            max--;
        }
        return list;
    }

    public List<JobOfferEntity> getHurryJobOffers(int quantity){
        ArrayList<JobOfferEntity> list = (ArrayList<JobOfferEntity>) jobOfferRepository.getHurryJobOffer();
        if (quantity==0 || quantity>= list.size())
            return list;
        else{
            return list.subList(0, quantity);
        }
    }


    public List<JobOfferEntity> getPopularJobOffers(int quantity){
        ArrayList<JobOfferEntity> list = (ArrayList<JobOfferEntity>) jobOfferRepository.getAll();
        //calculate popularScore
        for (JobOfferEntity jo :
                list) {
            jo.setPopularScore(jobOfferRepository.calPopularScore(jo.getOfferID()));
        }
        //sort lai theo popularScore DESC
        list.sort(((o1, o2) -> o2.getPopularScore().compareTo(o1.getPopularScore())));
        if (quantity==0 || quantity>= list.size())
            return list;
        else{
            return list.subList(0, quantity);
        }
    }

}
