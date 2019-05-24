package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-24, 16:44
*/

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set <HeavenlyBody> satellites;

    public HeavenlyBody( String name, double orbitalPeriod ) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet <>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set <HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    public boolean addMoon( HeavenlyBody moon) {
        return this.satellites.add( moon );
    }

    public String toString() {
        return this.name + " has an orbital period of " + this.orbitalPeriod + " days";
    }

    @Override
    public boolean equals( Object o ) {
        if ( this == o ) return true;
        if ( o == null || getClass() != o.getClass() ) return false;
        HeavenlyBody that = (HeavenlyBody) o;
        return name.equals( that.name );
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
