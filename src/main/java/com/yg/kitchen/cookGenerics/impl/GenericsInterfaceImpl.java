package com.yg.kitchen.cookGenerics.impl;

import com.yg.kitchen.cookGenerics.GenericsInterface;

/**
 * Created by guang.yang on 18-2-9.
 */
public class GenericsInterfaceImpl<T,K> implements GenericsInterface<T> {

    public GenericsInterfaceImpl(T t,K k){
        this.setKey(k);
        this.setVar(t);
    }

    @Override
    public void setVar(T t) {
        System.out.println("Var : "+t.getClass());
    }

    public void setKey(K k){
        System.out.println("Key : "+k.getClass());
    }
}
