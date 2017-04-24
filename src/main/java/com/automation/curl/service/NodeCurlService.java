/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.curl.service;

import com.automation.dto.FacebookPageDTO;
import com.automation.service.FacebookAccessTokenService;
import com.automation.util.CurlHandler;
import com.automation.util.FacebookConstants;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author root
 */
@Service
public class NodeCurlService {

    @Autowired
    FacebookAccessTokenService fService;

    Logger logger = LoggerFactory.getLogger(NodeCurlService.class);

    private final String ownerField = "about,bio,business,company_overview,"
            + "checkins,category,category_list,contact_address,cover,"
            + "current_location,description,founded,genre,hometown,"
            + "location,name,name_with_location_descriptor,"
            + "overall_star_rating,network,fan_count,"
            + "rating_count,id";

    public FacebookPageDTO getFacebookPageInfo(String nodeId ) {
        FacebookPageDTO facebookPageDTO = null;
        try {
            String url = FacebookConstants.FACEBOOK_BASE_URL + nodeId
                    + "?fields=" + ownerField + "&access_token=" + fService.getAccessToken();
            String response = CurlHandler.getRequest(url);
            Gson gson = new Gson();
            facebookPageDTO = gson.fromJson(response, FacebookPageDTO.class);
           
        } catch (Exception ex) {
            logger.error("Error in curl ", ex);
            logger.error("NodeId for reference ", nodeId);
        }
        return facebookPageDTO;
    }
}
