package com.railway.railway.business.api.storage;

import com.railway.railway.business.api.entity.Railway;
import com.railway.railway.business.api.entity.User;

/**
 * Created by cteixeira on 21-10-2015.
 * com.railway.railway.business.api.storage
 */
public interface Storage {

    String getToken();
    void setToken(String token);

    Railway getSchedule();
    void setSchedule(Railway schedule);

    User getUser();
    void setUser(User user);

}
