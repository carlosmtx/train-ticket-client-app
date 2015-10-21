package com.railway.railway.business.api.request;

import com.android.volley.Request.Method;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.RequestFuture;
import com.railway.railway.DI;
import com.railway.railway.DaggerApplicationComponent;
import com.railway.railway.business.api.context.APIContext;
import com.railway.railway.business.api.entity.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class AuthRequest implements APIRequest {
    public final RequestFuture<JSONObject> future ;
    JsonObjectRequest request;
    JSONObject requestData;
    private APIContext context;

    public AuthRequest(String email, String password) throws JSONException {
        String url = "https://cmovtrainserver.herokuapp.com/login";
        future = RequestFuture.newFuture();
        requestData = new JSONObject()
                .put("email", email)
                .put("password", password);
        request = new JsonObjectRequest(
                Method.POST,
                url,
                requestData,
                future,
                future
        );
    }

    public User getResponse() throws ExecutionException, InterruptedException, TimeoutException, JSONException {
        User user = new User(future.get());
        DaggerApplicationComponent.builder().build().provideStorage().setToken(user.token);
        //DI.get().provideStorage().setToken(user.token);
        return user;
    }

    @Override
    public JsonObjectRequest getRequest() {
        return request;
    }
}
