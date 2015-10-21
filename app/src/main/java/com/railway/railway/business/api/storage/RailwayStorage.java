package com.railway.railway.business.api.storage;

import java.util.HashMap;

/**
 * Created by cteixeira on 21-10-2015.
 * com.railway.railway.business.api.storage
 */
public class RailwayStorage implements Storage {
    private HashMap<String,String> storage;

    public RailwayStorage() {
        this.storage = new HashMap<>();
    }

    @Override
    public String getToken() {
        return storage.get("token");
    }

    @Override
    public void setToken(String token) {
        storage.put("token",token);
    }
}
