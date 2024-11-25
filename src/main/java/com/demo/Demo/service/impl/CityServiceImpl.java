package com.demo.Demo.service.impl;

import com.demo.Demo.service.CityService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@Service
public class CityServiceImpl implements CityService {
    public Map<String,String> getCityByPostalCode(String postalCode){
        HashMap<String,String> cityList=new HashMap<>();
        cityList.put("10400","Moratuwa");
        cityList.put("3002","Kaluthara");



        String s=cityList.get(postalCode);
        if(StringUtils.hasText(s)){ //Check null and ""
            return Collections.singletonMap("city",s);
        }
        return Collections.singletonMap("city","No city Available");
    }
}

//response entity
//create a respons entity for a create a custom responses