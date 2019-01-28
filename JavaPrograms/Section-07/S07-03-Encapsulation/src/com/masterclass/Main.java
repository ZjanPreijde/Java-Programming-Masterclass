package com.masterclass;

public class Main {

    public static void main(String[] args) {

        player();
        player2();
    }

    private static void player2() {
        System.out.println("Encapsulated player");
        Player2 player = new Player2("Frank", "Sword", 200); // health to high
        System.out.println("Health remaining : " + player.getHealth()); // 100 is maximum.

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Health remaining : " + player.getHealth());

        damage = 10;
        player.loseHealth(damage);
        System.out.println("Health remaining : " + player.getHealth());

    }

    private static void player() {
        // As fields are declared public, they can be directly accessed
        System.out.println("Non-encapsulated player");
        Player player = new Player();
        player.name   = "Frank";
        player.health = 20;
        player.weapon = "Sword";

        int damage = 10;
        player.loseHealth(damage);
        System.out.println("Health remaining : " + player.healthRemaining());

        damage = 10;
        player.loseHealth(damage);
        System.out.println("Health remaining : " + player.healthRemaining());

    }
}
