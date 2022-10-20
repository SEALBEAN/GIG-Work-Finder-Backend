package com.seal.api.gwf.service;


import com.seal.api.gwf.dto.Recruiter;
import com.seal.api.gwf.entity.RecruiterEntity;
import com.seal.api.gwf.repository.RecruiterRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecruiterService {
    @Autowired
    RecruiterRepository recruiterRepository;

    @Autowired
    private ModelMapper mapper;

//    public Recruiter getByAccountID(int id){
//        RecruiterEntity recruiter =  recruiterRepository.findByAccountID(id);
//        return mapper.map(recruiter, Recruiter.class);
//    }

    public RecruiterEntity getByAccountID(int id){return recruiterRepository.findByAccountID(id);}

    public Integer updateR(Recruiter re) {
        RecruiterEntity ree = recruiterRepository.findByAccountID(re.getAccountID());
        if (re.getFirstName() == null) {
            if (ree.getFirstName() != null)
                re.setFirstName(ree.getFirstName());
        }
        if (re.getLastName() == null) {
            if (ree.getLastName() != null)
                re.setLastName(ree.getLastName());
        }
        if (re.getPhone() == null) {
            if (ree.getPhone() != null)
                re.setPhone(ree.getPhone());
        }
        if (re.getGender() == null) {
            if (ree.getGender() != null)
                re.setGender(ree.getGender());
        }
        if (re.getEmail() == null) {
            if (ree.getEmail() != null)
                re.setEmail(ree.getEmail());
        }
        if (re.getDescription() == null) {
            if (ree.getDescription() != null)
                re.setDescription(ree.getDescription());
        }

        Integer result = recruiterRepository.updateRecruiter(re.getAccountID(), re.getFirstName(), re.getLastName(), re.getPhone(), re.getGender(), re.getEmail(), re.getDescription());
        return result;
    }
}
