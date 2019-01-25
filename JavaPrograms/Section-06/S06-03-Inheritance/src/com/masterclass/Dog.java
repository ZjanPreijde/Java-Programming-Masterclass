package com.masterclass;

public class Dog extends Animal {
    private int eyes, legs, tail, teeth;
    private String coat;
    public Dog(String name, int size, int weight
            , int eyes, int legs, int tail, int teeth) {
        super(name, 1, 1, size, weight);
        this.eyes  = eyes;
        this.legs  = legs;
        this.tail  = tail;
        this.teeth = teeth;
    }

    public void walk() {
        System.out.println(getName() + " walks");
        move(1);
    }
    public void run() {
        System.out.println(getName() + " runs");
        move(2);
    }

    @Override
    public void eat(int foodWeight) {
        System.out.println(getName() + " eats " + foodWeight);
        chew();
        super.eat(foodWeight);
    }
    private void chew() {
        System.out.println(getName() + " chews");
    }

    @Override
    public void move(int decrWeight) {
        moveLegs();
        super.move(decrWeight);
    }
    private void moveLegs() {
        System.out.println(getName() + " moves its legs");
    }

    @Override
    public String getName() {
        return "Dog " + super.getName();
    }
    public void printData() {
        super.printData();
        System.out.println(getName() + " ->");
        System.out.println("Eyes   : " + this.eyes);
        System.out.println("Legs   : " + this.legs);
        System.out.println("Tail   : " + this.tail);
        System.out.println("Teeth  : " + this.teeth);
    }

}
