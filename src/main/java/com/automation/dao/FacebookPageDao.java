/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.dao;

import com.automation.model.FacebookPage;
import com.automation.util.QueryConstants;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 * @author root
 */
@Repository
public class FacebookPageDao extends GenericDAO<FacebookPage>{
    
     public FacebookPage facebookPageFindById(Long id){
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("id",id);
        return findByNamedQueryUnique(QueryConstants.FacebookPageById, paramsMap);
    }

    public FacebookPageDao() {
        setClazz(FacebookPage.class);
    }
     
     
}
