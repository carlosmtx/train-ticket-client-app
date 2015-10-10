package com.railway.railway.business.api.request;

import com.android.volley.toolbox.JsonObjectRequest;
import com.railway.railway.business.api.response.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public interface Request {
    JsonObjectRequest getRequest();
    Response getResponse() throws ExecutionException, InterruptedException, TimeoutException;
}
