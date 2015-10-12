package com.railway.railway.business.api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.railway.railway.business.api.request.LoginRequest;
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
        final Request req = new LoginRequest(username,password);
        this.queue.add(req.getRequest());
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    req.getResponse();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.wait();

        return req.getResponse();
    }

}
