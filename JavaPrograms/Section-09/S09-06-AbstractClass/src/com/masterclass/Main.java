package com.masterclass;

public class Main {

    public static void main(String[] args) {
	    Dog dog = new Dog("Jimmy");
	    dog.eat();
	    dog.breathe();

	    Parrot bird = new Parrot("Pino");
	    bird.eat();
	    bird.breathe();
	    bird.fly();

	    Pinguin pinguin = new Pinguin( "Emperor" );
	    pinguin.fly();
    }
}
