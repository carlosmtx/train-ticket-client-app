package com.railway.railway.business.api.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Leonel on 23/10/2015.
 */
public class Ticket implements Serializable {
    private String start;
    private String end;
    private Boolean validated;
    private Float price;
    private Integer train;

    public Ticket(JSONObject t) throws JSONException {
        this.start = t.get("start").toString();
        this.end = t.get("end").toString();
        this.validated = (Boolean) t.get("validated");
        this.price = Float.valueOf(t.get("price").toString());
        this.train = (Integer) t.get("train");

    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Integer getTrain() {
        return train;
    }

    public void setTrain(Integer train) {
        this.train = train;
    }
}
