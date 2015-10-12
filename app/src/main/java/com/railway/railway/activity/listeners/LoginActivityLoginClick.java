package com.railway.railway.activity.listeners;

import android.view.View;
import android.widget.TextView;
import com.railway.railway.R;

public class LoginActivityLoginClick implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        //TextView emailInput= (TextView)view.findViewById(R.id.email);
        //TextView passwInput= (TextView)view.findViewById(R.id.password);
        new LoginActivityLoginClickTask().execute(
                "DASDASD",//emailInput.getText().toString(),
                "DASDASD"//passwInput.getText().toString()
        );
    }
}
