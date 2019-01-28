package com.masterclass;

public class Player {
    public String name, weapon;
    public int health;

    public void loseHealth(int damage) {
        this.health -= damage;
        if ( this.health <= 0 ) {
            System.out.println("Player knocked out");
            // Reduce number of livess remaining for the player
        }
    }
    public int healthRemaining() {
        return this.health;
    }
}
