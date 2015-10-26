package com.railway.railway.business.api.entity;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by cteixeira on 10-10-2015.
 */
public class User {
    public String token;
    public String email;

    private String cardType;
    private String cardNumber;
    private String cardExpiration;

    //TODO: Add extra user fields to this entity
    protected JSONObject response;

    public User(JSONObject response) throws JSONException {
        this.response = response;
        this.token = response.get("token").toString();
        this.email = response.get("email").toString();
        this.cardType = response.get("cardType").toString();
        this.cardNumber = response.get("cardNumber").toString();
        this.cardExpiration = response.get("cardExpiration").toString();
    }

    public String getCardType() {
        return cardType;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCardExpiration() {
        return cardExpiration;
    }
}
