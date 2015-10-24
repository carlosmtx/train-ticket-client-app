package com.railway.railway.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.railway.railway.R;
import com.railway.railway.activity.listeners.PurchaseActivityGetStationsTask;
import com.railway.railway.activity.listeners.PurchaseActivitySearchClick;

import java.util.ArrayList;
import java.util.List;

public class PurchaseSelectStationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_purchase_select_stations);

        Button purchaseButton = (Button)findViewById(R.id.purchase_btn_search);
        purchaseButton.setOnClickListener(new PurchaseActivitySearchClick());
        //purchase_btn_search
        new PurchaseActivityGetStationsTask(this).execute();
    }

    public void addDepartureOptions(ArrayList<String> stations){
        // Departure Spinner
        List<String> departureSpinnerArray =  stations;

        ArrayAdapter<String> departureAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, departureSpinnerArray);

        departureAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner departureSpinner = (Spinner) findViewById(R.id.purchase_departure_spinner);
        departureSpinner.setAdapter(departureAdapter);
    }

    public void addArrivalOptions(ArrayList<String> stations){
        // Arrival Spinner
        List<String> arrivalSpinnerArray =  stations;

        ArrayAdapter<String> arrivalAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, arrivalSpinnerArray);
        arrivalAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        Spinner arrivalSpinner = (Spinner) findViewById(R.id.purchase_arrival_spinner);
        arrivalSpinner.setAdapter(arrivalAdapter);
    }

    public String getSelectedArrival(){
        Spinner arrivalSpinner = (Spinner) findViewById(R.id.purchase_arrival_spinner);
        return arrivalSpinner.getSelectedItem().toString();
    }

    public String getSelectedDeparture(){
        Spinner departureSpinner = (Spinner) findViewById(R.id.purchase_departure_spinner);
        return departureSpinner.getSelectedItem().toString();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_purchase_select_stations, menu);
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
