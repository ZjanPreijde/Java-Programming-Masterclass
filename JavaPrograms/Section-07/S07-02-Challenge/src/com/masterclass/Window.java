package com.masterclass;

public class Window extends Access {
    private int dirtLevel;

    public Window(int dirtLevel) {
        this.dirtLevel = dirtLevel;
    }

    public Window(int dirtLevel, boolean open) {
        super(open);
        this.dirtLevel = dirtLevel;
    }
    public int getDirtLevel() {
        return dirtLevel;
    }

    public void clean() {
        if (super.isOpen()) {
            System.out.print("Window is open, unable to clean ");
        } else {
            setDirtLevel(0);
            printWindowData();
        }
    }
    public void dirty() {
        setDirtLevel(getDirtLevel() + 1);
        printWindowData();
    }
    public String getWindowData() {
        return super.getAccessData() + " and "
                + ( getDirtLevel() == 0 ? "clean" : "dirty, level " + getDirtLevel() );
    }

    private void printWindowData() {
        System.out.print("Window is " + getWindowData() + " ");
    }
    private void setDirtLevel(int dirtLevel) {
        this.dirtLevel = dirtLevel;
    }
}
