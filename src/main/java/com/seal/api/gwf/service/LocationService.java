package com.seal.api.gwf.service;

import com.seal.api.gwf.dto.create.City;
import com.seal.api.gwf.entity.LocationEntity;
import com.seal.api.gwf.repository.LocationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LocationService {
    @Autowired
    LocationRepository locationRepository;
    @Autowired
    private ModelMapper mapper;

    public LocationEntity getByID(int id) {return  locationRepository.findById(id).get();}
    public List<String> getAllProvince() {return locationRepository.getAllProvince();}

    public List<City> getCitysByProvince(String province) {
        List<LocationEntity> location = locationRepository.getCitysByProvince(province);
        ArrayList<City> result = new ArrayList<>();
        for (LocationEntity je:
             location) {
            result.add(mapper.map(je, City.class));
        }
        return result;
    }
}
