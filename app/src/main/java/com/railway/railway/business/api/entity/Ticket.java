package com.railway.railway.business.api.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Leonel on 23/10/2015.
 */
public class Ticket implements Serializable {

    private int id;
    private String start;
    private String end;
    private boolean validated;
    private float price;
    private int train;

    public Ticket(JSONObject t) throws JSONException {
        this.start = t.get("start").toString();
        this.end = t.get("end").toString();
        this.validated = (boolean) t.get("validated");
        this.price = Float.valueOf(t.get("price").toString());
        this.train = (Integer) t.get("train");
        this.id = (Integer) t.get("id");

    }
    public int getId() {
        return id;
    }

    public String getStart() {
        return start;
    }


    public String getEnd() {
        return end;
    }


    public Boolean getValidated() {
        return validated;
    }


    public Float getPrice() {
        return price;
    }


    public Integer getTrain() {
        return train;
    }


}
