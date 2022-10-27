package com.seal.api.gwf.service;

import com.seal.api.gwf.dto.create.JobApplicationForm;
import com.seal.api.gwf.entity.JobApplicationEntity;
import com.seal.api.gwf.repository.JobApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.util.List;

@Service
public class JobApplicationService {
    @Autowired
    JobApplicationRepository jobApplicationRepository;

    public List<JobApplicationEntity> getAll() {
        return jobApplicationRepository.getAll();
    }

    public List<JobApplicationEntity> getAllByOfferID(int offerID) {
        return jobApplicationRepository.getAllByOfferID(offerID);
    }

    public Integer updateJA(JobApplicationForm jaf){
        JobApplicationEntity jae = jobApplicationRepository.findByAccountId(jaf.getAccountID());

        Time startTime;
        if (jaf.getStartTime() == null) {
            startTime = jae.getStartTime();
        } else {
            startTime = Time.valueOf(jaf.getStartTime() + ":00");
        }
        Time endTime;
        if (jaf.getEndTime() == null) {
            endTime = jae.getEndTime();
        } else {
            endTime = Time.valueOf(jaf.getEndTime() + ":00");
        }

        if (jaf.getOther() == null) {
            jaf.setOther(jae.getOther());
        }
        Integer result = jobApplicationRepository.updateJA(jaf.getAccountID(), jaf.getOther(), startTime, endTime, jaf.getAvailable());
        return result;
    }
}
