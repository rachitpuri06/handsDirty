/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.dto;

/**
 *
 * @author root
 */
public class NodeEventListDTO{
    
    private EventListDTO events;
    
    private Long id;

    public EventListDTO getEvents() {
        return events;
    }

    public void setEvents(EventListDTO events) {
        this.events = events;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    
    
    
}