package com.railway.railway.business.api.request;

/**
 * Created by Leonel on 26/10/2015.
 */
public class PurchaseTicketRequestData {

    String arrival;
    String departure;
    String date;
    String time;

    public PurchaseTicketRequestData(String arrival, String departure, String date, String time) {
        this.arrival = arrival;
        this.departure = departure;
        this.date = date;
        this.time = time;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }

    public String getDate() {
        return date;
    }


    public String getTime() {
        return time;
    }
}
