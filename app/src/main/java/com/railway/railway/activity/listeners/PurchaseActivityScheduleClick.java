package com.railway.railway.activity.listeners;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;

import com.railway.railway.DI;
import com.railway.railway.R;
import com.railway.railway.activity.PurchaseSelectScheduleActivity;
import com.railway.railway.business.api.entity.User;
import com.railway.railway.business.api.request.PurchaseTicketRequestData;

/**
 * Created by Leonel on 26/10/2015.
 */
public class PurchaseActivityScheduleClick implements View.OnClickListener {
    private String departure;
    private String arrival;
    private String scheduleSelected;

    public PurchaseActivityScheduleClick(String dep, String arr, String scheduleSelected){
        this.departure = dep;
        this.arrival = arr;
        this.scheduleSelected = scheduleSelected;
    }

    @Override
    public void onClick(View view) {
        PurchaseSelectScheduleActivity activity = (PurchaseSelectScheduleActivity) view.getContext();

        String cardNumber = DI.get().provideStorage().getUser().getCardNumber();
        String cardType = DI.get().provideStorage().getUser().getCardType();

        // Criar dialog de confirm
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.purchase_confirm_dialog_title);
        builder.setMessage("You are going to purchase a ticket to travel:\n" +
                        "- From " + this.departure + "\n" +
                        "- To " + this.arrival + "\n" +
                        "- Leaving at " + this.scheduleSelected + "\n" +
                        "With your credit card ending in " + cardNumber.substring(cardNumber.length() - 3) + "\n" +
                        "Are you sure you want to proceed?"
        );

        PurchaseTicketRequestData data = new PurchaseTicketRequestData(arrival,departure);

        builder.setPositiveButton(R.string.purchase_confirm_dialog_positive, new PurchaseActivityDialogSuccessClick(activity,data));
        builder.setNegativeButton(R.string.purchase_confirm_dialog_negative, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                // User cancelled the dialog
                // Do nothing. Intended
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        //Intent intent = new Intent(activity, PurchaseSelectScheduleActivity.class);
        //intent.putExtra("departure", activity.getSelectedDeparture());
        //intent.putExtra("arrival", activity.getSelectedArrival());
        //activity.startActivity(intent);
    }
}
