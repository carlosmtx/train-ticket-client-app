package com.railway.railway.activity.listeners;

import android.view.View;
import android.widget.Toast;

import com.railway.railway.business.api.API;
import com.railway.railway.business.api.RailwayAPI;
import com.railway.railway.business.api.response.AuthResponse;

public class LoginActivityLoginClick implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        //TextView emailInput= (TextView)view.findViewById(R.id.email);
        //TextView passwInput= (TextView)view.findViewById(R.id.password);

        String email = "dasdasdassd";//emailInput.getText().toString();
        String passw = "dasdasdassd";//passwInput.getText().toString();

        API api = RailwayAPI.getInstance(view.getContext());
        AuthResponse response = null;
        try {
             response = (AuthResponse) api.login(email,passw);
        } catch (Exception e) {
            //TODO: Improve Exception Handling
            e.printStackTrace();
        }
        assert response != null;
        Toast.makeText(view.getContext(),response.response.toString(),Toast.LENGTH_LONG).show();

    }
}
