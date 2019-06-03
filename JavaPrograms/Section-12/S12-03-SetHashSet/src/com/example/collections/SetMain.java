package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-28, 11:38
*/

import jdk.swing.interop.SwingInterOpUtils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main( String[] args ) {
        Set <Integer> squares = new HashSet <>(  );
        Set <Integer> cubes = new HashSet <>(  );

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add( i * i * i );
        }
        System.out.println(squares.size() + " Squares");
        System.out.println(cubes.size() + " Cubes");

        // Make a union, only unique values
        System.out.println();
        Set<Integer> union = new HashSet <>( squares );
        union.addAll(cubes);
        System.out.println(union.size() + " unified");

        // my code also works, but with retainAll() a lot shorter :-)
        System.out.println("\n- My code :");
        Set<Integer> difference = new HashSet <>( squares );
        difference.removeAll( cubes );
        System.out.println(difference.size() + " difference");

        Set<Integer> duplicates = new HashSet <>( squares );
        duplicates.removeAll( difference );
        System.out.println(duplicates.size() + " duplicates");
        duplicates.forEach( i -> System.out.println("- " + i
                + ", square root: " + ((int) Math.sqrt( i ))
                + ", cube root: " + ((int) Math.cbrt( i ))) );

        System.out.println("\n- .retainAll() :");
        Set<Integer> intersection = new HashSet <>( squares );
        intersection.retainAll( cubes ); // keep what is also in cubes
        System.out.println(intersection.size() + " duplicates : ");
        for (int i : intersection) {
            System.out.println("- " + i
                    + ", square root: " + ((int) Math.sqrt( i ))
                    + ", cube root: " + ((int) Math.cbrt( i )) ) ;
        }

        Set<String> words = new HashSet <>(  );
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll( Arrays.asList( arrayWords) );
        System.out.println("\n- " + sentence);
        for (String s : words) {
            System.out.println("\t" + s);
        }

        Set<String> nature = new HashSet <>(  );
        Set<String> divine = new HashSet <>(  );
        String[] natureWords = {"all", "nature", "is", "but", "art", "unknown", "to", "thee"};
        nature.addAll( Arrays.asList( natureWords ) );
        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll( Arrays.asList( divineWords) );

        System.out.print("\nNature : ");
        for (String s : nature) System.out.print( s + ", " );
        System.out.print("\nDivine : ");
        for (String s : divine) System.out.print( s + ", ");

        System.out.println("\nNature - Divine : ");
        Set<String> nTakeD = new HashSet <>( nature );
        nTakeD.removeAll( divine );
        for (String s : nTakeD) System.out.println("\t" + s);

        System.out.println("\nDivine - Nature : ");
        Set<String> dTakeN = new HashSet <>( divine );
        dTakeN.removeAll( nature );
        for (String s : dTakeN) System.out.println("\t" + s);

        System.out.println("\nIntersection : ");
        Set<String> intersectionND = new HashSet <>( nature );
        intersectionND.retainAll( divine );
        for (String s : intersectionND) System.out.println("\t" + s);

        System.out.println("\nSymmetric difference : ");
        Set<String> symDifference = new HashSet <>( nature );
        symDifference.addAll( divine );
        symDifference.removeAll(intersectionND);
        for (String s : symDifference) System.out.println("\t" + s);

        System.out.println("\n.containsAll :");

        System.out.println("Divine is " + (nature.containsAll(divine) ? "" : "not ")
                + "a subset of Nature");
        System.out.println("interSectionND is " + (nature.containsAll(intersectionND) ? "" : "not ")
                + "a subset of Nature");
        System.out.println("interSectionND is " + (divine.containsAll(intersectionND) ? "" : "not ")
                + "a subset of Divine");

    }
}
