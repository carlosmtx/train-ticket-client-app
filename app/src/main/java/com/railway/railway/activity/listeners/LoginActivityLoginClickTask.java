package com.railway.railway.activity.listeners;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.railway.railway.DaggerApplicationComponent;
import com.railway.railway.activity.UserActivity;
import com.railway.railway.business.api.API;
import com.railway.railway.business.api.request.AuthRequest;
import com.railway.railway.business.api.entity.User;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class LoginActivityLoginClickTask extends AsyncTask<String,Void,User> {
    private Context context;
    private final String username;
    private final String password;

    LoginActivityLoginClickTask(Context view,String username,String password){
        this.context = view;
        this.username = username;
        this.password = password;
    }

    @Override
    protected User doInBackground(String... params) {

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
            toast = Toast.makeText(context,"Logging in...",Toast.LENGTH_LONG);
            // TODO: será que fica bem aqui a mudança de activity? acho que faz sentido ser na "task"
            Intent intent = new Intent(context, UserActivity.class);
            context.startActivity(intent);
        } else {
            toast = Toast.makeText(context,"Please verify your credentials!",Toast.LENGTH_LONG);
        }
        toast.show();
    }
}
