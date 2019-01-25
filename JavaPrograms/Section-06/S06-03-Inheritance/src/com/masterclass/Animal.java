package com.masterclass;

public class Animal {

    private String name;
    private int brain, body, size, weight;

    public Animal(String name, int brain, int body, int size, int weight) {
        this.name   = name;
        this.brain  = brain;
        this.body   = body;
        this.size   = size;
        this.weight = weight;
    }

    public void eat(int incrWeight) {
        this.weight += incrWeight;
        System.out.println(name + " eats, weight now " + weight);
    }
    public void move(int decrWeight) {
        this.weight -= decrWeight;
        System.out.println(name + " moves, weight now " + weight);
    }
    public String getName() {
        return name;
    }

    public int getBrain() {
        return brain;
    }

    public int getBody() {
        return body;
    }

    public int getSize() {
        return size;
    }

    public int getWeight() {
        return weight;
    }
    public void printData() {
        System.out.println("Animal Name : " + name);
        System.out.println("Brain  : " + brain);
        System.out.println("Body   : " + body);
        System.out.println("Size   : " + size);
        System.out.println("Weight : " + weight);
    }
}
