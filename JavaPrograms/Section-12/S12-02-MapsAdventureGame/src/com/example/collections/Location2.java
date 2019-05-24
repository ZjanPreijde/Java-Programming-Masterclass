package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-23, 16:20
*/

import java.util.HashMap;
import java.util.Map;

public class Location2 {
    private final int locationID;
    private final String description;
    private final Map <String, Integer> exits;

    public Location2( int locationID, String description, Map<String, Integer> exits) {
        this.locationID  = locationID;
        this.description = description;
        this.exits       = exits == null
                ? new HashMap<>()
                : new HashMap<>(exits);
    }

//    public void addExit(String direction, int location) {
//        exits.put(direction, location);
//    }
//
    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map <String, Integer> getExits() {
        return new HashMap<>(exits);
    }
}
