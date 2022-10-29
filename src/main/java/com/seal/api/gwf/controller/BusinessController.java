package com.seal.api.gwf.controller;

import com.seal.api.gwf.dto.Business;
import com.seal.api.gwf.dto.create.BusinessForm;
import com.seal.api.gwf.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("Business")
public class BusinessController {
    @Autowired
    BusinessService businessService;


    @GetMapping("/ID/{id}")
    public Business getById(@PathVariable int id) {return businessService.getByID(id);}

    @GetMapping("/AID/{aid}")
    public List<Business> getByAccountId(@PathVariable int aid) {return businessService.getByAccountID(aid);}

    @GetMapping(value = { "/ALL"})
    @ResponseBody
    public List<Business> getAllJobOffers(@RequestParam(required = false) Integer limit) {
        if (limit == null)
            return businessService.getAllBusiness(0);
        else
            return businessService.getAllBusiness(limit);
    }

    @PostMapping("/CreateBu")
        public ResponseEntity<?> createBu(@RequestParam("locationID") Integer locationID,
                                          @RequestParam("accountID") Integer accountID,
                                          @RequestParam(value = "address",required = false) String address,
                                          @RequestParam(value = "businessName", required = false) String businessName,
                                          @RequestParam(value = "businessLogo", required = false) MultipartFile businessLogo,
                                          @RequestParam(value = "description", required = false) String description,
                                          @RequestParam(value = "benefit" , required = false) String benefit) {
            try {
            BusinessForm bf = new BusinessForm(locationID, accountID, address, businessName, businessLogo, description, benefit);
            Integer result = businessService.createBu(bf);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace());
        }
    }

    @PutMapping("/UpdateBu")
    public ResponseEntity<?> UpdateBu(@RequestParam("businessID") Integer businessID,
                                      @RequestParam(value = "locationID", required = false) Integer locationID,
                                      @RequestParam("accountID") Integer accountID,
                                      @RequestParam(value = "address",required = false) String address,
                                      @RequestParam(value = "businessName", required = false) String businessName,
                                      @RequestParam(value = "businessLogo", required = false) MultipartFile businessLogo,
                                      @RequestParam(value = "description", required = false) String description,
                                      @RequestParam(value = "benefit" , required = false) String benefit) {
        try {
            BusinessForm bf = new BusinessForm(businessID, locationID, accountID, address, businessName, businessLogo, description, benefit);
            Integer result = businessService.updateBu(bf);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace());
        }
    }
}
