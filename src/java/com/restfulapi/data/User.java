/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfulapi.data;

/**
 *
 * @author Naty
 */
public class User {
    private String username;
    private String accessToken;
    private String creationTime;
    private int numOfNotificationsPushed;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public int getNumOfNotificationsPushed() {
        return numOfNotificationsPushed;
    }

    public void setNumOfNotificationsPushed(int numOfNotificationsPushed) {
        this.numOfNotificationsPushed = numOfNotificationsPushed;
    }
    
}
