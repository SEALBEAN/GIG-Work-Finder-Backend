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

    @GetMapping(value = { "/ALL"})
    @ResponseBody
    public List<JobOfferEntity> getAllJobOffers(@RequestParam(required = false) Integer limit) {
        if (limit == null)
            return jobOfferService.getAllJobOffers(0);
        else
            return jobOfferService.getAllJobOffers(limit);
    }
    @GetMapping("/GetHurry")
    @ResponseBody
    public List<JobOfferEntity> getHurryJobOffers(@RequestParam(required = false) Integer limit){
        if (limit == null)
            return jobOfferService.getHurryJobOffers(0);
        else
            return jobOfferService.getHurryJobOffers(limit);
    }

    @GetMapping("/GetPopular")
    @ResponseBody
    public List<JobOfferEntity> getPopularJobOffers(@RequestParam(required = false) Integer limit) {
        if (limit == null)
            return jobOfferService.getPopularJobOffers(0);
        else
            return jobOfferService.getPopularJobOffers(limit);
    }


}
