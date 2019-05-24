package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-13, 15:25
*/

/*
    public inner class Gear

    Gearbox gearBox = new GearBox();
    Gearbox.Gear neutral = gearBox.new Gear( params );
 this does NOT work :
    Gearbox.Gear first = new Gearbox.Gear( params );
 this also does NOT work :
    Gearbox.Gear second = gearBox.Gear( params );
*/

import java.util.ArrayList;

public class Gearbox1 {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;

    public Gearbox1( int maxGears ) {
        this.maxGears = maxGears;
        this.gears    = new ArrayList <>(  );
        Gear neutral  = new Gear( 0,0.0 );
        this.gears.add( neutral );
    }

    // Inner class
    public class Gear {
        private int gearNumber;
        private double ratio;

        public Gear( int gear, double ratio ) {
            this.gearNumber = gear;
            this.ratio      = ratio;
        }

        public double driveSpeed( int revs ) {
            return (  revs * this.ratio ); //
        }

    }

}
