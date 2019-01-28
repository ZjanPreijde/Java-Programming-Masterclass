package com.masterclass;

public class PC {
    private Case theCase; /* 'case' is reserved keyword */
    private Motherboard motherboard;
    private Monitor monitor;
//    public Monitor monitor; /* declaring it public makes it available as myPc.monitor */

    public PC(Case theCase, Motherboard motherboard, Monitor monitor) {
        this.theCase = theCase;
        this.motherboard = motherboard;
        this.monitor = monitor;
    }

    public void powerUp() {
        theCase.pressPowerButton();
        drawLogo();
        loadOS();
    }
    private void drawLogo() {
        // Fancy graphics, either use getMonitor() or monitor
        monitor.drawPixelAt(1500, 100, "red");
        monitor.drawPixelAt(1501, 100, "blue");
    }
    private void loadOS() {
        motherboard.loadProgram("Ubuntu 18.04 LTS");
    }

    // Making the getters private means they are no longer accessible from the composing class
    private Case getTheCase() {
        return theCase;
    }
    private Motherboard getMotherboard() {
        return motherboard;
    }
    private Monitor getMonitor() {
        return monitor;
    }
//    public Case getTheCase() {
//        return theCase;
//    }
//    public Motherboard getMotherboard() {
//        return motherboard;
//    }
//    public Monitor getMonitor() {
//        return monitor;
//    }
}
