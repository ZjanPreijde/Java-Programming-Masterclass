package com.masterclass;

public class Player2 {
    // renaming health to hitpoints does not affect the code using this class thanks to encapsulation
    private String name, weapon;
//    private int health = 100;
    private int hitpoints = 100;

    public Player2(String name, String weapon, int hitpoints) {
        this.name = name;
        this.weapon = weapon;
        if ( hitpoints > 0 && hitpoints <= this.hitpoints) {
            this.hitpoints = hitpoints;
        }
    }

    public int getHealth() {
        return hitpoints;
    }

    public void loseHealth(int damage) {
        this.hitpoints -= damage;
        if ( this.hitpoints <= 0 ) {
            System.out.println("Player knocked out");
            // Reduce number of livess remaining for the player
        }
    }

}
