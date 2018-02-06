package com.yg.kitchen.cookProxy.activeProxy.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by guang.yang on 2017-12-14.
 */
public class DynamicProxy implements InvocationHandler {

//    @Autowired
    private Object subject;   //要代理的对象

    public DynamicProxy(Object subject){
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("do Pre-Process");

        method.invoke(subject,args);

        System.out.println("do After-Process");

        return null;

    }
}
