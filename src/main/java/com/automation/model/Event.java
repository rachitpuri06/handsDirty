/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

/**
 * @author root
 */
@Entity
@Table
public class Event extends TimeStamp{

    @Column
    private Integer attending_count = 0;
    @Column
    private String category;
    @Column
    private Boolean guest_list_enabled = Boolean.FALSE;
    @Column
    private Boolean can_guests_invite = Boolean.FALSE;
    @Column
    private String cover_url;
    @Column
    private Integer declined_count = 0;
    @Column(columnDefinition = "text")
    private String description;
    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime end_time;
    @Id
    @Column
    private Long id;
    @Column
    private Integer interested_count = 0;
    @Column
    private Boolean is_canceled = Boolean.FALSE;
    @Column
    private Boolean is_page_owned = Boolean.FALSE;
    @Column
    private Boolean is_viewer_admin = Boolean.FALSE;
    @Column
    private Integer maybe_count = 0;
    @Column(columnDefinition = "text")
    private String name;
    @Column
    private Integer noreply_count = 0;
    @Column
    private Long ownerId;
    @Column
    private Long placeId;
    @Column
    @Type(type="org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    private DateTime start_time;
    @Column(columnDefinition = "text")
    private String ticket_uri;
    @Column
    private String type;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String latitude;
    @Column
    private String longitude;
    @Column
    private String street;
    @Column
    private String zip;
    @Column
    private String timezone;
    @Transient
    private Set<String> categories;
    @Column(columnDefinition = "text")
    private String venueName;
    @Column(columnDefinition = "text")
    private String ownerName;

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
    
    
    
    public Event(){
        categories = new HashSet<>();
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }
    
    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
   
    public Integer getAttending_count() {
        return attending_count;
    }

    public void setAttending_count(Integer attending_count) {
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

    public String getCover_url() {
        return cover_url;
    }

    public void setCover_url(String cover_url) {
        this.cover_url = cover_url;
    }

    public Integer getDeclined_count() {
        return declined_count;
    }

    public void setDeclined_count(Integer declined_count) {
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

    public Integer getInterested_count() {
        return interested_count;
    }

    public void setInterested_count(Integer interested_count) {
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

    public Integer getMaybe_count() {
        return maybe_count;
    }

    public void setMaybe_count(Integer maybe_count) {
        this.maybe_count = maybe_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNoreply_count() {
        return noreply_count;
    }

    public void setNoreply_count(Integer noreply_count) {
        this.noreply_count = noreply_count;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }

    public Long getPlaceId() {
        return placeId;
    }

    public void setPlaceId(Long placeId) {
        this.placeId = placeId;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    

}
