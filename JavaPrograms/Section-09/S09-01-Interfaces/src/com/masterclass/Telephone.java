package com.masterclass;

public interface Telephone {
    // Access modifiers useless, happens in class implementing interface.

    void powerOn();
    void powerOff();
    void dial(int phoneNUmber);
    void answer();
    String getNumber(String person);
    boolean callPhone(int phoneNumber);
    boolean isRinging();

}
