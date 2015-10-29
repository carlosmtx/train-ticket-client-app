package com.railway.railway.activity;

import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.railway.railway.DI;
import com.railway.railway.R;
import com.railway.railway.activity.listeners.UserActivityMyTicketsTask;
import com.railway.railway.activity.listeners.UserActivityOnBackPressed;
import com.railway.railway.activity.listeners.UserActivityPurchaseClick;
import com.railway.railway.activity.listeners.UserActivityTicketClick;
import com.railway.railway.business.api.entity.Ticket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserActivity extends MenuActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Button purchaseButton = (Button)findViewById(R.id.user_btn_purchase);
        purchaseButton.setOnClickListener(new UserActivityPurchaseClick());

        TextView helloText = (TextView) findViewById(R.id.user_lbl_username);
        helloText.setText(DI.get().provideStorage().getUser().email);

        // Cache de resultado a não ser que seja preciso
        boolean forceCall = false;
        if(getIntent().hasExtra("forceCall")) forceCall=true;
        new UserActivityMyTicketsTask(this, forceCall).execute();
    }

    public void fillTicketsContainer(JSONObject tickets) throws JSONException {
        LinearLayout ticketsContainer = (LinearLayout)findViewById(R.id.user_tickets_container);

        JSONArray activeTickets = (JSONArray) tickets.get("active");

        for(int i = 0; i < activeTickets.length(); i++){
            Ticket currentTicket = new Ticket(activeTickets.getJSONObject(i));

            Button btn_ticket = new Button(this);
            btn_ticket.setId(i);
            btn_ticket.setGravity(Gravity.LEFT);
            btn_ticket.setText(
                    "From: "
                            + currentTicket.getDeparture() + "\n"
                            + "To: "
                            + currentTicket.getArrival() + "\n"
                            + currentTicket.getDepartureTime() + " "
                            + currentTicket.getDepartureDate()
            );
            btn_ticket.setOnClickListener(new UserActivityTicketClick(this, currentTicket));
            ticketsContainer.addView(btn_ticket);
        }
    }


    @Override
    public void onBackPressed() {
        new UserActivityOnBackPressed(this);
    }

}
