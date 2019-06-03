package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-28, 16:33
*/

public class Planet extends HeavenlyBody {
    public Planet( String name, double orbitalPeriod ) {
        super( name, orbitalPeriod, BodyTypes.PLANET );
    }

    public boolean addMoon(Moon moon) {
        return this.addSatellite( moon );
    }
    @Override
    public boolean addSatellite( HeavenlyBody satellite ) {
        if (satellite.getKey().getBodyType() != BodyTypes.MOON) return false;
        return super.addSatellite( satellite );
    }
}
