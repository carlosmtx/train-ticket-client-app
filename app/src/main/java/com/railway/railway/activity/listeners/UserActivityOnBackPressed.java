package com.railway.railway.activity.listeners;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import com.railway.railway.activity.LoginActivity;

/**
 * Created by Leonel on 23/10/2015.
 */
public class UserActivityOnBackPressed {
    private Activity activity;

    public UserActivityOnBackPressed(Activity ctx){
        this.activity = ctx;
        triggerAlertDialog();
    }

    //TODO: Strings no XML
    private void triggerAlertDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setCancelable(true);
        builder.setMessage("Do you want to Log Out?");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(activity, LoginActivity.class);
                activity.startActivity(intent);
                activity.finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }


}
