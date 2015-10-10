package com.railway.railway.business.api;

import com.railway.railway.business.api.response.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by cteixeira on 08-10-2015.
 */
public interface API {
    Response login(String username,String password) throws InterruptedException, ExecutionException, TimeoutException;
}
