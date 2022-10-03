package com.seal.api.gwf.controller;

import com.seal.api.gwf.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("Location")
public class LocationController {
    @Autowired
    LocationService locationService;

    @GetMapping("/Province/ALL")
    public List<String> getAllProvince() {return locationService.getAllProvince();}

    @GetMapping("/City/{province}")
    public List<String> getCitysByProvince(@PathVariable String province) {return locationService.getCitysByProvince(province);}
}
