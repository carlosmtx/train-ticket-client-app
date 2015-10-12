package com.railway.railway.business.api;

import com.android.volley.RequestQueue;
import com.railway.railway.business.api.request.AuthRequest;
import com.railway.railway.business.api.request.Request;
import com.railway.railway.business.api.response.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import javax.inject.Inject;


public class RailwayAPI implements API {

    private RequestQueue queue;

    @Inject
    public RailwayAPI(RequestQueue queue){
        this.queue = queue;
    }

    @Override
    public Response login(String username, String password) throws InterruptedException, ExecutionException, TimeoutException {
        final Request req = new AuthRequest(username,password);
        queue.add(req.getRequest());
        return req.getResponse();
    }
}
