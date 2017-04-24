/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.dao;

import com.automation.model.Event;
import org.springframework.stereotype.Repository;

/**
 * @author root
 */
@Repository
public class EventDao extends GenericDAO<Event>{
    
    public EventDao(){
        setClazz(Event.class);
    }
}
