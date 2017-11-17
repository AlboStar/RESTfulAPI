/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.restfulapi;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.restfulapi.data.Push;
import com.restfulapi.data.User;
import com.restfulapi.data.UserList;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Naty
 */
@Path("/json")
public class JSONService {


    @POST
    @Path("/newUser")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String newUser(@FormParam("name") String name, @FormParam("token") String token) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User();
        user.setUsername(name);
        user.setAccessToken(token);
        user.setCreationTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
        UserList.getInstance().add(user);
        return mapper.writeValueAsString(user);

    }

    @GET
    @Path("/listUser")
    @Produces("application/json")
    public String listUsers() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(UserList.getInstance());

    }

    @POST
    @Path("/push")
    //@Produces("application/json")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void push(@FormParam("name") String name) throws JsonProcessingException, IOException {
        User user;
        String token = null;
        for (int i = 0; i < UserList.getInstance().size(); i++) {
            user = (User) UserList.getInstance().get(i);
            if (user.getUsername().equals(name)) {
                token = user.getAccessToken();
            }
        }
        post(token);
        //return token;
    }

    private void post(String token) throws JsonProcessingException, UnsupportedEncodingException, IOException {
        HttpPost post = new HttpPost("https://api.pushbullet.com/v2/pushes");
        //String result = null;
        ObjectMapper mapper = new ObjectMapper();
    
            Push push = new Push("note", "New note", "I am a new note");
            CloseableHttpClient client = HttpClients.createDefault();
            post.setEntity(new StringEntity(mapper.writeValueAsString(push)));
            post.setHeader("Access-Token", token);
            post.setHeader("Content-type", "application/json");
            client.execute(post);
      
    }
}
