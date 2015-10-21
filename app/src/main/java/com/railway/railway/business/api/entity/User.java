package com.railway.railway.business.api.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cteixeira on 10-10-2015.
 */
public class User {
    public String token;
    public String email;
    //TODO: Add extra user fields to this entity
    protected JSONObject response;

    public User(JSONObject response) throws JSONException {
        this.response = response;
        this.token = response.get("token").toString();
        this.email = response.get("email").toString();
    }

}
