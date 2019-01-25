package com.masterclass;


public class Main {
    public static void main(String[] args) {
        // Challenge.
        // Start with a base class of a Vehicle, then create a Car class that inherits from this base class.
        // Finally, create another class, a specific type of Car that inherits from the Car class.
        // You should be able to hand steering, changing gears, and moving (speed in other words).
        // You will want to decide where to put the appropriate state and behaviours (fields and methods).
        // As mentioned above, changing gears, increasing/decreasing speed should be included.
        // For you specific type of vehicle you will want to add something specific for that type of car.
        if (true) {
            F1Car max = new F1Car("Max Verstappen");
            max.printData();
            for (int i=1;i<12;i++) {
                max.gearUp();
                max.printData();
            }
            max.steerLeft();
            for (int i =1;i<12;i++) {
                max.gearDown();
                max.printData();
            }
        } else {
            Car car = new Car();
            car.printData();
            car.gearUp();
            car.printData();
            car.steerLeft();
            car.printData();
            for (int i = 1; i < 3; i++) {
                car.gearUp();
                car.printData();
            }
            car.steerRight();
            car.printData();
            car.steerRight();
            car.printData();
            for (int i = 1; i < 4; i++) {
                car.gearDown();
                car.printData();
            }
        }
    }
}
