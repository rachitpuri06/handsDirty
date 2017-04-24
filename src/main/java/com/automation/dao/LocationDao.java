/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.dao;

import com.automation.model.Location;
import org.springframework.stereotype.Repository;

/**
 * @author root
 */
@Repository
public class LocationDao extends GenericDAO<Location>{
    
    public LocationDao(){
        setClazz(Location.class);
    }
            
    
}
