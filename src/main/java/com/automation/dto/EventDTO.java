/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.dto;

import org.joda.time.DateTime;

/**
 *
 * @author root
 */
public class EventDTO {
 
    private Long attending_count;
    
    private String category;
    
    private Boolean guest_list_enabled;
    
    private Boolean can_guests_invite;
    
    private CoverDTO cover;
    
    private Long declined_count;
    
    private String description;
    
    private DateTime end_time;
    
    private Long id;
    
    private Long interested_count;
    
    private Boolean is_canceled;
    
    private Boolean is_page_owned;
    
    private Boolean is_viewer_admin;
    
    private Long maybe_count;
    
    private String name;
    
    private Long noreply_count;
    
    private OwnerDTO owner;
    
    private PlaceDTO place;
    
    private DateTime start_time;
    
    private String ticket_uri;
    
    private String type;
    
    private String timezone;

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Long getAttending_count() {
        return attending_count;
    }

    public void setAttending_count(Long attending_count) {
        this.attending_count = attending_count;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getGuest_list_enabled() {
        return guest_list_enabled;
    }

    public void setGuest_list_enabled(Boolean guest_list_enabled) {
        this.guest_list_enabled = guest_list_enabled;
    }

    public Boolean getCan_guests_invite() {
        return can_guests_invite;
    }

    public void setCan_guests_invite(Boolean can_guests_invite) {
        this.can_guests_invite = can_guests_invite;
    }

    public CoverDTO getCover() {
        return cover;
    }

    public void setCover(CoverDTO cover) {
        this.cover = cover;
    }

    public Long getDeclined_count() {
        return declined_count;
    }

    public void setDeclined_count(Long declined_count) {
        this.declined_count = declined_count;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DateTime getEnd_time() {
        return end_time;
    }

    public void setEnd_time(DateTime end_time) {
        this.end_time = end_time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInterested_count() {
        return interested_count;
    }

    public void setInterested_count(Long interested_count) {
        this.interested_count = interested_count;
    }

    public Boolean getIs_canceled() {
        return is_canceled;
    }

    public void setIs_canceled(Boolean is_canceled) {
        this.is_canceled = is_canceled;
    }

    public Boolean getIs_page_owned() {
        return is_page_owned;
    }

    public void setIs_page_owned(Boolean is_page_owned) {
        this.is_page_owned = is_page_owned;
    }

    public Boolean getIs_viewer_admin() {
        return is_viewer_admin;
    }

    public void setIs_viewer_admin(Boolean is_viewer_admin) {
        this.is_viewer_admin = is_viewer_admin;
    }

    public Long getMaybe_count() {
        return maybe_count;
    }

    public void setMaybe_count(Long maybe_count) {
        this.maybe_count = maybe_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getNoreply_count() {
        return noreply_count;
    }

    public void setNoreply_count(Long noreply_count) {
        this.noreply_count = noreply_count;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }

    public PlaceDTO getPlace() {
        return place;
    }

    public void setPlace(PlaceDTO place) {
        this.place = place;
    }

    public DateTime getStart_time() {
        return start_time;
    }

    public void setStart_time(DateTime start_time) {
        this.start_time = start_time;
    }

    public String getTicket_uri() {
        return ticket_uri;
    }

    public void setTicket_uri(String ticket_uri) {
        this.ticket_uri = ticket_uri;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
