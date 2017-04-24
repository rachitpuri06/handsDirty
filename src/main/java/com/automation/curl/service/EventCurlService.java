/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.curl.service;

import com.automation.dto.EventListDTO;
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

/*
 * @author root
 */
@Service
public class EventCurlService {

    @Autowired
    FacebookAccessTokenService fService;

    Logger logger = LoggerFactory.getLogger(EventCurlService.class);

    private final String searchUrl = FacebookConstants.FACEBOOK_BASE_URL + "search";
    private final String eventFields = "fields=attending_count,category,guest_list_enabled,"
            + "can_guests_invite,cover,declined_count,description,end_time,id,"
            + "interested_count,is_canceled,is_page_owned,is_viewer_admin,maybe_count,"
            + "name,noreply_count,owner,parent_group,place,start_time,ticket_uri,"
            + "timezone,type,updated_time";

    public EventListDTO getEventsFromLocationSearch(String location) {  
        try {
            logger.info("Fetching infomation for location " + location);
            String eventUrl = "";
            eventUrl = searchUrl + "?type=event&q=" +  URLEncoder.encode(location, "UTF-8")
                    + "&" + eventFields;
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
            EventListDTO eventsDTO = gson.fromJson(response, EventListDTO.class);
            //eventsDTO.getData().get(0).getStart_time().toDate()
            return eventsDTO;
        } catch (Exception ex) {
            logger.error("ERROR in fetching ", ex);
        }
        return null;
    }

}
