package com.seal.api.gwf.service;

import com.seal.api.gwf.entity.ReviewDetailEntity;
import com.seal.api.gwf.repository.ReviewDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewDetailService {
    @Autowired
    ReviewDetailRepository reviewDetailRepository;

    public ReviewDetailEntity getByID(int id) {return reviewDetailRepository.findById(id).get();}
}
