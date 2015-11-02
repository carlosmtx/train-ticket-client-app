package com.railway.railway.business.api.request;


import java.sql.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by Leonel on 26/10/2015.
 */
public class PurchaseTicketRequestData {

    String arrival;
    String departure;
    Timestamp datetime;

    public PurchaseTicketRequestData(String arrival, String departure, String date, String time) {
        this.arrival = arrival;
        this.departure = departure;

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm");
            long milis = dateFormat.parse(date + " " + time).getTime();
            this.datetime = new Timestamp(milis);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public Timestamp getDateTime() {
        return datetime;
    }

}
