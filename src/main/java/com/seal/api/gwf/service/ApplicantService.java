package com.seal.api.gwf.service;


import com.seal.api.gwf.dto.Applicant;
import com.seal.api.gwf.dto.create.ApplicantForm;
import com.seal.api.gwf.entity.ApplicantEntity;
import com.seal.api.gwf.repository.ApplicantRepository;
import com.seal.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ApplicantService {
    @Autowired
    ApplicantRepository applicantRepository;

    public Integer updateApp(ApplicantForm app) {
        ApplicantEntity appe = applicantRepository.getByAccountID(app.getAccountID());

        Object dob;
        if (app.getDob() != null) {
            dob = appe.getDob();
        } else {
            dob = Timestamp.valueOf(LocalDateTime.parse(app.getDob().toString(), Utils.DAYFORMATDDMMYYYY));
        }

        if (app.getLocationID() == null) {
            if (appe.getLocation() != null)
                app.setLocationID(appe.getLocation().getLocationID());
        }
        if (app.getDegreeID() == null) {
            if (appe.getDegree() != null)
                app.setDegreeID(appe.getDegree().getDegreeID());
        }
        if (app.getFirstName() == null) {
            if (appe.getFirstName() != null)
                app.setFirstName(appe.getFirstName());
        }
        if (app.getLastName() == null) {
            if (appe.getLastName() != null)
                app.setLastName(appe.getLastName());
        }
        if (app.getPhone() == null) {
            if (appe.getPhone() != null)
                app.setPhone(appe.getPhone());
        }
        if (app.getGender() == null) {
            if (appe.getGender() != null)
                app.setGender(appe.getGender());
        }
        if (app.getAddress() == null) {
            if (appe.getAddress() != null)
                app.setAddress(appe.getAddress());
        }
        if (app.getDescription() == null) {
            if (appe.getDescription() != null)
                app.setDescription(appe.getDescription());
        }
        int result = applicantRepository.updateApp(appe.getAccountID(), app.getLocationID(), app.getDegreeID(), app.getFirstName(), app.getLastName(), app.getPhone()
                                                    , dob, app.getGender(), app.getAddress(), app.getDescription());
        return result;
    }

    public ApplicantEntity getByAccountID(int id) {return applicantRepository.findById(id).get();}

    public List<ApplicantEntity> getAllApplicants () {return applicantRepository.findAll();}
}
