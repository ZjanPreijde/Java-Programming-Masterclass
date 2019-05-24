package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-21, 14:17
*/

import java.util.*;

public class TheatreComparators {
    private final String theatreName;
    private List <Seat> seats = new LinkedList <>();

    static final Comparator<Seat> PRICE_ORDER_ASC, PRICE_ORDER_DESC;

    static {
        PRICE_ORDER_ASC = new Comparator <Seat>() {
            @Override
            public int compare( Seat s1, Seat s2 ) {
                if ( s1.getPrice() > s2.getPrice() ) {
                    return 1;
                } else if ( s1.getPrice() < s2.getPrice() ) {
                    return -1;
                }
                return 0;
//            return Double.compare(s1.getPrice(), s2.getPrice());
            }
        };
        PRICE_ORDER_DESC = new Comparator <Seat>() {
            @Override
            public int compare( Seat s1, Seat s2 ) {
                // works only when Seat.price is type Double
                return -( s1.getPrice().compareTo( s2.getPrice() ) );
            }
        };
    }

    static final Comparator<Seat> PRICE_ORDER_DESC2 = new Comparator <Seat>() {
        @Override
        public int compare( Seat s1, Seat s2 ) {
            // works when Seat.price is type double / Double
            return -(Double.compare(s1.getPrice(), s2.getPrice()));
        }
    } ;

    public TheatreComparators( String theatreName, int numRows, int seatsPerRow ) {
        this.theatreName = theatreName;

        // char 'A'  + int (numRows - 1) -> converts char 'A' to ASCII-code 65 and adds (numRows - 1)
        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= numRows; seatNum++) {
                double price = 12;
                if ((row < 'C') && (seatNum >= 2 && seatNum <= 3)) {
                    price += 3;
                } else if (row > 'D' || seatNum < 2 || seatNum > 3) {
                    price -= 3;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public Collection <Seat> getSeats() {
        return seats;
    }

    public boolean reserveSeat( String seatNumber) {
        Seat requestedSeat = new Seat(seatNumber, 0);
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

    public class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved;
        private Double price;

        public Seat( String seatNumber, double price ) {
            this.seatNumber = seatNumber;
            this.price      = price;
        }

        public String getSeatNumber() {
            return seatNumber;
        }

        public Double getPrice() {
            return price;
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
            return "\nSeat " + seatNumber + " (" + price + ") is "
                    + (reserved ? "" : "not ") + "reserved";
        }
    }
}

