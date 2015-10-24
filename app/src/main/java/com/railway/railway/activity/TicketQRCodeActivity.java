package com.railway.railway.activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.railway.railway.R;
import com.railway.railway.business.api.entity.Ticket;

import net.glxn.qrgen.android.QRCode;

public class TicketQRCodeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_qrcode);

        Ticket ticket = (Ticket)getIntent().getSerializableExtra("ticket");
        TextView ticketInfo = (TextView)findViewById(R.id.ticketqrcode_lbl_ticket);
        String infoTxt = "From: "
                + ticket.getDeparture() + "\n"
                + "To: "
                + ticket.getArrival() + "\n"
                + ticket.getPrice() + "€\n"
                + "At: " + ticket.getDepartureTime();
        ticketInfo.setText(infoTxt);
        Bitmap myBitmap = QRCode.from(infoTxt.replace('\n',',')).bitmap();
        ImageView myImage = (ImageView) findViewById(R.id.ticketqrcode_qrcode_image);
//        myImage.invalidate();
        myImage.setImageBitmap(myBitmap);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ticketqrcode, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
