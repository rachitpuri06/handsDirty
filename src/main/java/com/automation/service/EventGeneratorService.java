/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.service;

import com.automation.curl.service.EventCurlService;
import com.automation.curl.service.EventFetchFromNodeService;
import com.automation.dto.EventDTO;
import com.automation.dto.EventListDTO;
import com.automation.model.Event;
import com.automation.model.FacebookPage;
import com.automation.model.Location;
import java.util.List;
import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author root
 */
@Service
public class EventGeneratorService {

    @Autowired
    TransactionService txnService;

    @Autowired
    FacebookAccessTokenService fService;

    @Autowired
    EventCurlService eventCurlService;

    @Autowired
    EventFetchFromNodeService eventFetchFromNodeService;

    @Autowired
    Mapper mapper;

    @Autowired
    FacebookPlaceService facebookPlaceService;

    Logger logger = LoggerFactory.getLogger(EventGeneratorService.class);

    public void initiateCron() {
        //populateEventsFromLocation();
        populateEventFromVenueAndLocation();
        logger.info("Gracefull exit, whoopie!!");
    }

    private void populateEventFromVenueAndLocation() {
        List<FacebookPage> facebookPages = txnService.getFacebookPages();
        for (FacebookPage facebookPage : facebookPages) {
            String nodeId = String.valueOf(facebookPage.getId());
            EventListDTO eventsDTO = eventFetchFromNodeService.getEventsFromNodeId(nodeId);
            extractEventInformationFromNodeId(eventsDTO, facebookPage.getType(),
                    nodeId);
        }
    }

    private void populateEventsFromLocation() {
        List<Location> locations = txnService.getLocations();
        for (Location location : locations) {
            EventListDTO eventsDTO = eventCurlService.
                    getEventsFromLocationSearch(location.getName());
            extractEventInformationFromNodeId(eventsDTO, "location", location.getName());
        }
    }

    private void extractEventInformationFromNodeId(EventListDTO eventsDTO,
            String type, String nodeId) {
        Boolean flag = Boolean.TRUE;
        logger.info("Getting further pages from " + type + " for " + nodeId);
        while (true) {
            if (eventsDTO != null && eventsDTO.getData() != null) {
                for (EventDTO eventDTO : eventsDTO.getData()) {
                    try {
                        Event event = setEventFromEventDTO(eventDTO);
                        if (event.getStart_time().getMillis() < System.currentTimeMillis()) {
                            logger.info("Skipping the entry");
                            flag = Boolean.FALSE;

                        }
                        getOwnerAttributeFromEvent(event);
                        getVenueAttributesFromEvent(event);
                        txnService.saveEvent(event);
                    } catch (Exception ex) {
                        logger.error("ERROR in saving event ", ex);
                    }
                }
                if (eventsDTO.getData().size() > 0 && eventsDTO.getPaging() != null
                        && flag) {
                    logger.info("Getting further pages from " + type + " for " + nodeId);
                    eventsDTO = eventCurlService.getEventsFromUrl(
                            eventsDTO.getPaging().getNext());
                } else {
                    break;
                }
            } else {
                break;
            }
        }
    }

    private void getVenueAttributesFromEvent(Event event) {
        if (event.getPlaceId() != null) {
            FacebookPage facebookPage = facebookPlaceService.
                    dumpPagesAttributesFromEventVenue(
                            event.getPlaceId(), "venue");
            event.getCategories().addAll(facebookPage.getCategories());
            event.setVenueName(event.getOwnerName());
        } else {
            logger.info("OwnerId might not be a page "
                    + event.getOwnerId());
        }
    }

    private void getOwnerAttributeFromEvent(Event event) {
        if (event.getOwnerId() != null && event.getIs_page_owned()) {
            FacebookPage facebookPage = facebookPlaceService.
                    dumpPagesAttributesFromEventVenue(
                            event.getOwnerId(), "page");
            event.getCategories().addAll(facebookPage.getCategories());
            event.setOwnerName(event.getOwnerName());
        } else {
            logger.info("OwnerId might not be a page "
                    + event.getOwnerId());
        }
    }

    private Event setEventFromEventDTO(EventDTO eventDTO) {
        Event event = mapper.map(eventDTO, Event.class);
        event.setStart_time(eventDTO.getStart_time());
        event.setEnd_time(eventDTO.getEnd_time());
        event.setCover_url(eventDTO.getCover() == null ? null : eventDTO.getCover().getSource());
        event.setOwnerId(eventDTO.getOwner() == null ? null : eventDTO.getOwner().getId());
        if (eventDTO.getPlace() != null) {
            event.setPlaceId(eventDTO.getPlace().getId());
            if (eventDTO.getPlace().getLocation() != null) {
                event.setCity(eventDTO.getPlace().getLocation().getCity());
                event.setCountry(eventDTO.getPlace().getLocation().getCountry());
                event.setLatitude(eventDTO.getPlace().getLocation().getLatitude());
                event.setLongitude(eventDTO.getPlace().getLocation().getLongitude());
                event.setStreet(eventDTO.getPlace().getLocation().getStreet());
                event.setZip(eventDTO.getPlace().getLocation().getZip());
            }
        }
        return event;

    }
}
