package com.dao;

import com.alibaba.fastjson.JSONObject;

public interface CityDao {
    public JSONObject getCitybyId(String cityId);
}
