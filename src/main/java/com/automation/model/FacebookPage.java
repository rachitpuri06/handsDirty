/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.model;

import com.automation.util.QueryConstants;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * @author root
 */
@Entity
@Table
@NamedQueries(
        @NamedQuery(name = QueryConstants.FacebookPageById, query = "from FacebookPage where id =:id"))
public class FacebookPage extends TimeStamp {

    @Id
    @Column
    private Long id;

    @Column(columnDefinition = "text")
    private String about; //t

    @Column(columnDefinition = "text")
    private String bio;

    @Column(columnDefinition = "text")
    private String business; //t

    @Column(columnDefinition = "text")
    private String company_overview; //t

    @Column
    private Integer checkins;

    @Column
    private String category;

    @Column
    private String contact_address; //t

    @Column
    private String coverUrl;

    @Column
    private String current_location;

    @Column(columnDefinition = "text")
    private String description;

    @Column
    private String founded;

    @Column
    private String genre;

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

    @Column(columnDefinition = "text")
    private String name;

    @Column
    private String name_with_location_descriptor;

    @Column
    private Float overall_star_rating;

    @Column
    private Integer fan_count;

    @Column
    private Integer rating_count;

    @Column
    private String type;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastProcessedDate;

    @Column
    private String lastProcessedEventId;

    @Transient
    private Set<String> categories;

    public FacebookPage() {
        categories = new HashSet<>();
    }

    public Set<String> getCategories() {
        return categories;
    }

    public void setCategories(Set<String> categories) {
        this.categories = categories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getCompany_overview() {
        return company_overview;
    }

    public void setCompany_overview(String company_overview) {
        this.company_overview = company_overview;
    }

    public Integer getCheckins() {
        return checkins;
    }

    public void setCheckins(Integer checkins) {
        this.checkins = checkins;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getCurrent_location() {
        return current_location;
    }

    public void setCurrent_location(String current_location) {
        this.current_location = current_location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFounded() {
        return founded;
    }

    public void setFounded(String founded) {
        this.founded = founded;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_with_location_descriptor() {
        return name_with_location_descriptor;
    }

    public void setName_with_location_descriptor(String name_with_location_descriptor) {
        this.name_with_location_descriptor = name_with_location_descriptor;
    }

    public Float getOverall_star_rating() {
        return overall_star_rating;
    }

    public void setOverall_star_rating(Float overall_star_rating) {
        this.overall_star_rating = overall_star_rating;
    }

    public Integer getFan_count() {
        return fan_count;
    }

    public void setFan_count(Integer fan_count) {
        this.fan_count = fan_count;
    }

    public Integer getRating_count() {
        return rating_count;
    }

    public void setRating_count(Integer rating_count) {
        this.rating_count = rating_count;
    }

    public Date getLastProcessedDate() {
        return lastProcessedDate;
    }

    public void setLastProcessedDate(Date lastProcessedDate) {
        this.lastProcessedDate = lastProcessedDate;
    }

    public String getLastProcessedEventId() {
        return lastProcessedEventId;
    }

    public void setLastProcessedEventId(String lastProcessedEventId) {
        this.lastProcessedEventId = lastProcessedEventId;
    }

}
