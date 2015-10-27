package com.railway.railway.activity.listeners;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.railway.railway.activity.UserActivity;
import com.railway.railway.business.api.entity.User;
import com.railway.railway.business.api.request.AuthRequest;
import com.railway.railway.business.api.request.AuthRequestData;

import org.json.JSONException;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;


public class LoginActivityLoginClickTask extends AsyncTask<String,Void,User> {
    private Context context;
    private AuthRequestData data;

    LoginActivityLoginClickTask(Context view,AuthRequestData data){
        this.context = view;
        this.data = data;
    }

    @Override
    protected User doInBackground(String... params) {

        try {
            AuthRequest request = new AuthRequest(this.data);
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
            Intent intent = new Intent(context, UserActivity.class);
            intent.putExtra("forceCall", "true");
            context.startActivity(intent);
        } else {
            toast = Toast.makeText(context,"Please verify your credentials!",Toast.LENGTH_SHORT);
        }
        toast.show();
    }
}
