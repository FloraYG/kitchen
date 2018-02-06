package com.example.helloActiviti.service.impl;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Component;

/**
 * Created by guang.yang on 2017-11-02.
 */
@Component
public class SendMailServiceImpl implements JavaDelegate{


    public void execute(DelegateExecution execution) throws Exception {
        System.out.print("abc");

    }
}
