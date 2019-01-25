package com.masterclass;

public class Fish extends Animal {
    private int eyes, gills, fins;

    public Fish(String name, int size, int weight, int eyes, int gills, int fins) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.gills = gills;
        this.fins = fins;
    }
    public void rest() {
        System.out.println(getName() + " rests");
    }
    public void swim() {
        System.out.println(getName() + " swims");
        moveMuscles();
        moveBackFin();
        move(1);
    }
    private void moveMuscles() {
        System.out.println(getName() + " moves muscles");
    }
    private void moveBackFin() {
        System.out.println(getName() + " moves backfin");
    }

    @Override
    public String getName() {
        return "Fish " + super.getName();
    }
    @Override
    public void printData() {
        super.printData();
        System.out.println(getName() + " ->");
        System.out.println("Eyes  : " + this.eyes);
        System.out.println("Gills : " + this.gills);
        System.out.println("Fins  : " + this.fins);
    }
}
