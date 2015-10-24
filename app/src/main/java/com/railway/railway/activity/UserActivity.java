package com.railway.railway.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;

import com.railway.railway.R;
import com.railway.railway.activity.listeners.UserActivityMyTicketsTask;
import com.railway.railway.activity.listeners.UserActivityOnBackPressed;
import com.railway.railway.activity.listeners.UserActivityPurchaseClick;
import com.railway.railway.activity.listeners.UserActivityTicketClick;
import com.railway.railway.business.api.entity.Ticket;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {

    //HashMap<Button,JSONObject> buttonsMap = new HashMap<>();
    ArrayList<Button> buttonsMap = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        Button purchaseButton = (Button)findViewById(R.id.user_btn_purchase);
        purchaseButton.setOnClickListener(new UserActivityPurchaseClick());

        // Ao retornar para a Activity ele volta a fazer a chamada. meh
        new UserActivityMyTicketsTask(this).execute();
    }

    public void fillTicketsContainer(JSONObject tickets) throws JSONException {
        LinearLayout ticketsContainer = (LinearLayout)findViewById(R.id.user_tickets_container);

        JSONArray activeTickets = (JSONArray) tickets.get("active");

        for(int i = 0; i < activeTickets.length(); i++){
            Ticket currentTicket = new Ticket(activeTickets.getJSONObject(i));

            final Button btn_ticket = new Button(this);
            btn_ticket.setId(i);
            btn_ticket.setGravity(Gravity.LEFT);
            btn_ticket.setText(
                    "From: "
                    + currentTicket.getDeparture() + "\n"
                    + "To: "
                    + currentTicket.getArrival() + "\n"
                    + currentTicket.getPrice() + "€"
            );
            buttonsMap.add(btn_ticket);
            btn_ticket.setOnClickListener(new UserActivityTicketClick(this, currentTicket));
            ticketsContainer.addView(btn_ticket);
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
