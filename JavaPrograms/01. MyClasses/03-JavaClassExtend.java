package com.masterclass;
/*
    Another great class by Zjan Preijde
*/

import java.util.*;

// public class JavaClass extends SuperClass {
// public class JavaClass implements IJavaInterface {
class JavaClass {
    private boolean newClass;

    /*     Constructor     */
    public JavaClass() {
        this.newClass = true;
    }

    /*     Setters     */
    public void boolean setNewClass( boolean value ) {
        this.newJavaClass = value;
    }

    /*     Getters     */
    public boolean getNewClass( ) {
        return this.newJavaClass;
    }

    /*     Overrides when extending            */
    /*     In fact each class is extending     */
    @Override
    public String toString() {
       return newClass ? "Yes!" : "Nooooooo!"
    }
}
