/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.automation.service;

import com.automation.dto.AccessTokenDTO;
import com.automation.util.CurlHandler;
import com.automation.util.FacebookConstants;
import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author root
 */
@Service
public class FacebookAccessTokenService {

    Logger logger = LoggerFactory.getLogger(FacebookAccessTokenService.class);

    private final String accessTokenUrl = "oauth/access_token";
    private String accessToken = "EAADZCEPCse9IBAC0IxY1HnvnnMPEKzhSHcDi7FZC16pBXXNw3HSgggIOb9OTlDyREtG8xaDMaXzt8ksbTbUgKsa7h9aUUhgTYiY8t6Aa5LbtBBnItGFIZAQNNsFPhomB4sRKFF9gD3mYEFkZBZCxbewkcWsu5ZAjAZD";

    public String getAccessToken() {
        if (accessToken == null) {
            Gson gson = new Gson();
            String url = generateAccessTokenUrl();
            String response = CurlHandler.getRequest(url);
            AccessTokenDTO accessTok = gson.fromJson(response, AccessTokenDTO.class);
            logger.info(response);
            this.accessToken = accessTok.getAccess_token();
        }
        return this.accessToken;

    }

    private String generateAccessTokenUrl() {
        String url = FacebookConstants.FACEBOOK_BASE_URL + accessTokenUrl + "?client_id="
                + FacebookConstants.APPID + "&client_secret=" + FacebookConstants.APPSECRET
                + "&grant_type=client_credentials";
        return url;
    }

}
