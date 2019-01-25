package com.masterclass;

public class Main {

    private static void printHeader(String header) {
        System.out.println("==============");
        System.out.println(header);
    }

    public static void main(String[] args) {
        printHeader("testInheritance() : ");
        testInheritance1();

    }
    private static void testInheritance1() {
        Animal newAnimal;
        Dog newDog;
        Fish newFish;

        newAnimal = new Animal("Animal1", 1, 1, 5, 5);
        newAnimal.printData();
        newAnimal = new Animal("Animal2", 2, 2, 10, 10);
        newAnimal.printData();

        newDog = new Dog("Jack", 5, 10, 2, 4, 1, 40 );
        newDog.printData();
        newDog.eat(3);
        newDog.eat(3);
        newDog.eat(4);
        newDog.move(1);
        newDog.walk();
        newDog.run();

        newFish = new Fish("Jill", 2, 10, 2, 2, 4 );
        newFish.printData();
        newFish.swim();
        newFish.rest();
    }
}
