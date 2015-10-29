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

public class PurchaseSelectScheduleActivity extends MenuActivity {
    float fixedPrice = (float) 10.30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_select_schedule);

        // Stations passed from previous activity
        String departureStation = getIntent().getStringExtra("departure");
        String arrivalStation = getIntent().getStringExtra("arrival");
        String date = getIntent().getStringExtra("date");


        TextView hello = (TextView)findViewById(R.id.purchase_lbl_from_to);
        hello.setText(departureStation + " to " + arrivalStation + " on " + date);

        fillScheduleOptions(departureStation, arrivalStation, date);

    }

    private void fillScheduleOptions(String departure,String arrival, String date) {
        LinearLayout container = (LinearLayout)findViewById(R.id.purchase_timetable_container);

        ArrayList<String> timetable = DI.get().provideStorage().getSchedule().getTimetable(departure, arrival);
        double price = DI.get().provideStorage().getSchedule().getPrice(departure,arrival);

        for(int i=0; i < timetable.size(); i++){
            Button btn_time = new Button(this);
            btn_time.setId(i);
            btn_time.setGravity(Gravity.LEFT);
            btn_time.setText(timetable.get(i));
            btn_time.setOnClickListener(new PurchaseActivityScheduleClick(departure, arrival, date, timetable.get(i), price));
            container.addView(btn_time);
        }

    }

}
