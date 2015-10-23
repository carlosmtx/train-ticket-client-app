package com.railway.railway.activity.listeners;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.railway.railway.business.api.request.MyTicketsRequest;
import com.railway.railway.business.api.request.MyTicketsRequestData;
import com.railway.railway.business.api.request.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * Created by Leonel on 22/10/2015.
 */
public class UserActivityMyTicketsTask extends AsyncTask<Void, Void, JSONObject> {

    private Context context;
    //private MyTicketsRequestData data;
    private MyTicketsRequest request;

    public UserActivityMyTicketsTask(Context context, boolean start){
        if(start) this.execute();
        this.context = context;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        try {
            this.request = new MyTicketsRequest();
            return this.request.getResponse();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        Toast toast;
        if(result == null){
            toast = Toast.makeText(this.context,"Nhé... deu asneira",Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(this.context,result.toString(),Toast.LENGTH_LONG);
        }
        toast.show();
    }
}
