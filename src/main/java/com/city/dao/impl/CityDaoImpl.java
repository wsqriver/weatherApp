package com.city.dao.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.AmazonDynamoDBException;
import com.city.bean.City;
import com.city.dao.CityDao;
import com.tools.ExceptionEnumMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CityDaoImpl implements CityDao {

//    @Autowired
//    DynamoDBMapper dynamoDBMapper;
    @Autowired
    City city1;
    @Autowired
    City city2;
    @Autowired
    City city3;

    private  final Logger logger = LoggerFactory.getLogger(CityDaoImpl.class);
    @Override
    public JSONObject getCitybyId(String cityId) {
//                //if get result from DB.
//        boolean flag=true;
//        JSONObject params= null;
//        try {
//            params = JSONObject.parseObject(JSON.toJSONString(dynamoDBMapper.load(City.class, cityId)));
//        }catch (AmazonDynamoDBException e){
//            params=null;
//            logger.error(ExceptionEnumMsg.NOTFOUNDCITY.getErrorCode());
//        }catch (Exception e){
//            params=null;
//            logger.error(ExceptionEnumMsg.NOTFOUNDCITY.getErrorCode());
//        }
//        return params;

        //get result from mock data
        JSONObject returnJason;
        switch (cityId){
            case "1":
                returnJason=(JSONObject) JSON.toJSON(city1);
                break;
            case "2":
                returnJason=(JSONObject) JSON.toJSON(city2);
                break;
            case "3":
                returnJason=(JSONObject) JSON.toJSON(city3);
                break;
            default:
                returnJason=null;
        }
        return returnJason;
    }
}
