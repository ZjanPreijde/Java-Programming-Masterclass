package com.masterclass;

public class Main {

    private static final String INVALID_MESSAGE_VALUE = "Invalid Value";
    public static void main(String[] args) {
        int newScore, nrOfTurns;
        String playerName = "Frank";
        nrOfTurns = 5;
        newScore = calculateScore(500);
        printScore(newScore);
        newScore = calculateScore(8, 100);
        printScore(playerName, newScore);
        printScore(playerName, newScore, nrOfTurns);

        doChallenge1();
        doChallenge2();
    }

    public static int calculateScore(int score) {
        return score * 500;
    }
    public static int calculateScore(int scorePerTurn, int nrOfTurns) {
        return (scorePerTurn * nrOfTurns) * 500;
    }
    public static void printScore(int score) {
        System.out.println("Unknown player scored " + score + " points");
    }
    public static void printScore(String playerName, int score) {
        System.out.println("Player " + playerName
                + " scored " + score + " points");
    }
    public static void printScore(String playerName, int score, int turns) {
        System.out.println("Player " + playerName
                + " scored " + score + " points"
                + " in " + turns + " turns");
    }

    public static void doChallenge1() {
        System.out.println("---------");
        System.out.println("Challenge calcFeetAndInchesToCentimeters() :");
        System.out.println("69.5 inches : " + calcFeetAndInchesToCentimeters(69.5));
        System.out.println("5 ft, 9.5 inches : " + calcFeetAndInchesToCentimeters(5, 9.5));
        System.out.println("5.5 ft, 3.5 inches : " + calcFeetAndInchesToCentimeters(5.5 , 3.5));
        System.out.println(" -1 inches : " + calcFeetAndInchesToCentimeters(-1));
        System.out.println("8 ft, 13 inches : " + calcFeetAndInchesToCentimeters(8, 13));
        System.out.println("8 ft, -1 inches : " + calcFeetAndInchesToCentimeters(8, -1));
    }
    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        return (feet >= 0 && (inches >= 0 && inches <= 12))
                ? ( ((feet * 12) + inches) * 2.54 )
                : -1;
    }
    public static double calcFeetAndInchesToCentimeters(double inches) {
        return calcFeetAndInchesToCentimeters( (int) (inches / 12),inches % 12 );
    }

    public static void doChallenge2() {
        System.out.println("---------");
        System.out.println("Challenge getDurationString() :");
        System.out.println(" 10, 10. 0h 10m 10s    : " + getDurationString(10,10));
        System.out.println("100, 10. 1h 40m 10s    : " + getDurationString(100,10));
        System.out.println(" -1, 10. Invalid value : " + getDurationString(-1,10));
        System.out.println("100, 60. Invalid value : " + getDurationString(100,60));
        System.out.println("3665.    1h 1m 5s      : " + getDurationString(3665));
        System.out.println("-1.      Invalid value : " + getDurationString(-1));
    }
    public static String getDurationString(int minutes, int seconds) {
        return (minutes >= 0 && seconds >= 0 && seconds <= 59)
                ?     (minutes / 60 < 10 ? "0": "") + minutes / 60 + "h "
                    + (minutes % 60 < 10 ? "0": "") + minutes % 60 + "m "
                    + (seconds < 10      ? "0": "") + seconds      + "s"
                : INVALID_MESSAGE_VALUE;
    }
    public static String getDurationString(int seconds) {
        return getDurationString(seconds / 60, seconds % 60);
    }

}
