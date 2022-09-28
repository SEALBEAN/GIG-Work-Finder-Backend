package com.seal.testdb;

import com.seal.testdb.Entity.LocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Location/1loc")
public class LocationController {

    @Autowired
    private LocationService locationService;
    @GetMapping("/{as}")
    public List<LocationEntity> loc(@PathVariable String as){
        //return locationService.find(1);


        List<LocationEntity> lists =  locationService.findByCity(as);
        return lists;
//        List<LocationEntity> lists =  locationService.findByCity("Huyện Châu Thành");
//        List<DTO> result = new ArrayList<>();
//        for (LocationEntity loc: lists) {
//            DTO dto  = new DTO(loc);
//            result.add(dto);
//        }
//        return result;
    }

    @PostMapping()
    public int loc1(@RequestParam String username, @RequestParam String password, @RequestParam String name) {
        return locationService.insertAdmin(username, password, name);
    }


}
