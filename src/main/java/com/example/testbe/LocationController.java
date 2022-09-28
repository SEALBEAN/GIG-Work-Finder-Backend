package com.example.testbe;

import com.example.testbe.Entity.LocationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Location")
public class LocationController {

    @Autowired
    private LocationService locationService;
    @GetMapping("/1/{as}")
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

    @GetMapping("/2")
    public LocationEntity loc2(){
        return locationService.find(1);
    }

    @GetMapping("/3")
    public String loc3(){
        return "Hello World";
    }

    @PostMapping()
    public int loc1(@RequestParam String username, @RequestParam String password, @RequestParam String name) {
        return locationService.insertAdmin(username, password, name);
    }


}
