package com.seal.api.gwf.service;

import com.seal.api.gwf.dto.JobOffer;
import com.seal.api.gwf.dto.create.JobOfferForm;
import com.seal.api.gwf.entity.JobOfferEntity;
import com.seal.api.gwf.repository.JobOfferRepository;
import com.seal.utils.Utils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class JobOfferService {

    @Autowired
    JobOfferRepository jobOfferRepository;
    @Autowired
    private ModelMapper mapper;

    //Test Entity
    public JobOfferEntity getByID(int ID) {
        return jobOfferRepository.findByOfferID(ID);
    }


    public JobOffer findByOfferID(int ID) {
        JobOfferEntity jo = jobOfferRepository.findByOfferID(ID);
        return mapper.map(jo, JobOffer.class);
    }

    public List<JobOffer> findByBusinessID(int ID) {

        List<JobOfferEntity> jo = jobOfferRepository.findByBusinessID(ID);
        ArrayList<JobOffer> list = new ArrayList<>();
        for (JobOfferEntity j :
                jo) {
            list.add(mapper.map(j, JobOffer.class));
        }
        return list;
    }

    public List<JobOffer> getAllJobOffers(int quantity) {
        ArrayList<JobOfferEntity> jo = (ArrayList<JobOfferEntity>) jobOfferRepository.getAll();
        ArrayList<JobOffer> list = new ArrayList<>();
        for (JobOfferEntity j :
                jo) {
            list.add(mapper.map(j, JobOffer.class));
        }
        int max = list.size();
        if (quantity >= max || quantity == 0)
            return list;
        while (max > quantity) {
            int randomIndex = (int) Math.floor(Math.random() * (max));
            list.remove(randomIndex);
            max--;
        }
        return list;
    }

    public List<JobOffer> getHurryJobOffers(int quantity) {
        ArrayList<JobOfferEntity> jo = (ArrayList<JobOfferEntity>) jobOfferRepository.getHurryJobOffer();
        ArrayList<JobOffer> list = new ArrayList<>();
        for (JobOfferEntity j :
                jo) {
            list.add(mapper.map(j, JobOffer.class));
        }
        if (quantity == 0 || quantity >= list.size())
            return list;
        else {
            return list.subList(0, quantity);
        }
    }


    public List<JobOffer> getPopularJobOffers(int quantity) {
        ArrayList<JobOfferEntity> jo = (ArrayList<JobOfferEntity>) jobOfferRepository.getAll();
        ArrayList<JobOffer> list = new ArrayList<>();
        for (JobOfferEntity j :
                jo) {
            list.add(mapper.map(j, JobOffer.class));
        }
        //calculate popularScore
        for (JobOffer j :
                list) {
            j.setPopularScore(jobOfferRepository.calPopularScore(j.getOfferID()));
        }
        //sort lai theo popularScore DESC
        list.sort(((o1, o2) -> o2.getPopularScore().compareTo(o1.getPopularScore())));
        if (quantity == 0 || quantity >= list.size())
            return list;
        else {
            return list.subList(0, quantity);
        }
    }

    public Integer createJO(JobOfferForm joe) {
        Time startTime = Time.valueOf(joe.getStartTime() + ":00");
        Time endTime = Time.valueOf(joe.getEndTime() + ":00");
        LocalDateTime d = LocalDateTime.parse(joe.getOfferEndTime()+" 00:00:00", Utils.DAYTIMEFORMATDDMMYYYY);
        Timestamp offerEndTime = Timestamp.valueOf(d);
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        int result = jobOfferRepository.addJobOffer(joe.getAccountID(), joe.getJobType(), joe.getLocation(), joe.getDegree(), joe.getNumOfRecruit()
                , offerEndTime, createdDate, joe.getSalary(), joe.getAge(), joe.getJobDescription(), joe.getOther(), startTime, endTime
                , joe.getAddress(), joe.getBusiness(), null);
        return result;
    }
}
