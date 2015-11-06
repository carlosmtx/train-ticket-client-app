package com.railway.railway.activity.listeners;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.railway.railway.activity.adapter.TicketListAdapter;
import com.railway.railway.business.api.entity.Ticket;


/**
 * Created by Leonel on 23/10/2015.
 */
public class UserActivityTicketClick implements AdapterView.OnItemClickListener{

    public UserActivityTicketClick(){
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        int count = adapterView.getAdapter().getCount();

        for(int j = 0 ; j < count ; j++){
            TicketListAdapter.TicketWrapper ticket  = (TicketListAdapter.TicketWrapper)adapterView.getItemAtPosition(j);
            ticket.collpase();
        }

        TicketListAdapter.TicketWrapper ticket = (TicketListAdapter.TicketWrapper) adapterView.getItemAtPosition(i);
        if(!ticket.isExpanded()){
            ticket.expand();
        } else {
            ticket.collpase();
        }
        ((BaseAdapter) adapterView.getAdapter()).notifyDataSetChanged();
    }
}
