package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-01, 10:38
*/

public class DeskPhone implements Telephone {
    private int myNumber;
    private String phoneType;
    private boolean isRinging;

    public DeskPhone( int myNumber ) {
        this.myNumber  = myNumber;
        this.phoneType = "desk phone";
    }

    @Override
    public void powerOn() {
        noPowerButton();
    }

    @Override
    public void powerOff() {
        noPowerButton();
    }

    private void noPowerButton() {
        System.out.println("No action taken, " + phoneType + " does not have a power button ");
    }

    @Override
    public void dial( int phoneNumber ) {
        if ( phoneNumber == myNumber ) {
            System.out.println( "Stop calling yourself!" );
            return;
        }
        System.out.println( "Now ringing " + phoneNumber + " on " + phoneType );
    }

    @Override
    public void answer() {
        if (isRinging) {
            System.out.println("Answering the " + phoneType);
            isRinging = false;
        }
    }

    @Override
    public String getNumber( String person ) {
        return null;
    }

    @Override
    public boolean callPhone( int phoneNumber ) {
        if ( phoneNumber == myNumber ) {
            isRinging = true;
            System.out.println("Ring ring");
        } else {
            isRinging = false;
            System.out.println("Someone being called, not me :-)");
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
