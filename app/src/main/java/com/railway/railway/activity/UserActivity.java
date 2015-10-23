package com.railway.railway.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.railway.railway.R;
import com.railway.railway.activity.listeners.UserActivityMyTicketsTask;
import com.railway.railway.activity.listeners.UserActivityOnBackPressed;
import com.railway.railway.activity.listeners.UserActivityPurchaseClick;
import com.railway.railway.activity.listeners.UserActivityTicketClick;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class UserActivity extends AppCompatActivity {

    //HashMap<Button,JSONObject> buttonsMap = new HashMap<>();
    ArrayList<Button> buttonsMap = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Button purchaseButton = (Button)findViewById(R.id.user_btn_purchase);
        purchaseButton.setOnClickListener(new UserActivityPurchaseClick());

        // Ao retornar para a Activity ele volta a fazer a chamada
        new UserActivityMyTicketsTask(this).execute();
    }

    public void fillTicketsContainer(JSONObject tickets) throws JSONException {
        LinearLayout ticketContainer = (LinearLayout)findViewById(R.id.user_tickets_container);

        JSONArray activeTickets = (JSONArray) tickets.get("active");

        for(int i = 0; i < activeTickets.length(); i++){
            JSONObject currentTicket = activeTickets.getJSONObject(i);
            final Button btn_ticket = new Button(this);
            btn_ticket.setId(i);
            btn_ticket.setGravity(Gravity.LEFT);
            btn_ticket.setText(
                    "From: "
                            + currentTicket.get("start").toString() + "\n"
                            + "To: "
                            + currentTicket.get("end").toString() + "\n"
                            + currentTicket.get("price").toString() + "€"
            );
            buttonsMap.add(btn_ticket);
            btn_ticket.setOnClickListener(new UserActivityTicketClick(this,currentTicket));
            ticketContainer.addView(btn_ticket);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater(); //from activity
        inflater.inflate(R.menu.menu_user, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        new UserActivityOnBackPressed(this);
    }

}
