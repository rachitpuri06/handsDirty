/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.service;

import com.automation.dao.EventDao;
import com.automation.dao.FacebookPageDao;
import com.automation.dao.LocationDao;
import com.automation.model.Event;
import com.automation.model.FacebookPage;
import com.automation.model.Location;
import com.automation.util.QueryConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author root
 */
@Service
@Transactional
public class TransactionService {

    Logger logger = LoggerFactory.getLogger(TransactionService.class);

    @Autowired
    private LocationDao locationDao;

    @Autowired
    private EventDao eventDao;
    
    @Autowired
    private FacebookPageDao facebookPageDao;
    

    public List<Location> getLocations() {
        return locationDao.findAll();
    }
    
    public List<FacebookPage> getFacebookPages(){
        return facebookPageDao.findAll();
    }

    public void saveEvent(Event event) {
        try {
           
            event.setCategory(StringUtils.collectionToDelimitedString(
                    event.getCategories(), " | "));
            eventDao.saveOrUpdate(event);
        } catch (Exception ex) {
            logger.error("ERROR in saving event ", ex);
        }
    }
    
    public void saveFacebookPage(FacebookPage facebookPage){
        try {
           facebookPageDao.saveOrUpdate(facebookPage);
        } catch (Exception ex) {
            logger.error("ERROR in saving event ", ex);
        }
    }
    
    public FacebookPage facebookPageById(Long id){
        return facebookPageDao.facebookPageFindById(id);
    }
    
   

}
