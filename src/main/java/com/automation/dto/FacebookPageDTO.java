/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.dto;

import java.util.List;

/**
 * @author root
 */
public class FacebookPageDTO {
    
    private Long id;
   
    private String about; //t
    
    private String bio;
    
    private String business; //t
    
    private String company_overview; //t
    
    private Integer checkins;
    
    private String category;
    
    private List<CategoryListDTO> category_list;
    
    private String contact_address; //t
    
    private CoverDTO cover;
    
    private String current_location;
    
    private String description;
    
    private String founded;
    
    private String genre;
    
    private LocationDTO location;
    
    private String name;
    
    private String name_with_location_descriptor;
        
    private Float overall_star_rating;
    
    private Integer fan_count;
    
    private Integer rating_count;
    
    private String type;

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

    public List<CategoryListDTO> getCategory_list() {
        return category_list;
    }

    public void setCategory_list(List<CategoryListDTO> category_list) {
        this.category_list = category_list;
    }

    public String getContact_address() {
        return contact_address;
    }

    public void setContact_address(String contact_address) {
        this.contact_address = contact_address;
    }

    public CoverDTO getCover() {
        return cover;
    }

    public void setCover(CoverDTO cover) {
        this.cover = cover;
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

    public LocationDTO getLocation() {
        return location;
    }

    public void setLocation(LocationDTO location) {
        this.location = location;
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
    
    
}
