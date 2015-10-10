package com.railway.railway.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import com.railway.railway.R;
import com.railway.railway.activity.listeners.LoginActivityLoginClick;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //add handler for login
        Button login = (Button)findViewById(R.id.email_sign_in_button);

        login.setOnClickListener(new LoginActivityLoginClick());


        //add handler for register
/*        Button register = (Button)findViewById(R.id.register_button);
        register.setOnClickListener();*/




    }
}

