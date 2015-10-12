package com.railway.railway.activity.listeners;

import android.os.AsyncTask;
import com.railway.railway.DaggerApplicationComponent;
import com.railway.railway.business.api.API;
import com.railway.railway.business.api.request.Request;
import com.railway.railway.business.api.response.AuthResponse;
import com.railway.railway.business.api.response.Response;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by cteixeira on 12-10-2015.
 */
public class LoginActivityLoginClickTask extends AsyncTask<String,Void,Response> {

    @Override
    protected Response doInBackground(String... params) {
        String username = params[0];
        String password = params[1];
        API api = DaggerApplicationComponent.create().provideRequestAPI();
        try {
            return api.login(username,password);
        } catch (Exception e){

        }

        return null;
    }

    @Override
    protected void onPostExecute(Response response) {
        String a = "dasdas";
    }
}
