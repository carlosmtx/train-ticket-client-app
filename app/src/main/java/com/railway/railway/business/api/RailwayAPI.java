package com.railway.railway.business.api;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.railway.railway.business.api.request.LoginRequest;
import com.railway.railway.business.api.request.Request;
import com.railway.railway.business.api.response.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class RailwayAPI implements API {
    static RequestQueue queue;
    static Context context;
    static RailwayAPI railwayAPI;

    RailwayAPI(Context context){
        RailwayAPI.context = context;
    }


    public static API getInstance(Context context){
        if (railwayAPI == null) {
            railwayAPI = new RailwayAPI(context);
        }
        return railwayAPI;
    }

    private RequestQueue getRequestQueue(){
       if(queue == null){
           queue = Volley.newRequestQueue(context);
       }
        return RailwayAPI.queue;
    }

    @Override
    public Response login(String username, String password) throws InterruptedException, ExecutionException, TimeoutException {
        final Request req = new LoginRequest(username,password);
        this.getRequestQueue().add(req.getRequest());
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
