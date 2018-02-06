package com.example.helloActiviti.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by guang.yang on 2017-11-09.
 */
@RestController
public class helloActivitiController {
    @RequestMapping(value = "/helloActiviti",method = RequestMethod.GET)
    public ModelAndView hello(){
        ModelAndView modelAndView = new ModelAndView("workflow");
        return modelAndView;
    }

}


