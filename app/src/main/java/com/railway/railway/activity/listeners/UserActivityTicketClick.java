package com.railway.railway.activity.listeners;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.View;

import com.railway.railway.activity.RegisterActivity;
import com.railway.railway.activity.TicketQRCodeActivity;
import com.railway.railway.activity.UserActivity;
import com.railway.railway.business.api.entity.Ticket;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Leonel on 23/10/2015.
 */
public class UserActivityTicketClick implements View.OnClickListener{
    private JSONObject ticket;
    private Context context;

    public UserActivityTicketClick(Context ctx, JSONObject ticket){
        this.ticket = ticket;
        this.context = ctx;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, TicketQRCodeActivity.class);
        try {
            intent.putExtra("ticket", new Ticket(this.ticket));
            context.startActivity(intent);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
