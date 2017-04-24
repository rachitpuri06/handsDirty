/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.commons.lang.ArrayUtils;
import org.hibernate.EmptyInterceptor;

/**
 *
 * @author root
 */
@MappedSuperclass
public class TimeStamp extends EmptyInterceptor implements Serializable {
       
    private static long serialVersionUID = 5924361831551833717L;
    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;

    @Column
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Override
    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, org.hibernate.type.Type[] types) {
        int indexOf = ArrayUtils.indexOf(propertyNames, "lastUpdated");
            state[indexOf] = new Date();
        indexOf = ArrayUtils.indexOf(propertyNames, "createdDate");
        if (state[indexOf] == null) {
            state[indexOf] = new Date();
        }
        
        return true;
    }

    @Override
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState, String[] propertyNames, org.hibernate.type.Type[] types) {
        int indexOf = ArrayUtils.indexOf(propertyNames, "lastUpdated");
        currentState[indexOf] = new Date();
//        indexOf = ArrayUtils.indexOf(propertyNames, "createdDate");
//        currentState[indexOf] = previousState[indexOf];
        return true;
    }

    /**
     * @return the lastUpdated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    /**
     * @param lastUpdated the lastUpdated to set
     */
    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    /**
     * @return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    
}
