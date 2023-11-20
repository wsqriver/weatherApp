package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.service.CityService;
import com.tools.ExceptionEnumMsg;
import com.tools.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/city")
public class CityController {
    @Autowired
    private CityService cityService;
    @GetMapping(value = "/getCityById")
    public ResponseUtils getCityById(@RequestParam String cityId){
        //todo mandortory check&&format
        //get data by id
        JSONObject userMsg = cityService.getCitybyId(cityId);
        //if userMsg==null which means can not find data or connection error
        if (userMsg==null){
            return ResponseUtils.fail(ExceptionEnumMsg.NOTFOUNDCITY.getErrorCode(),ExceptionEnumMsg.NOTFOUNDCITY.getErrorMSG());
        }
        return ResponseUtils.success(userMsg);
    }
}
