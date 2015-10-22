package com.railway.railway.activity.listeners;

import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import com.railway.railway.R;
import com.railway.railway.activity.RegisterActivity;
import com.railway.railway.business.api.request.RegisterRequestData;

/**
 * Created by cteixeira on 22-10-2015.
 * com.railway.railway.activity.listeners
 */
public class RegisterActivityRegisterClick implements View.OnClickListener {


    @Override
    public void onClick(View view) {
        RegisterActivity activity = (RegisterActivity) view.getContext();
        TextView username = (TextView)activity.findViewById(R.id.register_username);
        TextView email = (TextView)activity.findViewById(R.id.register_email);
        TextView password = (TextView)activity.findViewById(R.id.register_password);
        TextView creditCardNr = (TextView)activity.findViewById(R.id.register_credit_card_nr);
        Spinner creditCardType = (Spinner)activity.findViewById(R.id.register_credit_card_type);

        RegisterRequestData data = new RegisterRequestData(
                username.getText().toString(),
                email.getText().toString(),
                password.getText().toString(),
                creditCardNr.getText().toString(),
                creditCardType.getSelectedItem().toString(),
                "11/08"
        );
        new RegisterActivityRegisterTask(view.getContext(),data).execute();
    }
}
