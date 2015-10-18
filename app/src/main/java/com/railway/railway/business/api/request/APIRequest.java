package com.railway.railway.business.api.request;

import com.android.volley.*;
import com.railway.railway.business.api.context.APIContext;

/**
 * Created by cteixeira on 17-10-2015.
 */
public interface APIRequest {
    com.android.volley.Request getRequest();
}
