package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-24, 19:49
*/

public class Labrador extends Dog {
    public Labrador( String name ) {
        super( name );
    }

    // equals() is final in Dog.

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj instanceof Labrador) {
//            String objName = ((Labrador) obj).getName();
//            return this.getName().equals(objName);
//        }
//        return false;
//    }


}
