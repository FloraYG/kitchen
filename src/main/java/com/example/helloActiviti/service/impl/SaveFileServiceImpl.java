package com.example.helloActiviti.service.impl;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Created by guang.yang on 2017-11-02.
 */
@Component
public class SaveFileServiceImpl implements JavaDelegate {

    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        System.out.println("Save file.");
        System.out.println("=========================================");
        throw new Exception(" I amd exception");
    }
}
