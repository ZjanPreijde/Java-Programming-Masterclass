package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-28, 17:22
*/

public class Moon extends HeavenlyBody {
    public Moon( String name, double orbitalPeriod ) {
        super( name, orbitalPeriod, BodyTypes.MOON );
    }

    @Override
    public boolean addSatellite( HeavenlyBody satellite ) {
        // A moon does not have satellites
        return false;
    }
}
