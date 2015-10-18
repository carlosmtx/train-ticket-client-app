package com.railway.railway.activity.listeners;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.railway.railway.DaggerApplicationComponent;
import com.railway.railway.business.api.API;
import com.railway.railway.business.api.request.AuthRequest;
import com.railway.railway.business.api.entity.User;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class LoginActivityLoginClickTask extends AsyncTask<String,Void,User> {
    private Context context;

    LoginActivityLoginClickTask(Context view){
        this.context = view;
    }

    @Override
    protected User doInBackground(String... params) {
        String username = params[0];
        String password = params[1];
        API api = DaggerApplicationComponent.create().provideRequestAPI();
        try {
            AuthRequest request = new AuthRequest(username,password);
            api.request(request);
            return request.getResponse();
        } catch (JSONException | TimeoutException | ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(User response) {
        Toast toast;
        if (response != null){
            toast = Toast.makeText(context,"A funcionar",Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(context,"Deu erro",Toast.LENGTH_LONG);
        }
        toast.show();
    }
}
