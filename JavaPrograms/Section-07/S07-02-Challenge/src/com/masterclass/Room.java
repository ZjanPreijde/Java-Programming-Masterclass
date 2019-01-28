package com.masterclass;

public class Room {
    private Dimensions dimensions;
    private Door door1, door2;
    private Window window1, window2;

    public Room(Dimensions dimensions, Door door1, Door door2, Window window1, Window window2) {
        this.dimensions = dimensions;
        this.door1 = door1;
        this.door2 = door2;
        this.window1 = window1;
        this.window2 = window2;
    }

    public void lockUp() {
        if ( door1.isOpen() ) door1.close();
        door1.lock();
        if ( door2.isOpen() ) door2.close();
        door2.lock();
        window1.close();
        window2.close();
    }

    public String getRoomData() {
        return "Room data :"
                + "\nDimensions : " + dimensions.getDimensionsData()
                + "\nDoor 1     : " + door1.getDoorData()
                + "\nDoor 2     : " + door2.getDoorData()
                + "\nWindow 1   : " + window1.getWindowData()
                + "\nWindow 2   : " + window2.getWindowData() ;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public Door getDoor1() {
        return door1;
    }

    public Door getDoor2() {
        return door2;
    }

    public Window getWindow1() {
        return window1;
    }

    public Window getWindow2() {
        return window2;
    }
}
