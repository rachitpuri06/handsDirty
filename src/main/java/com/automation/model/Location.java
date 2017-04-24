/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author root
 */
@Entity
@Table
public class Location extends TimeStamp{

    private final static long serialVersionUID = 5924361831551833717L;
    
    @Id
    @Column
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column
    private String name;
    
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastProcessedDate; 
    
    @Column
    private Long lastProcessedEventId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastProcessedDate() {
        return lastProcessedDate;
    }

    public void setLastProcessedDate(Date lastProcessedDate) {
        this.lastProcessedDate = lastProcessedDate;
    }

    public Long getLastProcessedEventId() {
        return lastProcessedEventId;
    }

    public void setLastProcessedEventId(Long lastProcessedEventId) {
        this.lastProcessedEventId = lastProcessedEventId;
    }
    
    
    
}
