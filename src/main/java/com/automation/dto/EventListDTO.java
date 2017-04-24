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
public class EventListDTO {
    
    private List<EventDTO> data;
    
    private PagingDTO paging;
    
    public class PagingDTO{
        
        private String next;

        public String getNext() {
            return next;
        }

        public void setNext(String next) {
            this.next = next;
        }       
    }

    public List<EventDTO> getData() {
        return data;
    }

    public void setData(List<EventDTO> data) {
        this.data = data;
    }

    public PagingDTO getPaging() {
        return paging;
    }

    public void setPaging(PagingDTO paging) {
        this.paging = paging;
    }
    
}
