package com.railway.railway.business.api.request;

import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.railway.railway.business.api.response.AuthResponse;
import com.railway.railway.business.api.response.Response;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


public class AuthRequest implements Request {
    public JsonObjectRequest request;
    public final RequestFuture<JSONObject> future ;

    public AuthRequest(String username, String password) {
        String url = "https://cmovtrainserver.herokuapp.com/hello";
        JSONObject jsonParameters = new JSONObject();
        try {
            jsonParameters.put("password", password);
            jsonParameters.put("username", username);
        } catch (JSONException e) {
            //TODO: Improve exception handling
            e.printStackTrace();
        }
        this.future = RequestFuture.newFuture();
        this.request = new JsonObjectRequest(com.android.volley.Request.Method.GET,url,null,future,future);
    }

    @Override
    public JsonObjectRequest getRequest() {
        if(this.request == null) {
            return null;
        }
        return this.request;
    }

    @Override
    public Response getResponse() throws ExecutionException, InterruptedException, TimeoutException {
        JSONObject rawResponse = null;
        try{
            rawResponse = this.future.get(30, TimeUnit.SECONDS);
        } catch (Exception e){
            int a = 2 ;
        }
        return (Response) new AuthResponse(rawResponse);
    }

}
