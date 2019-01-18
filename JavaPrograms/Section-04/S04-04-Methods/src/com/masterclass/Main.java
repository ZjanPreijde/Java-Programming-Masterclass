package com.masterclass;

public class Main {

    public static void main(String[] args) {
        boolean gameOver;
        int score, levelCompleted, bonus, finalScore;

        bonus      = 100;

        score      = 4000;
        levelCompleted = 5;
        gameOver   = checkGameOver(score);
        finalScore = addBonus(gameOver, score, levelCompleted, bonus);
        printScore(gameOver, score, levelCompleted, bonus, finalScore) ;

        score     += 2000;
        levelCompleted += 1;
        gameOver   = checkGameOver(score);
        finalScore = addBonus(gameOver, score, levelCompleted, bonus);
        printScore(gameOver, score, levelCompleted, bonus, finalScore) ;

        score     += 2000;
        levelCompleted += 1;
        gameOver   = checkGameOver(score);
        finalScore = addBonus(gameOver, score, levelCompleted, bonus);
        printScore(gameOver, score, levelCompleted, bonus, finalScore) ;

        score     += 2000;
        levelCompleted += 1;
        gameOver   = checkGameOver(score);
        finalScore = addBonus(gameOver, score, levelCompleted, bonus);
        printScore(gameOver, score, levelCompleted, bonus, finalScore) ;

        // challenge
        doChallenge();

    } // main()
    public static void doChallenge() {
        // Create a method called displayHighScorePosition
        // it should a players name as a parameter, and a 2nd parameter as a position in the high score table
        // You should display the players name along with a message like " managed to get into position " and the
        // position they got and a further message " on the high score table".
        //
        // Create a 2nd method called calculateHighScorePosition
        // it should be sent one argument only, the player score
        // it should return an in
        // the return data should be
        // 1 if the score is >=1000
        // 2 if the score is >=500 and < 1000
        // 3 if the score is >=100 and < 500
        // 4 in all other cases
        // call both methods and display the results of the following
        // a score of 1500, 900, 400 and 50
        System.out.println("----------");
        System.out.println("Challenge :");
        displayHighScorePosition("Elisa", calculateHighScorePosition(1500));
        displayHighScorePosition("Frank", calculateHighScorePosition( 900));
        displayHighScorePosition("TonyS", calculateHighScorePosition( 400));
        displayHighScorePosition("Daisy", calculateHighScorePosition(  50));
        System.out.println("----------");
    } // doChallenge()
    private static void displayHighScorePosition(String name, int position) {
        System.out.println("- " + name
           + " managed to get into position " + position
           + " on the high score table");
    }
    private static int calculateHighScorePosition(int score) {
        return score > 1000 ? 1 : score > 500 ? 2 : score > 100 ? 3 : 4;
    }

    private static boolean checkGameOver(int score){
        return score >= 10000;
    } // checkGameOver()
    private static int addBonus(
            boolean gameOver, int score, int levelCompleted, int bonus) {
        return score + (gameOver ? (levelCompleted * bonus) + 1000 : 0);
    } // addBonus()
    private static void printScore(
            boolean gameOver, int score, int levelCompleted, int bonus, int finalScore) {
        if (score < 5000 && score > 1000) {
            System.out.println("Score < 5000 but > 1000 : " + score);
        } else if (score < 1000) {
            System.out.println("Score < 1000 : " + score);
        } else {
            System.out.println(("Score >= 5000 : " + score));
        }

        if (gameOver) {
            System.out.println("Your final score is " + finalScore);
        } else {
            System.out.println("Your current score is " + score);
        }
    } // printScore()

}
