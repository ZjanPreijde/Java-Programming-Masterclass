package com.masterclass;

public class Main {

    public static void main(String[] args) {
        // Create a single room of a house using composition.
        // Think about the things that should be included in the room.
        // Maybe physical parts of the house but furniture as well
        // Add at least one method to access an object via a getter and
        // then that objects public method as you saw in the previous video
        // then add at least one method to hide the object e.g. not using a getter
        // but to access the object used in composition within the main class
        // like you saw in this video.

        Room myRoom = new Room(
                new Dimensions(600, 500, 200, "cm"),
                new Door(true, false),
                new Door(false, true),
                new Window(5,false),
                new Window(8, true)
        );
        System.out.print("\n ----- ");
        System.out.println("\n" + myRoom.getRoomData());

        System.out.print(" ----- ");
        System.out.print("\nLock    door 1 -> ");
        myRoom.getDoor1().lock();
        System.out.print("\nClose   door 1 -> ");
        myRoom.getDoor1().close();
        System.out.print("\nLock    door 1 -> ");
        myRoom.getDoor1().lock();
        System.out.print("\nOpen    door 1 -> ");
        myRoom.getDoor1().open();
        System.out.print("\nUnlock  door 1 -> ");
        myRoom.getDoor1().unlock();
        System.out.print("\nOpen    door 1 -> ");
        myRoom.getDoor1().open();

        System.out.print("\n ----- ");
        System.out.print("\nUnlock  door 2 -> ");
        myRoom.getDoor2().unlock();
        System.out.print("\nOpen    door 2 -> ");
        myRoom.getDoor2().open();

        System.out.print("\n ----- ");
        System.out.print("\nDirty window 1 -> ");
        myRoom.getWindow1().dirty();
        System.out.print("\nClean window 2 -> ");
        myRoom.getWindow2().clean();
        System.out.print("\nClose window 2 -> ");
        myRoom.getWindow2().close();
        System.out.print("\nClean window 2 -> ");
        myRoom.getWindow2().clean();

        System.out.print("\n ----- ");
        System.out.println("\n" + myRoom.getRoomData());

        System.out.print(" ----- ");
        System.out.print("\nTotal lock up  -> ");
        myRoom.lockUp();

        System.out.print("\n ----- ");
        System.out.println("\n" + myRoom.getRoomData());
    }
}
