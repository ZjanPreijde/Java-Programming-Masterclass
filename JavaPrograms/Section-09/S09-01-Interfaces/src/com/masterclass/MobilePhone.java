package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-01, 11:43
*/

public class MobilePhone implements ITelephone {
    private int myNumber;
    private boolean isRinging;
    private String phoneType;
    private boolean isOn;

    public MobilePhone( int myNumber ) {
        this.myNumber = myNumber;
        phoneType = "mobile phone";
    }

    @Override
    public void powerOn() {
        System.out.println("Power ON " + phoneType);
        isOn = true;
    }

    @Override
    public void powerOff() {
        System.out.println("Power OFF " + phoneType);
        isOn = false;
    }

    @Override
    public void dial( int phoneNumber ) {
        if ( !isOn ) {
            System.out.println("Please switch on your " + phoneType);
            return;
        }
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
        if ( !isOn ) {
            System.out.println("Phone not ringing, " + phoneType + " switched off");
        } else if ( phoneNumber == myNumber && isOn ) {
            isRinging = true;
            System.out.println("Ringtone ringtone");
        } else {
            System.out.println("Someone being called, not me :-)");
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
