/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.curl.service;

import com.automation.dto.EventListDTO;
import com.automation.dto.NodeEventListDTO;
import com.automation.service.FacebookAccessTokenService;
import com.automation.util.CurlHandler;
import com.automation.util.DateTimeSerilaizer;
import com.automation.util.FacebookConstants;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.net.URLEncoder;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author root
 */
@Service
public class EventFetchFromNodeService {

    @Autowired
    FacebookAccessTokenService fService;

    Logger logger = LoggerFactory.getLogger(EventFetchFromNodeService.class);

    private final String eventFeildsFromNode = "events{attending_count,category,"
            + "guest_list_enabled,can_guests_invite,cover,declined_count,"
            + "description,end_time,id,interested_count,is_canceled,"
            + "is_page_owned,is_viewer_admin,maybe_count,name,noreply_count,"
            + "owner,parent_group,place,start_time,ticket_uri,"
            + "timezone,type,updated_time}";

    public EventListDTO getEventsFromNodeId(String nodeId) {
        try {
            logger.info("Fetching infomation for nodeId " + nodeId);
            String eventUrl = "";
            eventUrl = FacebookConstants.FACEBOOK_BASE_URL + nodeId + "?fields="
                    + URLEncoder.encode(eventFeildsFromNode, "UTF-8");
            eventUrl = eventUrl + "&access_token=" + fService.getAccessToken();
            return getEventsFromUrl(eventUrl);
        } catch (Exception ex) {
            logger.error("ERROR in fetching ", ex);
        }
        return null;
    }

    public EventListDTO getEventsFromUrl(String eventUrl) {
        try {
            String response = CurlHandler.getRequest(eventUrl);
            Gson gson = new GsonBuilder().registerTypeAdapter(DateTime.class, new DateTimeSerilaizer()).create();
            NodeEventListDTO nodeEventListDTO = gson.fromJson(response, NodeEventListDTO.class);
            if (nodeEventListDTO.getEvents() != null) {
                return nodeEventListDTO.getEvents();
            }
            return null;
        } catch (Exception ex) {
            logger.error("ERROR in fetching ", ex);
        }
        return null;
    }

}
