package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-21, 14:17
*/

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Theatre2 {
    private final String theatreName;
    private List <Seat> seats = new LinkedList <>();

    public Theatre2( String theatreName, int numRows, int seatsPerRow ) {
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
        // searching whole List for seat, can be slow for large Collection
        Seat requestedSeat = null;
        for (Seat seat : seats) {
            if (seat.getSeatNumber().equals(seatNumber)) {
                requestedSeat = seat;
                break;
            }
        }
        if (requestedSeat == null) {
            System.out.println("There is no seat " + seatNumber);
            return false;
        }
        return requestedSeat.reserve();
    }

    public boolean binarySearchReserveSeat( String seatNumber) {
        // manual .binarySearch()
        int low = 0;
        int high = seats.size() - 1;

        while (low <= high) {
            System.out.print(".");
            // Collections uses  'int mid = (low + high) >>> 1',
            //  unsigned right bit-shift operator,
            //  to prevent 'integer overflow' :
            //  adding high int values resulting in negative numbers.
            int mid = (low + high) / 2; // int (0 + 1) / 2 -> 0
            Seat midVal = seats.get(mid);
            int cmp = midVal.getSeatNumber().compareTo(seatNumber);

            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return seats.get(mid).reserve();
            }
        }
        System.out.println("There is no seat " + seatNumber);
        return false;
    }

    public boolean reserveSeat2(String seatNumber) {
        // using Collections.binarySearch()
        Seat requestedSeat = new Seat(seatNumber);
        int foundSeat = Collections.binarySearch( seats, requestedSeat, null );
        if (foundSeat >= 0) {
            return seats.get(foundSeat).reserve();
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

    private class Seat implements Comparable<Seat> {
        // Go for it buddy!!
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
            // using String.compareToIgnoreCase()
            return this.seatNumber.compareToIgnoreCase( seat.getSeatNumber() );
        }

        public String toString() {
            return seatNumber + " is " + (reserved ? "" : "not ") + "reserved";
        }
    }
}

