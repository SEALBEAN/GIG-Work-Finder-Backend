package com.seal.api.gwf.controller;

import com.seal.api.gwf.service.JobMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("JobMap")
public class JobMappingController {
    @Autowired
    JobMapService jobMapService;

    @PutMapping("/Confirm/{mid}")
    public ResponseEntity<?> confirm(@PathVariable int mid){
        try {
            Integer result = jobMapService.confirm(mid);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace());
        }
    }

    @PutMapping("/Finish/{mid}")
    public ResponseEntity<?> finish(@PathVariable int mid){
        try {
            Integer result = jobMapService.finish(mid);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace());
        }
    }

    @PutMapping("/Cancel/{mid}")
    public ResponseEntity<?> cancel(@PathVariable int mid){
        try {
            Integer result = jobMapService.cancel(mid);
            if (result == 1)
                return ResponseEntity.ok(HttpStatus.OK);
            else
                return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(null);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace());
        }
    }
}
