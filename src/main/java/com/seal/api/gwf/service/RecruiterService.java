package com.seal.api.gwf.service;

import com.seal.api.gwf.entity.RecruiterEntity;
import com.seal.api.gwf.repository.RecruiterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecruiterService {
    @Autowired
    RecruiterRepository recruiterRepository;

    public RecruiterEntity getByAccountID(int id){return recruiterRepository.findByAccountID(id);}
}
