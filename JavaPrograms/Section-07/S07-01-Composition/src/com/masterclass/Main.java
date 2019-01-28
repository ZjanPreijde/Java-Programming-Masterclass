package com.masterclass;

public class Main {

    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(200, 200, 50);
	    Case theCase = new Case("220B", "Dell", "240", dimensions);
	    Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27
                , new Resolution(2540, 1440));
	    Motherboard theMotherboard = new Motherboard("BJ-200", "Asus", "v2.44"
                , 4, 6);

	    PC thePC = new PC(theCase, theMotherboard, theMonitor);
//	    thePC.getMonitor().drawPixelAt(1500, 1200, "red");
//	    thePC.monitor.drawPixelAt(100, 100, "blue");
//	    thePC.getMotherboard().loadProgram("Ubuntu 18.04 LTS");
//	    thePC.getTheCase().pressPowerButton();
		thePC.powerUp();
    }
}
