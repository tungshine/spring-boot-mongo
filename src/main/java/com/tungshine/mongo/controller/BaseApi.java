package com.tungshine.mongo.controller;

import java.util.HashMap;
import java.util.Map;

/**
 * @author TangXu
 * @create 2018-11-26 16:59
 * @description:
 */
public class BaseApi {

    public Map<String, Object> returnSuccess(Object object) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "success");
        map.put("result", 0);
        map.put("data", object);
        return map;
    }

    public Map<String, Object> returnError(String msg, int error_code) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", msg);
        map.put("result", error_code);
        return map;
    }
}