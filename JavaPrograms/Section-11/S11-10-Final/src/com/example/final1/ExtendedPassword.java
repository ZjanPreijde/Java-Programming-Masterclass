package com.example.final1;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-21, 13:06
*/

public class ExtendedPassword extends Password {
    private int decryptedPassword;

    public ExtendedPassword( int password ) {
        super( password );
        this.decryptedPassword = password;
    }

//    @Override
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
