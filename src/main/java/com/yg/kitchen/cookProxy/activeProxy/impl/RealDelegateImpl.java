package com.yg.kitchen.cookProxy.activeProxy.impl;


import com.yg.kitchen.cookProxy.activeProxy.PublicInterface;

/**
 * Created by guang.yang on 2017-12-14.
 */
public class RealDelegateImpl implements PublicInterface {
    @Override
    public void hello(String str) {
        System.out.print("I am real hello.");
    }

    @Override
    public void rent() {
        System.out.println("I am real rent.");
    }
}
