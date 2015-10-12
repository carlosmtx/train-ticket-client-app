package com.railway.railway.activity.listeners;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.railway.railway.DaggerApplicationComponent;
import com.railway.railway.business.api.API;
import com.railway.railway.business.api.response.Response;


public class LoginActivityLoginClickTask extends AsyncTask<String,Void,Response> {
    private Context context;

    LoginActivityLoginClickTask(Context view){
        this.context = view;
    }

    @Override
    protected Response doInBackground(String... params) {
        String username = params[0];
        String password = params[1];
        API api = DaggerApplicationComponent.create().provideRequestAPI();
        try {
            return api.login(username,password);
        } catch (Exception e) {

        }
        return null;
    }

    @Override
    protected void onPostExecute(Response response) {
        Toast toast = Toast.makeText(context,"A funcionar",Toast.LENGTH_LONG);
        toast.show();
    }
}
