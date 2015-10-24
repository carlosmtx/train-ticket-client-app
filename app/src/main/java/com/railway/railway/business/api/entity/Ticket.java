package com.railway.railway.business.api.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Leonel on 23/10/2015.
 */
public class Ticket implements Serializable {

    private int id;
    private String departure;
    private String arrival;
    private boolean validated;
    private float price;
    private String departureTime;

    public Ticket(JSONObject t) throws JSONException {
        this.departure = t.get("departure").toString();
        this.arrival = t.get("arrival").toString();
        this.validated = (boolean) t.get("validated");
        this.price = Float.valueOf(t.get("price").toString());
        this.id = (Integer) t.get("id");
        this.departureTime =  t.get("departureTime").toString();

    }
    public int getId() {
        return id;
    }

    public String getDeparture() {
        return departure;
    }


    public String getArrival() {
        return arrival;
    }


    public Boolean getValidated() {
        return validated;
    }


    public Float getPrice() {
        return price;
    }


    public String getDepartureTime() {
        return departureTime;
    }


}
