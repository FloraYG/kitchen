package com.yg.kitchen.cookGenerics;

import com.yg.kitchen.cookGenerics.impl.GenericsInterfaceImpl;

/**
 * Created by guang.yang on 18-2-9.
 */
public class main {
    public static void main(String[] args) {
        GenericsInterface<String> genericsInterface = new GenericsInterfaceImpl<String,Integer>("Test",1);
    }
}
