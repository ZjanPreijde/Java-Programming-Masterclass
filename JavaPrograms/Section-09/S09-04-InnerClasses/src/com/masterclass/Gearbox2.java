package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-13, 15:25
*/

/*
    private inner class Gear,
    adding gears done by outer class through public method addGear()
     which can be called from the outside world
*/

import java.util.ArrayList;

public class Gearbox2 {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox2( int maxGears ) {
        this.maxGears   = maxGears;
        this.gears      = new ArrayList <>(  );
        this.gears.add( new Gear(0,0.0 ) );
        this.operateClutch( false );
    }
    public boolean addGear( int gear, double ratio ){
        if ( ( gears.size() - 1 ) == this.maxGears ) {
            // gear 0 plus gears
            System.out.println("addGear(). Maximum numbers of gears reached");
            return false;
        }
        if ( gear <= 0 || gear > maxGears ) {
            System.out.println("addGear(). Invalid gear number " + gear );
            return false;
        }
        if (isValidGear( gear )) {
            System.out.println("addGear(). Gear number " + gear + " already exists" );
            return false;
        }
        this.gears.add( new Gear( gear, ratio ) );
        System.out.println("addGear(). Gear added, we now have "
                + ( gears.size() - 1 )
                + " gears");
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
            System.out.println("changeGear(). Please push the "
                    + "clutch down before switching gears");
            return false;
        }
        if ( newGear < 0 || newGear > maxGears ) {
            System.out.println("changeGear(). Invalid gear " + newGear);
            return false;
        }
        if ( this.isValidGear( newGear ) ) {
            this.currentGear = newGear;
            System.out.println("changeGear(). Changed gear to " + newGear + ", please release the clutch");
            return true;
        }
        System.out.println("changeGear(). Gear " + newGear + " does not seem to work");
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
            return (  revs * this.ratio ); //
        }

    }

}
