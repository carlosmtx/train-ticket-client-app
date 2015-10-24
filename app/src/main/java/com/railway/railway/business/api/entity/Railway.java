package com.railway.railway.business.api.entity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Leonel on 24/10/2015.
 */
public class Railway {

    private ArrayList<String> stations;
    private ArrayList<Connection> connections;

    public Railway(JSONObject railwayInfo) throws JSONException {
        // Stations Array
        this.stations = new ArrayList<>();
        JSONArray stationsInfo = railwayInfo.getJSONArray("stations");

        if (stationsInfo != null) {
            for (int i=0;i<stationsInfo.length();i++){
                this.stations.add(stationsInfo.get(i).toString());
            }
        }

        // Connections
        //this.connections = new ArrayList<>();
        //JSONArray connectionsInfo = railwayInfo.getJSONArray("connections");
//
        //if (connectionsInfo != null) {
        //    for (int i=0;i<connectionsInfo.length();i++){
        //        Connection currentConn = new Connection(connectionsInfo.getJSONObject(i));
        //        this.connections.add(currentConn);
        //    }
        //}

    }

    public ArrayList<String> getStations() {
        return stations;
    }
}
