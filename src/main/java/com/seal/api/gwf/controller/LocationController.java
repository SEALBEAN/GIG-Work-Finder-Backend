package com.seal.api.gwf.controller;

import com.seal.api.gwf.dto.create.City;
import com.seal.api.gwf.entity.LocationEntity;
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

    @GetMapping("/ID/{id}")
    public LocationEntity getByID(@PathVariable int id) {return locationService.getByID(id);}
    @GetMapping("/Province/ALL")
    public List<String> getAllProvince() {return locationService.getAllProvince();}

    @GetMapping("/City/{province}")
    public List<City> getCitysByProvince(@PathVariable String province) {return locationService.getCitysByProvince(province);}
}
