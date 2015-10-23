package com.railway.railway.activity.listeners;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.railway.railway.activity.UserActivity;
import com.railway.railway.business.api.request.MyTicketsRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Leonel on 22/10/2015.
 */
public class UserActivityMyTicketsTask extends AsyncTask<Void, Void, JSONObject> {

    private Activity activity;
    private MyTicketsRequest request;
    private JSONObject result;

    public UserActivityMyTicketsTask(Activity activity) {
        this.activity = activity;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        try {
            this.request = new MyTicketsRequest();
            result = this.request.getResponse();
            return result;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject result){
        Toast toast;
        if(result == null){
            toast = Toast.makeText(this.activity,"There was an error retrieving tickets",Toast.LENGTH_LONG);
            toast.show();
        } else {
            try {
                ((UserActivity)activity).fillTicketsContainer(result);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public JSONObject getResult(){
        return this.result;
    }

}
