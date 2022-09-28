package com.seal.testdb;

import com.seal.testdb.Entity.LocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService{
    @Autowired
    LocationRepository locationRepository;

    public LocationEntity find(int iD){
        return locationRepository.findById(iD).get();
    }
    public List<LocationEntity> findByCity(String s){
        return locationRepository.findByCity(s);
    }

    public int insertAdmin(String user, String password, String name){
        return locationRepository.insertAdmin(user, password, name);
    }

}
