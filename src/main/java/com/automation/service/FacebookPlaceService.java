/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.service;

import com.automation.curl.service.NodeCurlService;
import com.automation.dto.CategoryListDTO;
import com.automation.dto.FacebookPageDTO;
import com.automation.model.FacebookPage;
import java.util.Arrays;
import org.dozer.Mapper;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author root
 */
@Service
public class FacebookPlaceService {

    @Autowired
    NodeCurlService nodeCurlService;

    @Autowired
    TransactionService txService;

    @Autowired
    Mapper mapper;

    Logger logger = Logger.getLogger(FacebookPlaceService.class);

    public FacebookPage dumpPagesAttributesFromEventVenue(Long nodeId,String type) {
        FacebookPage facebookPage = null;
        try {     
            facebookPage = txService.facebookPageById(nodeId);
            if (facebookPage == null) {
                logger.info("Fetching page for id " + nodeId);
                FacebookPageDTO facebookPageDTO = nodeCurlService.
                        getFacebookPageInfo(String.valueOf(nodeId));
                if (facebookPageDTO == null) {
                    return null;
                }
                facebookPageDTO.setType(type);
                facebookPage = this.map(facebookPageDTO);
                txService.saveFacebookPage(facebookPage);
            } else {
                logger.info("Page id information already present with in DB " + nodeId);
                return facebookPage;
            }
        } catch (Exception ex) {
            logger.error("Error in saving the data ", ex);
        }
        return facebookPage;
    }

    private FacebookPage map(FacebookPageDTO facebookPageDTO) {
        FacebookPage facebookVenue = mapper.map(facebookPageDTO, FacebookPage.class);
        if (facebookPageDTO.getCategory_list() != null) {
            for(CategoryListDTO categoryListDTO: facebookPageDTO.getCategory_list()){
                facebookVenue.getCategories().add(categoryListDTO.getName());
            }
            facebookVenue.getCategories().add(facebookPageDTO.getCategory());
            facebookVenue.setCategory(StringUtils.collectionToDelimitedString(
                    facebookVenue.getCategories(), " | "));
        }
        
        return facebookVenue;
    }

}
