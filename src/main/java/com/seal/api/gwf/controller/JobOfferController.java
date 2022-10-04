package com.seal.api.gwf.controller;

import com.seal.api.gwf.entity.JobOfferEntity;
import com.seal.api.gwf.service.JobOfferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "JobOffer")
public class JobOfferController {

    @Autowired
    JobOfferService jobOfferService;

    @GetMapping("/ID/{id}")
    public JobOfferEntity getByOfferID(@PathVariable int id) {return jobOfferService.findByOfferID(id);}

    @RequestMapping(value = { "/ALL"})
    @ResponseBody
    public List<JobOfferEntity> getAllJobOffers(@RequestParam(required = false) Integer limit) {
        if (limit == null)
            return jobOfferService.getAllJobOffers();
        else
            return jobOfferService.getAllJobOffers(limit);
    }
    @GetMapping("/GetHurry")
    public List<JobOfferEntity> getHurryJobOffers(){return jobOfferService.getHurryJobOffers();}

    @GetMapping("/GetPopular")
    public List<JobOfferEntity> getPopularJobOffers() {return jobOfferService.getPopularJobOffers();}


}
