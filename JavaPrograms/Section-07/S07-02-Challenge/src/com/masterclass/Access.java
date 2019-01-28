package com.masterclass;

public class Access {
    private boolean open;

    public Access() {
        this(false);
    }
    public Access(boolean open) {
        this.open = open;
    }

    public String getAccessData() {
        return open ? "open" : "closed";
    }

    public void open() {
        System.out.print("Access opened ");
        open = true;
    }
    public void close() {
        System.out.print("Access closed ");
        open = false;
    }

    public boolean isOpen() {
        return open;
    }
}
