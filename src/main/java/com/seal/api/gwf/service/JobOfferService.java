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
        Time startTime = null, endTime = null;
        Timestamp offerEndTime;
        if (joe.getStartTime() != null)
            startTime = Time.valueOf(joe.getStartTime() + ":00");
        if (joe.getEndTime() != null)
            endTime = Time.valueOf(joe.getEndTime() + ":00");
        LocalDateTime d = LocalDateTime.parse(joe.getOfferEndTime() + " 00:00:00", Utils.DAYTIMEFORMATDDMMYYYY);
        offerEndTime = Timestamp.valueOf(d);
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());
        int result = jobOfferRepository.addJobOffer(joe.getAccountID(), joe.getJobType(), joe.getLocation(), joe.getDegree(), joe.getNumOfRecruit()
                , offerEndTime, createdDate, joe.getSalary(), joe.getAge(), joe.getJobDescription(), joe.getOther(), startTime, endTime
                , joe.getAddress(), joe.getBusiness(), null);
        return result;
    }

    public Integer updateJO(JobOfferForm joe) {
        JobOfferEntity jo = jobOfferRepository.findByOfferID(joe.getOfferID());

        Time startTime;
        if (joe.getStartTime() == null) {
            startTime = jo.getStartTime();
        } else {
            startTime = Time.valueOf(joe.getStartTime() + ":00");
        }
        Time endTime;
        if (joe.getEndTime() == null) {
            endTime = jo.getEndTime();
        } else {
            endTime = Time.valueOf(joe.getEndTime() + ":00");
        }

        Object offerEndTime;
        if (joe.getOfferEndTime() == null) {
            offerEndTime = jo.getOfferEndTime();
        } else {
            offerEndTime = Timestamp.valueOf(LocalDateTime.parse(joe.getOfferEndTime() + " 00:00:00", Utils.DAYTIMEFORMATDDMMYYYY));
        }
        Timestamp createdDate = new Timestamp(System.currentTimeMillis());

        if (joe.getJobType() == null) {
            if (jo.getJobType() != null)
                joe.setJobType(jo.getJobType().getTypeID());
        }

        if (joe.getLocation() == null) {
            if (jo.getLocation() != null)
                joe.setLocation(jo.getLocation().getLocationID());
        }
        if (joe.getDegree() == null) {
            if (jo.getDegree() != null)
                joe.setDegree(jo.getDegree().getDegreeID());
        }
        if (joe.getBusiness() == null) {
            if (jo.getBusiness() != null)
                joe.setBusiness(jo.getBusiness().getBusinessID());
        }
        if (joe.getNumOfRecruit() == null) {
            joe.setNumOfRecruit(jo.getNumOfRecruit());
        }
        if (joe.getSalary() == null) {
            joe.setSalary(jo.getSalary());
        }
        if (joe.getAge() == null) {
            joe.setAge(jo.getAge());
        }
        if (joe.getJobDescription() == null) {
            joe.setJobDescription(jo.getJobDescription());
        }
        if (joe.getOther() == null) {
            joe.setOther(jo.getOther());
        }
        if (joe.getAddress() == null) {
            joe.setAddress(jo.getAddress());
        }
        int result = jobOfferRepository.updateJobOffer(joe.getOfferID(), joe.getJobType(), joe.getLocation(), joe.getDegree(), joe.getNumOfRecruit()
                , offerEndTime, createdDate, joe.getSalary(), joe.getAge(), joe.getJobDescription(), joe.getOther(), startTime, endTime
                , joe.getAddress(), joe.getBusiness());
        return result;
    }

    public Integer deleteJO(int id) {return jobOfferRepository.deleteByID(id);
    }

    public List<JobOffer> getAllJobOffersByAID(int aid) {
        List<JobOfferEntity> joe = jobOfferRepository.getByAccountID(aid);
        ArrayList<JobOffer> result = new ArrayList<>();
        for (JobOfferEntity jo: joe) {
            result.add(mapper.map(jo, JobOffer.class));
        }
        return result;
    }

    public List<JobOffer> getAllJobOffersByAIDStatus(int aid, int status) {
        List<JobOfferEntity> joe = jobOfferRepository.getByAccountID(aid, status);
        ArrayList<JobOffer> result = new ArrayList<>();
        for (JobOfferEntity jo: joe) {
            result.add(mapper.map(jo, JobOffer.class));
        }
        return result;
    }

    public Integer applyJO(int oid, int jaid) {
        return jobOfferRepository.applyJO(oid, jaid);
    }
}
