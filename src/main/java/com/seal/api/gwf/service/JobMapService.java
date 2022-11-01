package com.seal.api.gwf.service;

import com.seal.api.gwf.repository.JobMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobMapService {

    @Autowired
    JobMappingRepository jobMappingRepository;
    public Integer confirm(int mid) {
        return jobMappingRepository.confirm(mid);
    }

    public Integer finish(int mid) {
        return jobMappingRepository.finish(mid);
    }

    public Integer cancel(int mid) {
        return jobMappingRepository.cancel(mid);
    }
}
