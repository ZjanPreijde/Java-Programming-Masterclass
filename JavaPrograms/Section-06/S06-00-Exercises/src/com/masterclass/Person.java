package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 16:05
*/

public class Person {
    private String lastName, firstName;
    private int age;

    public String getLastName() {
        return lastName;
    }

    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge( int age ) {
        if (age < 0 || age > 100) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }
    public boolean isTeen() {
        return (age > 12 && age < 20);
    }
    public String getFullName() {
        if (firstName.isEmpty() && lastName.isEmpty()) {
            return "";
        } else if (firstName.isEmpty()) {
            return lastName;
        } else if (lastName.isEmpty()) {
            return firstName;
        } else {
            return firstName + " " + lastName;
        }
    }
}
