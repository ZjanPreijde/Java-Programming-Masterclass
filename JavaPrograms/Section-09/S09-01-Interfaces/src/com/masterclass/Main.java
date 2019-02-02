package com.masterclass;

public class Main {

    public static void main(String[] args) {
        int deskNumber   = 2345677;
        int mobileNumber = 998877665;

        ITelephone myDeskPhone, myMobilePhone;
        myDeskPhone   = new DeskPhone( deskNumber );
        myMobilePhone = new MobilePhone( mobileNumber );

        System.out.println("--------------\nDesk phone :");
        myDeskPhone.powerOn();
        myDeskPhone.powerOff();
        myDeskPhone.callPhone( deskNumber );
        myDeskPhone.dial( deskNumber );
        myDeskPhone.dial( mobileNumber );
        myDeskPhone.answer();

        System.out.println("--------------\nMobile phone :");
        myMobilePhone.dial( mobileNumber );
        myMobilePhone.powerOn();
        myMobilePhone.dial( deskNumber );
        myMobilePhone.dial( mobileNumber );
        myMobilePhone.callPhone( mobileNumber );
        myMobilePhone.answer();
        myMobilePhone.powerOff();
        myMobilePhone.dial( deskNumber );
    }
}
