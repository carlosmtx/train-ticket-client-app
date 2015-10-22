package com.railway.railway.activity.listeners;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.railway.railway.DI;
import com.railway.railway.business.api.request.RegisterRequest;
import com.railway.railway.business.api.request.RegisterRequestData;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

/**
 * Created by cteixeira on 22-10-2015.
 * com.railway.railway.activity.listeners
 */
public class RegisterActivityRegisterTask extends AsyncTask<Void, Void, JSONObject> {

    private Context context;
    private RegisterRequestData data;
    private RegisterRequest request;

    RegisterActivityRegisterTask(Context context, RegisterRequestData data){
        this.context = context;
        this.data = data;
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        try {
            this.request = new RegisterRequest(data);
            DI.get().provideRequestAPI().request(this.request);
            return this.request.getResponse();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        Toast toast;
        try {
            DI.get().provideStorage().setToken(result.get("token").toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(result == null){
            toast = Toast.makeText(this.context,"Nhé... deu asneira",Toast.LENGTH_LONG);
        } else {
            toast = Toast.makeText(this.context,"Parabens Registou-se",Toast.LENGTH_LONG);
        }
        toast.show();
    }
}
