package com.example.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    main0();

	    main3();
        main4();
    }

    private static void main0() {
        System.out.println("-----------");
        int lastRow = 'A' + 10;
        System.out.println(lastRow);
        char firstRow = 'A';
        firstRow++;
        System.out.println(firstRow);
        System.out.println('B' > 65);
    }
    private static void main3() {
        System.out.println("===========");
        System.out.println("Theatre 3");
        System.out.println("-----------");
        Theatre3 theatre = new Theatre3( "Apollo", 5, 5 );
        theatre.reserveSeat( "C02" );
        theatre.reserveSeat( "C02" );
        theatre.reserveSeat( "C02" );
        theatre.reserveSeat( "F02" );

        System.out.println("\nShallow copy collection seats :");
        List<Theatre3.Seat> seatCopy = new ArrayList <>(theatre.seats);
        printList3(seatCopy);

        System.out.println("\nCollections.reverse() shallow copy:");
        Collections.reverse(seatCopy);
        System.out.println("Copy :");
        printList3(seatCopy);
        System.out.println("Original :");
        printList3(theatre.seats);

        System.out.println("\nCollections.shuffle() shallow copy");
        Collections.shuffle(seatCopy);
        System.out.println("Copy :");
        printList3(seatCopy);
        System.out.println("Original :");
        printList3(theatre.seats);

        System.out.println("\nCollections.min() - Collections.max()");
        Theatre3.Seat minSeat = Collections.min( seatCopy );
        Theatre3.Seat maxSeat = Collections.max( seatCopy );
        System.out.println("Min seat is " + minSeat.getSeatNumber());
        System.out.println("Max seat is " + maxSeat.getSeatNumber());

        System.out.println("\nSorting shallow copy using compareTo() and Collections.swap()");
        sortList3(seatCopy);
        printList3(seatCopy);
    }
    public static void printList3( List <Theatre3.Seat> list) {
        System.out.println("---------------");
        for (Theatre3.Seat seat : list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println("");
        System.out.println("---------------");


    }
    // using Collections.swap() to create our own .sort() method
    public static void sortList3( List<? extends Theatre3.Seat> list ) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).compareTo(list.get(j)) > 0) {
                    Collections.swap(list, i, j);
                }
            }
        }
    }

    private static void main4() {
        System.out.println( "===========" );
        System.out.println( "Theatre 4" );
        System.out.println( "-----------" );
        TheatreComparators theatre = new TheatreComparators( "Apollo", 5, 5 );
        theatre.reserveSeat( "C02" );
        theatre.reserveSeat( "C02" );
        theatre.reserveSeat( "D02" );
        System.out.println(theatre.getSeats());

        List<TheatreComparators.Seat> seatCopy = new ArrayList<>(theatre.getSeats());
        Collections.sort( seatCopy, TheatreComparators.PRICE_ORDER_ASC );
        System.out.println(seatCopy );
        Collections.sort( seatCopy, TheatreComparators.PRICE_ORDER_DESC );
        System.out.println(seatCopy );

    }

}
