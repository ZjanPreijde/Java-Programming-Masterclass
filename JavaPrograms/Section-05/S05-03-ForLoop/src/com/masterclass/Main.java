package com.masterclass;

public class Main {

    private static void printHeader(String header) {
        System.out.println("---------");
        System.out.println(header);
    }

    private static double calculateInterest(double amount, double interest) {
        return amount * (interest / 100);
    }
    // Given code
    private static boolean isPrime(int number) {
        if ( number == 1) { return false; }
        for (int i = 2; i <= (long) Math.sqrt(number); i++) {
            if (number % i == 0) { return false; }
        }
        return true;
    }
    // My code
    private static boolean myIsPrime(int number) {
        boolean isPrime = ( number > 1 );
        for ( int i = 2; isPrime && (i <= (long) Math.sqrt(number)); i++ ) {
            if ( number % i == 0 ) { isPrime = false; }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        printHeader("== For Loop ==");
        doExample1();
        doExample2();
        doExample3();
        doExample4();
        doExample5();

        doChallenge1();
    }

    private static void doExample1() {
        printHeader("Example 1 :");
        System.out.println("10,000, 2%. Interest 200.0 : "
                + calculateInterest(10_000d, 2d));
        System.out.println("10,000, 3%. Interest 300.0 : "
                + calculateInterest(10_000d, 3d));
        System.out.println("10,000, 4%. Interest 400.0 : "
                + calculateInterest(10_000d, 4d));
        System.out.println("10,000, 5%. Interest 500.0 : "
                + calculateInterest(10_000d, 5d));

    }
    private static void doExample2() {
        printHeader("Example 2 :");
        for (int i = 0; i < 10; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println("Loop " + i + " hello!");
            if (i == 6) {
                break;
            }

        }

    }

    private static void doExample3() {
        printHeader("Example 3, mini-challenge 1 :");
        double amount = 10_000d;
        for (double interest = 2d; interest <= 8d; interest++) {
            System.out.println("\u20AC "
                    + String.format("%.0f", amount) + " "
                    + String.format("@ %.3f", interest) + "%. Interest : \u20AC "
                    + String.format("%.2f", calculateInterest(10_000d, interest)));

        }
        printHeader("Example 3, mini-challenge 2 :");
        for (double interest = 8d; interest >= 2d; interest--) {
            System.out.println("\u20AC "
                    + String.format("%.0f", amount) + " "
                    + String.format("@ %.3f", interest) + "%. Interest : \u20AC "
                    + String.format("%.2f", calculateInterest(10_000d, interest)));

        }
    }

    private static void doExample4() {
        printHeader("Example 4, challenge checkForPrimes() :");
        checkForPrimes(0, 100,8);
        checkForPrimes(10000, 20000,10);
        checkForPrimes(1000, 1100,20);
    }
    private static void checkForPrimes(int start, int end, int findCount) {
        System.out.println("**********");
        System.out.println("Looking for " + findCount + " primes in range "
                + start + " - " + end);
        int primeCount = 0;
        for (int check = start; primeCount < findCount && check < end; check++) {
            if (myIsPrime(check)) {
                System.out.println(check + " is a prime");
                primeCount++;
            }
        }
        System.out.println(primeCount + " primes found");
    }

    private static void doExample5() {
        printHeader("Example 5, challenge Sum 3 and 5 :");
        int nrsFound = 0, nrsSummed = 0;
        for (int i = 1; i <= 1000; i++) {
            if ((i % 5 == 0) && (i % 3 == 0)) {
                System.out.println("Number : " + i);
                nrsFound += 1;
                nrsSummed += i;
                if (nrsFound == 5) {
                    break;
                }
            }
        }
        System.out.println("Total : found " + nrsFound + ", sum " + nrsSummed);
    }

    private static void doChallenge1() {
        printHeader("1. SumOddRange() :");
        System.out.println("1, 100    ->   2500 : " + sumOdd(1, 100));
        System.out.println("-1, 100   ->     -1 : " + sumOdd(-1, 100));
        System.out.println("100, 100  ->      0 : " + sumOdd(100, 100));
        System.out.println("100, -100 ->     -1 : " + sumOdd(100, -100));
        System.out.println("100, 1000 -> 247500 : " + sumOdd(100, 1000));
    }
    public static int sumOdd(int start, int end) {
        int sum = -1;
        if (start > 0 && end > 0 && end >= start) {
            sum = 0;
            start = isOdd(start) ? start : start + 1;
            for (int i = start; i <= end; i+=2) {
                sum += i;
            }
        }
        return sum;
    }
    public static boolean isOdd(int number) {
        return ( number > 0 && ((number + 1) % 2 == 0) );
    }

}
