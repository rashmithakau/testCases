package com.demo.Demo.controller;

import com.demo.Demo.service.CityService;
import com.demo.Demo.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/city")
public class CityController {
    @Autowired
   private CityService cityService;


    @GetMapping("/get-city/{postalCode}")
    public Map<String,String> getCity(@PathVariable("postalCode")String postalCode){
        return cityService.getCityByPostalCode(postalCode);
    }

}
