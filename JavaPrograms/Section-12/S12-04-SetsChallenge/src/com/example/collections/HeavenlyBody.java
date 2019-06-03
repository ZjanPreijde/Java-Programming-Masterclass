package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-24, 16:44
*/

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private Key key;
    private final double orbitalPeriod;
    private final Set <HeavenlyBody> satellites;

    public enum BodyTypes {
        STAR, PLANET {
            public String toString() {
                return "plennet";
            }
        },
        DWARF_PLANET,
        MOON {
            public String toString() {
                return "Moon";
            }
        },
        COMET, ASTEROID
    }

    public HeavenlyBody( String name, double orbitalPeriod, BodyTypes bodyType ) {
        this.key = new Key( name, bodyType );
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet <>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public String getName() {
        return key.getName();
    }

    public BodyTypes getBodyType() {
        return key.getBodyType();
    }

    public Set <HeavenlyBody> getSatellites() {
        return new HashSet <>( this.satellites );
    }

    public boolean addSatellite( HeavenlyBody satellite ) {
        if ( this.key.bodyType == satellite.getKey().getBodyType() ) return false;
        return this.satellites.add( satellite );
    }

    public String toString() {
        return key + ", and has an orbital period of " + this.orbitalPeriod + " days";
    }

    public static Key makeKey( String name, BodyTypes bodyType ) {
        return new Key( name, bodyType );
    }

    @Override
    public final boolean equals( Object obj ) {
        if ( this == obj ) return true;
        if ( obj instanceof HeavenlyBody ){
            HeavenlyBody that = (HeavenlyBody) obj;
            return this.key.equals( that.getKey());
            // Use  ==  for enums
//            return name.equals( that.name ) && bodyType == that.getBodyType() ;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
//        return Objects.hash(key);
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;
        private Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals( Object obj ) {
            Key key = (Key) obj;
            if (this.name.equals( key.getName() )) {
                return bodyType == key.getBodyType();
            }
            return false;
        }

        @Override
        public String toString() {
            return name + " is a " + bodyType;
        }
    }
}
