package com.masterclass;

public class Main {

    private static void printHeader(String header) {
        System.out.println("----------");
        System.out.println(header);
    }

    private static boolean isEven(int number) {
        return (number % 2 == 0);
    }

    public static void main(String[] args) {
        printHeader("== Exercises ==");
        doExercises();
    }

    private static void doExercises() {
        // Try to fill a package fully with a given nr of big and small bags.
         FlourPacker();
         // Calculate the largest prime of a given number
         LargestPrime();
         DiagonalStar();
    }

    private static void FlourPacker() {
        printHeader("1. TDD canPack() :");
        System.out.println("1, 0, 4   -> false : " + canPack(1,0,4));
        System.out.println("1, 0, 5   ->  true : " + canPack(1,0,5));
        System.out.println("0, 5, 4   ->  true : " + canPack(0,5,4));
        System.out.println("2, 2, 12  ->  true : " + canPack(2,2,12));
        System.out.println("2, 2, 11  ->  true : " + canPack(2,2,11));
        System.out.println("2, 7, 18  -> false : " + canPack(2,7,18));
        System.out.println("-3, 2, 12 -> false : " + canPack(-3,2,12));

    }
    public static boolean canPack(int bigCount, int smallCount, int goal) {
        boolean result = (bigCount >= 0 && smallCount >= 0 && goal >= 0);
        if (result) {
            int nrOfBigBags = (goal / 5), nrOfSmallBags = 0;
            nrOfBigBags = (nrOfBigBags > bigCount) ? bigCount : nrOfBigBags;
            goal       -= (nrOfBigBags * 5);

            nrOfSmallBags = (smallCount > goal) ? goal : smallCount;
            goal         -= nrOfSmallBags;

            result = ( goal == 0 );
            }
        return result;
    }

    private static void LargestPrime() {
        printHeader("2. TDD getLargestPrime() :");
        System.out.println("21  ->  7 : " + getLargestPrime(21));
        System.out.println("271 -> 31 : " + getLargestPrime(217));
        System.out.println("0   -> -1 : " + getLargestPrime(0));
        System.out.println("45  ->  5 : " + getLargestPrime(45));
        System.out.println("-1  -> -1 : " + getLargestPrime(-1));

    }
    public static int getLargestPrime(int number) {
        int result = (number < 2) ? -1 : 2;
        if (result > 0) {
            for (result = 2; result <= number; result++) {
                if (number % result == 0) {
                    number /= result;
                    result--;
                }
            }
        }
        return result;
    }

    private static void DiagonalStar() {
        printHeader("3. TDD printSquareStar() :");
        System.out.println(" 4 -> Invalid Value");
        printSquareStar(4);
        System.out.println(" 5 -> ");
        printSquareStar(5);
        System.out.println(" 8 -> ");
        printSquareStar(8);
        System.out.println(" 9 -> ");
        printSquareStar(9);
        System.out.println(" 20 -> ");
        printSquareStar(20);

    }
    public static void printSquareStar(int number) {
        if ( number < 5 ) {
            System.out.println("Invalid Value");
            return ;
        }
        String fullRow;
        for (int row = 1; row <= number; row ++) {
            fullRow = "";
            for (int col = 1; col <= number; col++) {
                fullRow += (row == 1 || col == 1 || col == row ||
                        number == row || number == col || number == ( col + row - 1 ) )
                    ? "*" : " ";
            }
            System.out.println(fullRow);
        }
    }

}
