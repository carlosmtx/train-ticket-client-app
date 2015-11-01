package com.railway.railway.activity.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.railway.railway.activity.views.TicketListRowView;
import com.railway.railway.business.api.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cteixeira on 31-10-2015.
 * com.railway.railway.activity.adapter
 */
public class TicketListAdapter extends BaseAdapter {
    List<Ticket> tickets;

    public TicketListAdapter(){
        this.tickets = new ArrayList<Ticket>();
    }

    public void addTickets(List<Ticket> tickets){
        this.tickets.addAll(tickets);
    }

    public void add(Ticket ticket){
        this.tickets.add(ticket);
    }

    @Override
    public int getCount() {
        return tickets.size();
    }

    @Override
    public Ticket getItem(int position) {
        return  this.tickets.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.getItem(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView != null){
           return convertView;
        }
        return new TicketListRowView(
                parent.getContext()
        ).setTicket(tickets.get(position));
    }

}
