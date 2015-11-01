package com.railway.railway.activity.listeners;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

import com.railway.railway.activity.TicketQRCodeActivity;
import com.railway.railway.business.api.entity.Ticket;


/**
 * Created by Leonel on 23/10/2015.
 */
public class UserActivityTicketClick implements AdapterView.OnItemClickListener{

    public UserActivityTicketClick(){
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Context context = view.getContext();
        Intent intent = new Intent(context, TicketQRCodeActivity.class);
        intent.putExtra("ticket",(Ticket)adapterView.getItemAtPosition(i));
        context.startActivity(intent);
    }
}
