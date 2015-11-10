package com.railway.railway.business.api.entity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by cteixeira on 10-10-2015.
 */
public class User implements Serializable {
    public String token;
    public String email;
    public String name;
    public String password;

    private String cardType;
    private String cardNumber;
    private String cardExpiration;

    public User(JSONObject response) throws JSONException {
        this.email = response.get("email").toString();
        this.name = (response.isNull("name")) ? "" : (response.get("name").toString()) ;
        this.password = response.get("password").toString();
        this.email = response.get("email").toString();
        this.cardType = response.get("cardType").toString();
        this.cardNumber = response.get("cardNumber").toString();
        this.cardExpiration = response.get("cardExpiration").toString();
        this.token = response.get("token").toString();
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

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }
}
