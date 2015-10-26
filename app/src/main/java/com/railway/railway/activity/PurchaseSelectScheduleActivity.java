package com.railway.railway.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.railway.railway.DI;
import com.railway.railway.R;
import com.railway.railway.activity.listeners.PurchaseActivityScheduleClick;

import java.util.ArrayList;

public class PurchaseSelectScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_select_schedule);

        // Stations passed from previous activity
        String departureStation = getIntent().getStringExtra("departure");
        String arrivalStation = getIntent().getStringExtra("arrival");

        TextView hello = (TextView)findViewById(R.id.purchase_lbl_from_to);
        hello.setText(departureStation + " to " + arrivalStation);

        fillScheduleOptions(departureStation,arrivalStation);

    }

    private void fillScheduleOptions(String departure,String arrival) {
        LinearLayout container = (LinearLayout)findViewById(R.id.purchase_timetable_container);

        ArrayList<String> timetable = DI.get().provideStorage().getSchedule().getTimetable(departure,arrival);
        for(int i=0; i < timetable.size(); i++){
            Button btn_time = new Button(this);
            btn_time.setId(i);
            btn_time.setGravity(Gravity.LEFT);
            btn_time.setText(timetable.get(i));
            btn_time.setOnClickListener(new PurchaseActivityScheduleClick(departure, arrival, timetable.get(i)));
            container.addView(btn_time);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_purchase_select_schedule, menu);
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
