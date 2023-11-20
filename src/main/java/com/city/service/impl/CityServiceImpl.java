package com.city.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.city.dao.CityDao;
import com.city.service.CityService;
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
