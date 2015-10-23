package com.railway.railway.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.railway.railway.R;
import com.railway.railway.activity.listeners.UserActivityMyTicketsTask;
import com.railway.railway.activity.listeners.UserActivityPurchaseClick;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        LinearLayout ticketContainer = (LinearLayout)findViewById(R.id.user_tickets_container);
        Button purchaseButton = (Button)findViewById(R.id.user_btn_purchase);

        purchaseButton.setOnClickListener(new UserActivityPurchaseClick());

        UserActivityMyTicketsTask task = new UserActivityMyTicketsTask(this, true);
        //try {
        //    task.get();
        //} catch (Exception e) {
        //    e.printStackTrace();
        //}


        TextView[] txt =new TextView[3];
        for(int i=0;i<txt.length;i++)
        {
            txt[i]=new TextView(this);
            txt[i].setText("text " + i);
            ticketContainer.addView(txt[i]);
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
}
