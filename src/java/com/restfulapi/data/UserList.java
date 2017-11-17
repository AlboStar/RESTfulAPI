/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfulapi.data;

import java.util.ArrayList;

/**
 *
 * @author Naty
 */
public class UserList extends ArrayList{

    private static UserList instance = null;

    private UserList() {
        // Exists only to defeat instantiation.
    }

    public static UserList getInstance() {
        if (instance == null) {
            instance = new UserList();
        }
        return instance;
    }
}
