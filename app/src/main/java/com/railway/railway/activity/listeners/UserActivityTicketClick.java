package com.railway.railway.activity.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.railway.railway.activity.TicketQRCodeActivity;
import com.railway.railway.business.api.entity.Ticket;

/**
 * Created by Leonel on 23/10/2015.
 */
public class UserActivityTicketClick implements View.OnClickListener{
    private Ticket ticket;
    private Context context;

    public UserActivityTicketClick(Context ctx, Ticket ticket){
        this.ticket = ticket;
        this.context = ctx;
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(context, TicketQRCodeActivity.class);
        intent.putExtra("ticket", ticket);
        context.startActivity(intent);
    }
}
