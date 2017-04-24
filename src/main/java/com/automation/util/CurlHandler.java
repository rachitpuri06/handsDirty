/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import java.util.logging.Level;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author root
 */
public class CurlHandler {
    
    static final Logger logger = LoggerFactory.getLogger(CurlHandler.class);

    public static String getRequest(String url, Map<String, String> paramsMap) {
        
        String params = getParameters(paramsMap);
        if (!params.equals("")) {
            url = url + "?" + params;
        }
         return getRequest(url);
    }
    
   public static String getRequestAuth(String url){
        try {
            url = url + "&access_token="+URLEncoder.encode(FacebookConstants.APPID + "|" + FacebookConstants.APPSECRET, "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            java.util.logging.Logger.getLogger(CurlHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
       return getRequest(url);
   } 
    
   public static String getRequest(String url) {
       try{
        HttpClient httpClient = HttpClientBuilder.create().build();
        
        HttpGet request = new HttpGet(url);
        //logger.info("Request String " + request.toString());
        HttpResponse response = httpClient.execute(request);
        System.out.println("Response Code : "   
                + response.getStatusLine().getStatusCode());
       logger.info("Response Code : "   
                + response.getStatusLine().getStatusCode());
       //logger.info(response.toString());

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        if(response.getStatusLine().getStatusCode()!=200){
            logger.info("Request " +url);
            logger.info("Response " + response.toString());
            logger.info("Result " + result.toString());
        }
        //logger.info(result.toString());
        return result.toString();
       }catch(Exception ex){
           logger.info("ERROR ", ex);
       }
       return "";
   } 

    private static String getParameters(Map<String, String> paramsMap) {
        String data = "";
        for (String key : paramsMap.keySet()) {
            try {
                data = data + key + "=" + URLEncoder.encode(paramsMap.get(key), "UTF-8") + "&";
            } catch (UnsupportedEncodingException ex) {
              logger.error("Could not encode "+key + " value " + paramsMap.get(key));
            }

        }
        return data.substring(0, data.length() - 1);
    }
}
