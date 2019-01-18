package com.masterclass;

public class Main {

    public static void main(String[] args) {
        boolean gameOver;
        int score, levelCompleted, bonus;
        gameOver = true;

        score = 4000;
        levelCompleted = 5;
        bonus = 100;
        printScore(gameOver, score, levelCompleted, bonus) ;

        // Challenge, print out a second score ont the screen with the following
        // score set to 10000, levelCompleted set to 8, bonus set to 200
        score = 10000;
        levelCompleted = 8;
        bonus = 200;
        printScore(gameOver, score, levelCompleted, bonus) ;
    }

    // My first Java method :-)
    public static void printScore(
            boolean gameOver, int score, int levelCompleted, int bonus) {
        if (score < 5000 && score > 1000) {
            System.out.println("Score < 5000 but > 1000 : " + score);
        } else if (score < 1000) {
            System.out.println("Score < 1000 : " + score);
        } else {
            System.out.println(("Score >= 5000 : " + score));
        }

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score is " + finalScore);
        }
    }
}
