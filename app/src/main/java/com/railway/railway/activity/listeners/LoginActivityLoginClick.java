package com.railway.railway.activity.listeners;

import android.view.View;
import android.widget.TextView;
import com.railway.railway.R;
import com.railway.railway.activity.LoginActivity;

public class LoginActivityLoginClick implements View.OnClickListener{

    @Override
    public void onClick(View view) {
        LoginActivity activity= (LoginActivity) view.getContext();
        TextView emailInput= (TextView)activity.findViewById(R.id.email);
        TextView passwInput= (TextView)activity.findViewById(R.id.password);
        new LoginActivityLoginClickTask(
                activity,
                emailInput.getText().toString(),
                passwInput.getText().toString()
        ).execute();
    }
}
