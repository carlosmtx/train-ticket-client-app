package com.railway.railway.business.api.response;

import org.json.JSONObject;

/**
 * Created by cteixeira on 10-10-2015.
 */
public class AuthResponse implements  Response{
    public JSONObject response;

    public AuthResponse(JSONObject response){
        this.response = response;
    }

    @Override
    public JSONObject getContent() {
        return null;
    }
}
