/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import org.apache.commons.lang.StringUtils;
import org.joda.time.DateTime;

/**
 *
 * @author root
 */
public final class DateTimeSerilaizer implements JsonDeserializer<DateTime> ,JsonSerializer<DateTime>{

    @Override
    public DateTime deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        
       return je.getAsString().length() == 0 ? null : DateTime.parse(je.getAsString());
    }

    @Override
    public JsonElement serialize(DateTime t, Type type, JsonSerializationContext jsc) {
             return new JsonPrimitive(t==null ? StringUtils.EMPTY : t.toString()); 

    }
    
}
