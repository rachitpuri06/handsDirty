/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.controller;

import com.automation.facade.EventCollectorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author rachit
 */
@Controller
@RequestMapping(value = "/cron")
public class EventCollectorController {
    
    @Autowired
    EventCollectorFacade eventCollectorFacade;
    
    @RequestMapping(value = "/test", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody Object test(){
        eventCollectorFacade.test();
        return "hello world";
    }
    
}
