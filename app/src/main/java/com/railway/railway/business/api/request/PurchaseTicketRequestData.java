package com.railway.railway.business.api.request;

/**
 * Created by Leonel on 26/10/2015.
 */
public class PurchaseTicketRequestData {

    String arrival;
    String departure;

    public PurchaseTicketRequestData(String arrival, String departure) {
        this.arrival = arrival;
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public String getDeparture() {
        return departure;
    }
}
