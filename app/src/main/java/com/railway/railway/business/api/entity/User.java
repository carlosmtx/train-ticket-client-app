package com.railway.railway.business.api.entity;

import org.json.JSONObject;

/**
 * Created by cteixeira on 10-10-2015.
 */
public class User {
    public String username;
    public String token;
    public String email;
    //TODO: Add extra user fields to this entity
    protected JSONObject response;

    public User(JSONObject response){
        this.response = response;
    }

}
