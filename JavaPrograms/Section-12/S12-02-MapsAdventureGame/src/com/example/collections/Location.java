package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-23, 16:20
*/

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map <String, Integer> exits;

    public Location( int locationID, String description ) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap <String, Integer>();
    }

    public void addExit(String direction, int location) {
        exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map <String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
