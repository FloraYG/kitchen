package com.example.helloActiviti.service.impl;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * Created by guang.yang on 2017-11-08.
 */
public class GenerateAttributeImpl implements JavaDelegate {
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Generate Attribute:Converting...");
        System.out.println("Generate Attribute:Mapmatching...");
        System.out.println("Generate Done.");
        System.out.println("=========================================");
    }
}
