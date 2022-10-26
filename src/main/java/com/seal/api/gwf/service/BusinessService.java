package com.seal.api.gwf.service;

import com.seal.api.gwf.dto.Business;
import com.seal.api.gwf.dto.create.BusinessForm;
import com.seal.api.gwf.entity.BusinessEntity;
import com.seal.api.gwf.repository.BusinessRepository;
import com.seal.api.gwf.util.S3Util;
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

    public List<Business> getByAccountID(int id) {
        ArrayList<BusinessEntity> bu = (ArrayList<BusinessEntity>) businessRepository.getByAccountID(id);
        ArrayList<Business> list = new ArrayList<>();
        for (BusinessEntity j :
                bu) {
            list.add(mapper.map(j, Business.class));
        }
        return list;
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

    public Integer createBu(BusinessForm bf) {
        String fileName = bf.getBusinessLogo().getOriginalFilename();
        String message = "";
        String link = "";
        try {
            link = S3Util.uploadFile(fileName, bf.getBusinessLogo().getInputStream());
            message = "Your file has been uploaded successfully!\n";
        } catch (Exception ex) {
            message = "Error uploading file: " + ex.getMessage();
        }
        System.out.println(message);
        int result = businessRepository.addBusiness(bf.getLocationID(), bf.getAccountID(), bf.getAddress(), bf.getBusinessName(),
                link, bf.getDescription(), bf.getBenefit());
        return result;
    }

    public Integer updateBu(BusinessForm bf) {
        BusinessEntity be = businessRepository.getByID(bf.getBusinessID());
        String fileName = bf.getBusinessLogo().getOriginalFilename();
        String link = "";
        if (fileName == "")
            link = be.getBusinessLogo();
        else {
            String message = "";
            try {
                link = S3Util.uploadFile(fileName, bf.getBusinessLogo().getInputStream());
                message = "Your file has been uploaded successfully!\n";
            } catch (Exception ex) {
                message = "Error uploading file: " + ex.getMessage();
            }
            System.out.println(message);
        }
        if (bf.getLocationID() == null){
            bf.setLocationID(be.getLocation().getLocationID());
        }
        if (bf.getAddress() == null){
            bf.setAddress(be.getAddress());
        }
        if (bf.getBusinessName() == null){
            bf.setBusinessName(be.getBusinessName());
        }
        if (bf.getDescription() == null){
            bf.setDescription(be.getDescription());
        }
        if (bf.getBenefit() == null){
            bf.setBenefit(be.getBenefit());
        }

        int result = businessRepository.updateBusiness(be.getBusinessID(), bf.getLocationID(), bf.getAddress(), bf.getBusinessName(),
                link, bf.getDescription(), bf.getBenefit(), bf.getAccountID());
        return result;
    }
}
