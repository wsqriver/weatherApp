package com.city.dao;

import com.alibaba.fastjson.JSONObject;

public interface CityDao {
     JSONObject getCitybyId(String cityId);
}
