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
public class BusinessContrroller {
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
    //public ResponseEntity<?> createJO(@RequestBody BusinessForm businessLogo) {
        public ResponseEntity<?> createJO(@RequestParam("locationID") Integer locationID,
                                          @RequestParam("accountID") Integer accountID,
                                          @RequestParam(value = "address",required = false) String address,
                                          @RequestParam(value = "businessName", required = false) String businessName,
                                          @RequestParam(value = "businessLogo", required = false) MultipartFile businessLogo,
                                          @RequestParam(value = "description", required = false) String description,
                                          @RequestParam(value = "benefit" , required = false) String benefit) {
            try {
            String fileName = businessLogo.getOriginalFilename();
            System.out.println(fileName + businessName + locationID + accountID + address + description + benefit);
            BusinessForm bf = new BusinessForm(locationID, accountID, address, businessName, businessLogo, description, benefit);
            System.out.println(bf);
            Integer result = businessService.createBu(bf);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

    }
}
