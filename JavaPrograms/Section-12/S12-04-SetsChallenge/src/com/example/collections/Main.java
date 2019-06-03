package com.example.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap <>();
    private static Set<Planet> planets = new HashSet<>();


    public static void main(String[] args) {
        Planet tempPlanet;
        Moon tempMoon;

        tempPlanet = new Planet("Mercury", 88);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Venus", 225);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        // Earth plus moon
        tempPlanet = new Planet("Earth", 365);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);
        System.out.println(planets.add(tempPlanet)); // won't work

        tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempPlanet.getKey(), tempMoon);
        tempPlanet.addMoon(tempMoon);
        System.out.println(tempPlanet.addMoon(tempMoon)); // won't work

//        tempMoon = new Moon("Mars", 687);
//        solarSystem.put(tempPlanet.getKey(), tempMoon);
//        tempPlanet.addMoon(tempMoon);


        // Mars plus moons
        tempPlanet = new Planet("Mars", 687);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addMoon(tempMoon); // tempPlanet is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        tempPlanet.addMoon(tempMoon); // tempPlanet is still Mars


        // Jupiter plus moons
        tempPlanet = new Planet("Jupiter", 4332);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempPlanet.getKey(), tempMoon);
        tempPlanet.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempPlanet.getKey(), tempMoon);
        tempPlanet.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempPlanet.getKey(), tempMoon);
        tempPlanet.addMoon(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempPlanet.getKey(), tempMoon);
        tempPlanet.addMoon(tempMoon); // temp is still Jupiter


        tempPlanet = new Planet("Saturn", 10759);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Uranus", 30660);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Neptune", 165);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        tempPlanet = new Planet("Pluto", 248);
        solarSystem.put(tempPlanet.getKey(), tempPlanet);
        planets.add(tempPlanet);


        System.out.println("==================");
        System.out.println("\"Pluto\".hashCode() : " + "Pluto".hashCode());
        System.out.println("temp.hashCode() : " + tempPlanet.hashCode());
        System.out.println("==================");

        System.out.println("Planets");
        for(Planet planet : planets) {
            System.out.println("\t" + planet.getKey().getName());
        }

        HeavenlyBody.Key tempKey = HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET);
        HeavenlyBody body = solarSystem.get( tempKey ) ;

        System.out.println("Moons of " + body.getKey());
        for(HeavenlyBody jupiterMoon: body.getSatellites()) {
            System.out.println("\t" + jupiterMoon.getKey());
        }

        Set<HeavenlyBody> moons = new HashSet<>();
        for(Planet planet : planets) {
            moons.addAll(planet.getSatellites());
        }
        System.out.println("All Moons : ");
        for(HeavenlyBody moon : moons) {
            System.out.println("\t" + moon.getKey());
        }

        System.out.println("All Planets :");
        planets.forEach( p -> {
            System.out.println( p );
            Set<HeavenlyBody> moons2 = p.getSatellites();
            if (moons2.size() == 0) {
                System.out.println(" - it has no moons");
            } else {
                moons2.forEach( m -> {
                    System.out.println(" - " + m);
                } );
            }
        });

        // a.equals(b) == b.equals(a)
        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals( earth2 ));
        System.out.println(earth2.equals( earth1 ));


    }

    public static void main0() {
        Set <String > mySet = new HashSet <>();
        System.out.println(mySet.add("A"));
        System.out.println(mySet.add("B"));
        System.out.println(mySet.add("A"));
        System.out.println(mySet.remove("C"));
        System.out.println(mySet.remove("B"));
        mySet.forEach( e -> System.out.println(e));
        mySet.size();

        Object o = new Object();
        o.equals( o );
        "X".equals("");

    }
}
