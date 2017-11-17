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
public class Push {

    private String type;
    private String title;
    private String body;

    public Push() {
    }

    public Push(String type, String title, String body) {
        this.type = type;
        this.title = title;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
