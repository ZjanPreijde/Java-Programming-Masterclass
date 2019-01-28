package com.masterclass;

public class Door extends Access {
    private boolean locked;

    public Door(boolean open, boolean locked) {
        super(open);
        this.locked = super.isOpen() ? false : locked;
    }

    @Override
    public void open() {
        if (locked) {
            System.out.print("Door is locked, unable to open ");
        } else {
            super.open();
            printDoorData();
        }
    }

    public void lock() {
        if ( super.isOpen() ) {
            System.out.print("Door is open, unable to lock ");
        } else {
            locked = true;
            printDoorData();
        }
    }
    public void unlock() {
        locked = false;
        printDoorData();
    }

    public String getDoorData() {
        return super.getAccessData()
                + " and " + (isLocked() ? "" : "un") + "locked";
    }
    private void printDoorData() {
        System.out.print("Door is " + getDoorData() + " ");
    }
    private boolean isLocked() {
        return locked;
    }
}
