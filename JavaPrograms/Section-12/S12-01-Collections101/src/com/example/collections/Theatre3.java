package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-21, 14:17
*/

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Theatre3 {
    private final String theatreName;
    // made public for demo purposes
    public List <Seat> seats = new LinkedList <>();

    public Theatre3( String theatreName, int numRows, int seatsPerRow ) {
        this.theatreName = theatreName;

        // char 'A'  + int (numRows - 1) -> converts char 'A' to ASCII-code 65 and adds (numRows - 1)
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= numRows; seatNum++) {
                Seat seat = new Seat(row + String.format("%02d", seatNum));
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat(String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch( ((List) seats), requestedSeat, null );
        if (foundSeat >= 0) {
            return ((Seat) ((List) seats).get(foundSeat)).reserve();
        } else {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
    }

    public void printSeats() {
        System.out.println("Seats overview");
        for (Seat seat : seats) {
            System.out.println(seat.toString());
        }
    }

    // made public for demo purposes
    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved;

        public Seat( String seatNumber ) {
            this.seatNumber = seatNumber;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public boolean reserve() {
            if (reserved) {
                System.out.println("Seat " + seatNumber + " is already reserved");
                return false;
            }
            reserved = true;
            System.out.println("Seat " + seatNumber + " is now reserved");
            return true;
        }
        public boolean cancel() {
            if (reserved) {
                reserved = false;
                System.out.println("Reservation cancelled");
                return true;
            }
            System.out.println("Seat was not reserved, reservation not cancelled");
            return false;
        }

        @Override
        public int compareTo( Seat seat ) {
            return this.seatNumber.compareToIgnoreCase( seat.getSeatNumber() );
        }

        public String toString() {
            return seatNumber + " is " + (reserved ? "" : "not ") + "reserved";
        }
    }
}

