package com.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.dao.CityDao;
import com.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityDao cityDao;
    @Override
    public JSONObject getCitybyId(String cityId) {
        return cityDao.getCitybyId(cityId);
    }
}
