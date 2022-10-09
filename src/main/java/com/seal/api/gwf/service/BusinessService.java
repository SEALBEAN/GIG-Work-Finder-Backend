package com.seal.api.gwf.service;

import com.seal.api.gwf.dto.Business;
import com.seal.api.gwf.entity.BusinessEntity;
import com.seal.api.gwf.repository.BusinessRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BusinessService {
    @Autowired
    BusinessRepository businessRepository;

    @Autowired
    private ModelMapper mapper;

    public Business getByID(int id) {
        BusinessEntity bu = businessRepository.getByID(id);
        return mapper.map(bu, Business.class);
    }

    public List<Business> getAllBusiness(int quantity) {
        ArrayList<BusinessEntity> bu = (ArrayList<BusinessEntity>) businessRepository.getAll();
        ArrayList<Business> list = new ArrayList<>();
        for (BusinessEntity j :
                bu) {
            list.add(mapper.map(j, Business.class));
        }
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
}
