package com.yg.kitchen.cookProxy.activeProxy;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import com.yg.kitchen.cookProxy.activeProxy.impl.DynamicProxy;
import com.yg.kitchen.cookProxy.activeProxy.impl.RealDelegateImpl;

/**
 * Created by guang.yang on 2017-12-14.
 */
public class Client {
    public static void main(String[] args){
        PublicInterface realDelegate = new RealDelegateImpl();

        //将要代理的对象塞给代理
        InvocationHandler handler = new DynamicProxy(realDelegate);
        //创建代理对象,Proxy返回的是代理对象？？
        PublicInterface publicInterface = (PublicInterface) Proxy.newProxyInstance(handler.getClass().getClassLoader(),
            realDelegate.getClass().getInterfaces(),handler);

        System.out.println(publicInterface.getClass().getName());
        publicInterface.rent();
        publicInterface.hello("world");

    }
}
