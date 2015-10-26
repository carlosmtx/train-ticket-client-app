package com.railway.railway.business.api.storage;

import com.railway.railway.business.api.entity.Railway;
import com.railway.railway.business.api.entity.User;

import java.util.HashMap;

/**
 * Created by cteixeira on 21-10-2015.
 * com.railway.railway.business.api.storage
 */
public class RailwayStorage implements Storage {
    private HashMap<String,String> storage;
    private Railway schedule;
    private User user;

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

    @Override
    public Railway getSchedule() {
        return this.schedule;
    }

    @Override
    public void setSchedule(Railway schedule) {
        this.schedule = schedule;
    }

    @Override
    public User getUser() {
        return this.user;
    }

    @Override
    public void setUser(User user) {
        this.user = user;
    }
}
