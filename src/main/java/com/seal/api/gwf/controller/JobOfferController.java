package com.seal.api.gwf.controller;

import com.seal.api.gwf.entity.JobOfferEntity;
import com.seal.api.gwf.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("JobOffer")
public class JobOfferController {

    @Autowired
    JobOfferService jobOfferService;

    @GetMapping("/ID/{id}")
    public JobOfferEntity getByOfferID(@PathVariable int id) {return jobOfferService.findByOfferID(id);}

    @GetMapping("/LID/{id}")
    public List<JobOfferEntity> getByLocationID(@PathVariable int id) {return jobOfferService.findByLocationID(id);}

    @GetMapping("/AID/{id}")
    public List<JobOfferEntity> getByAccountID(@PathVariable int id) {return jobOfferService.findByAccountID(id);}

    @GetMapping("/ALL")
    public List<JobOfferEntity> getAllJobOffers() {return jobOfferService.getAllJobOffers();}

    @GetMapping("/GetHurry")
    public List<JobOfferEntity> getHurryJobOffers(){return jobOfferService.getHurryJobOffers();}

    @GetMapping("/GetPopular")
    public List<JobOfferEntity> getPopularJobOffers() {return jobOfferService.getPopularJobOffers();}

//    @PostMapping("/ID")
//    public JobOfferEntity getByOfferID(@RequestParam int id) {return jobOfferService.findByOfferID(id);}


}
