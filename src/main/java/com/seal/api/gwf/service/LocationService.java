package com.seal.api.gwf.service;

import com.seal.api.gwf.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;

    public List<String> getAllProvince() {return locationRepository.getAllProvince();}

    public List<String> getCitysByProvince(String province) {return locationRepository.getCitysByProvince(province);}
}
