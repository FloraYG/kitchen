package com.yg.kitchen.cookGenerics.impl;

import java.util.List;

import com.alibaba.fastjson.JSON;
/**
 * Created by guang.yang on 18-2-9.
 */
public class GenericsMethodImpl {
    //方法返回泛型
    public <T> List<T> parseArray(String json, Class<T> object){
        List<T> modelList = JSON.parseArray(json,object);
        return modelList;
    }

    //泛型方法
    public <T> void parseArray(T json){

    }
}
