package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-24, 19:44
*/

import java.util.Objects;

public class Dog {
    private final String name;

    public Dog( String name ) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

}
