package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-13, 15:25
*/

/*
    private inner class Gear
    private method addGear()
    no way to add gears from the outside.
*/

import java.util.ArrayList;

public class Gearbox3 {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox3( int maxGears ) {
        this.maxGears   = maxGears;
        this.gears      = new ArrayList <>(  );
        for (int i = 0; i <= maxGears; i++) {
            this.addGear( i, i * 5.3 );
        }
        this.operateClutch( false );
    }
    private boolean addGear( int gear, double ratio ){
        this.gears.add( new Gear( gear, ratio ) );
        System.out.println("Gear " + gear + " added, we now have "
                +  gears.size()
                + " gears, including neutral");
        return true;
    }

    public void operateClutch( boolean in ) {
        this.clutchIsIn = in;
        if ( this.clutchIsIn ) {
            System.out.println("Clutch is down");
        } else {
            System.out.println("Clutch is up");
        }
    }
    public boolean changeGear( int newGear ) {
        if ( !this.clutchIsIn ) {
            System.out.println("Please push the "
                    + "clutch down before switching gears");
            return false;
        }
        if ( newGear < 0 || newGear > maxGears ) {
            System.out.println("Invalid gear " + newGear);
            return false;
        }
        if ( this.isValidGear( newGear ) ) {
            this.currentGear = newGear;
            System.out.println("Changed gear to " + newGear
                    + ", please release the clutch");
            return true;
        }
        System.out.println("Gear " + newGear + " does not seem to work");
        return false;
    }

    private boolean isValidGear( int newGear ) {
        for ( Gear gear : gears ) {
            if ( gear.gearNumber == newGear ) {
                return true;
            }
        }
        return false;
    }

    public double wheelSpeed( int revs ) {
        if ( clutchIsIn ) {
            System.out.println("Scream!!");
            return 0.0;
        }
        return revs * gears.get(currentGear).getRatio();
    }

    private class Gear {
        private int gearNumber;
        private double ratio;

        public Gear( int gear, double ratio ) {
            this.gearNumber = gear;
            this.ratio      = ratio;
        }

        public double getRatio() {
            return ratio;
        }

        public double driveSpeed( int revs ) {
            // Teacher is using wheel RPM, not engine RPM?
            // Seems silly, no car has a wheel RPM indicator
            return (  revs * this.ratio ); //
        }

    }

}
