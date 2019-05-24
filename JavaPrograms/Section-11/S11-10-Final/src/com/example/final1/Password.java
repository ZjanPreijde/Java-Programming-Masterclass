package com.example.final1;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-21, 12:32
*/

public class Password {
    private static final int key = 235657345;
    private final int encryptedPassword;

    public Password( int password ) {
        this.encryptedPassword = encryptDecrypt(password);
    }
    private int encryptDecrypt(int password) {
        return password ^ key;
    }
    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }
    public boolean letMeIn( int password ) {
        return encryptDecrypt( password ) == this.encryptedPassword;
    }
}
