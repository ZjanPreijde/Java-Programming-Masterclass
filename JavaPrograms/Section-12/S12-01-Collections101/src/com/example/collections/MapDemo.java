package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-23, 14:35
*/

import java.util.HashMap;
import java.util.Map;

public class MapDemo {

    public static void main( String[] args ) {
        Map <String, String> languages = new HashMap <>();
        languages.put( "Java", "blabla about Java" );
        languages.put( "PHP", "blabla about PHP" );
        languages.put( ".Net", "blabla about .Net" );
        // key exists, value gets overwritten
        System.out.println(languages.put( "Java", "blowblow about Java" ));
        System.out.println(languages.put( "FoxPro", "blabla about FoxPro" ));
//        System.out.println(languages);
        languages.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        } );
        if (languages.containsKey( "FoxPro" )) {
            System.out.println("FoxPro is a key in the map");
        }
//        System.out.println(languages.putIfAbsent( "Visual FoxPro" , "A database management language"));
        System.out.println(languages.put( "Visual FoxPro" , "A database management language"));
        System.out.println("----------------");
        for (String key: languages.keySet()) {
            System.out.println(key + " : " + languages.get( key ));
        }
        System.out.println("----------------");
        languages.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        } );
        System.out.println("----------------");
        System.out.println(languages.remove( ".Net", "blabla about .Net" ));
        System.out.println(languages.remove( ".Net" ));

        System.out.println(languages.put( ".Net", "TODO" ));

        System.out.println(languages.replace( ".Net", "blabla about .Net" ));
        System.out.println(languages.replace( ".Net", "blabla about .Net", "blowblow about .Net" ));


    }
}
