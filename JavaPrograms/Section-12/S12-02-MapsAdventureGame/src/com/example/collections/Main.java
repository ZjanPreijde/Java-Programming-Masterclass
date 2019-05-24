package com.example.collections;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.*;

public class Main {
    private static Map <Integer, Location> locations = new HashMap<>(  );
    private static Map <Integer, Location2> locations2 = new HashMap<>(  );

    private static Map <String, String> directions = new HashMap<>( );

    public static void main(String[] args) {

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        HashSet

        Map<String, Integer> tempExit;

        // Add exits
        tempExit = new HashMap<>();
        tempExit = null;
        locations2.put(0, new Location2(0, "You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put( "W", 2 );
        tempExit.put( "E", 3 );
        tempExit.put( "S", 4 );
        tempExit.put( "N", 5 );
        tempExit.put( "Q", 0 );
        locations2.put(1, new Location2(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put( "N", 5 );
        locations2.put(2, new Location2(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put( "W", 1 );
        locations2.put(3, new Location2(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put( "W", 2 );
        tempExit.put( "N", 1 );
        locations2.put(4, new Location2(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put( "W", 2 );
        tempExit.put( "S", 1 );
//        locations2.put(5, new Location2(5, "You are int the forest", tempExit));
        locations2.put(5, new Location2(5, null, tempExit));


        // challenge the Location class' immutablility
        tempExit.remove( "S" );


//        main1();
//        main2();
//        main3();
        main4();
    }

    private static void main1() {
        System.out.println("--------------------");
        Scanner scanner = new Scanner(System.in);


        int loc = 1, key = 0;
        while (true) {
            System.out.println(locations.get( loc ).getDescription());
            key = scanner.nextInt();
            if (!locations.containsKey(key)) {
                System.out.println("You can not go in that direction");
            } else {
                loc = key;
                if (loc == 0) {
                    System.out.println("Back to work!");
                    break;
                }
            }
            scanner.nextLine();
        }
        System.out.println("--------------------");
    }

    private static void main2() {
        System.out.println("--------------------");
        Scanner scanner = new Scanner(System.in);

        // Add exits
        locations.get(1).addExit( "W", 2 );
        locations.get(1).addExit( "E", 3 );
        locations.get(1).addExit( "S", 4 );
        locations.get(1).addExit( "N", 5 );
        locations.get(1).addExit( "Q", 0 );

        locations.get(2).addExit( "N", 5 );

        locations.get(3).addExit( "W", 1 );

        locations.get(4).addExit( "W", 2 );
        locations.get(4).addExit( "N", 1 );

        locations.get(5).addExit( "W", 2 );
        locations.get(5).addExit( "S", 1 );


        int loc = 1;
        String dir = "";
        while (true) {
            System.out.println(locations.get( loc ).getDescription());
            System.out.print("Available options are");
            locations.get( loc ).getExits().forEach( (key, value) -> {
                System.out.print( " " + key );
            } );
            System.out.print(". Please make your choice :");
            System.out.println();
            dir = scanner.nextLine().toUpperCase();
            if (!locations.get(loc).getExits().containsKey(dir)) {
                System.out.println("You can not go in that direction");
            } else {
                loc = locations.get( loc ).getExits().get( dir );
                if (loc == 0) {
                    System.out.println("Back to work!");
                    break;
                }
            }
        }
        System.out.println("--------------------");
    }

    private static void main3() {
        System.out.println("--------------------");
        Scanner scanner = new Scanner(System.in);

        // Add exits
        locations.get(1).addExit( "W", 2 );
        locations.get(1).addExit( "E", 3 );
        locations.get(1).addExit( "S", 4 );
        locations.get(1).addExit( "N", 5 );
        locations.get(1).addExit( "Q", 0 );

        locations.get(2).addExit( "N", 5 );

        locations.get(3).addExit( "W", 1 );

        locations.get(4).addExit( "W", 2 );
        locations.get(4).addExit( "N", 1 );

        locations.get(5).addExit( "W", 2 );
        locations.get(5).addExit( "S", 1 );

        // Init directions
        directions.put("NORTH", "N");
        directions.put("WEST" , "W");
        directions.put("SOUTH", "S");
        directions.put("EAST" , "E");
        directions.put("QUIT" , "Q");

        int loc = 1;
        while (true) {
            System.out.println(locations.get( loc ).getDescription());
            System.out.print("Available options are");
            locations.get( loc ).getExits().forEach( (key, value) -> {
                System.out.print( " " + key );
            } );
            System.out.print(". Please make your choice :");
            System.out.println();
            String[] words = scanner.nextLine().toUpperCase().split(" ");
            String dir2 = " ";
            for (String word : words) {
                if (word.length() == 1
                        &&  locations.get( loc ).getExits().containsKey( word ) ) {
                    dir2 = word;
                    break;
                } else if (directions.containsKey(word)) {
                    dir2 = directions.get(word);
                    break;
                }
            }
            if (dir2 == " ") {
                System.out.println("You can not go in that direction");
            } else {
                System.out.println("Choice : " + dir2);
                loc = locations.get( loc ).getExits().get( dir2 );
                if (loc == 0) {
                    System.out.println("Back to work!");
                    break;
                }
            }
        }
        System.out.println("--------------------");
    }
    private static void main4() {

        System.out.println("--------------------");
        Scanner scanner = new Scanner(System.in);

        // Init directions
        directions.put("NORTH", "N");
        directions.put("WEST" , "W");
        directions.put("SOUTH", "S");
        directions.put("EAST" , "E");
        directions.put("QUIT" , "Q");

        int loc = 1;
        while (true) {
            System.out.println(locations2.get( loc ).getDescription());
            System.out.print("Available options are");
            locations2.get( loc ).getExits().forEach( (key, value) -> {
                System.out.print( " " + key );
            } );
            System.out.print(". Please make your choice :");
            System.out.println();
            String[] words = scanner.nextLine().toUpperCase().split(" ");
            String dir2 = " ";
            for (String word : words) {
                if (word.length() == 1
                        &&  locations2.get( loc ).getExits().containsKey( word ) ) {
                    dir2 = word;
                    break;
                } else if (directions.containsKey(word)) {
                    dir2 = directions.get(word);
                    break;
                }
            }
            if (dir2 == " ") {
                System.out.println("You can not go in that direction");
            } else {
                System.out.println("Choice : " + dir2);
                loc = locations2.get( loc ).getExits().get( dir2 );
                if (loc == 0) {
                    System.out.println("Back to work!");
                    break;
                }
            }
        }
        System.out.println("--------------------");
    }

}
