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
        printHeader("== While-DoWhile ==");

        doExample1();
        doExample2();
        doExample3();
        doExample4();

        doChallenge1();

    }

    private static void doExample1() {
        printHeader("Example 1 :");
        int count;

        System.out.println("while () {}");
        count = 1;
        while (count != 6) {
            System.out.println("Count value = " + count);
            count++;
        }

        System.out.println("while (true) { break; }");
        count = 1;
        do {
            System.out.println("Count value = " + count);
            count++;
        } while (count != 6);

        System.out.println("do {} while ()");
        count = 1;
        while (true) {
            if (count == 6) {
                break;
            }
            System.out.println("Count value = " + count);
            count++;
        }

    }

    private static void doExample2() {
        printHeader("Example 2, mini-challenge isEven() :");
        System.out.println(("2   -> true  :" + isEven(2)));
        System.out.println(("3   -> false :" + isEven(3)));
        System.out.println(("-1  -> false :" + isEven(-1)));
        System.out.println(("-2  -> true  :" + isEven(-2)));
        System.out.println(("0   -> true  :" + isEven(0)));
    }

    private static void doExample3() {
        printHeader("Example 3 :");
        int number = 4, finishNumber = 20, evenFound = 0;
        while (true) {
            if ((number > finishNumber) || (evenFound == 5)) {
                break;
            }

            number++;

            if (!isEven(number)) {
                continue;
            }

            evenFound++;
            System.out.println("Even Number " + number);
        }
        System.out.println("Even Numbers Found " + evenFound);
    }

    private static void doExample4() {
        printHeader("Example 4, challenge sumDigits() :");
        System.out.println("9         -> -1 : " + sumDigits(9));
        System.out.println("-1        -> -1 : " + sumDigits(-1));
        System.out.println("125       ->  8 : " + sumDigits(125));
        System.out.println("12345     -> 15 : " + sumDigits(12345));
        System.out.println("123456789 -> 45 : " + sumDigits(123456789));
        System.out.println("987654321 -> 45 : " + sumDigits(987654321));
        System.out.println("- sumDigits2() :");
        System.out.println("9         -> -1 : " + sumDigits2(9));
        System.out.println("-1        -> -1 : " + sumDigits2(-1));
        System.out.println("125       ->  8 : " + sumDigits2(125));
        System.out.println("12345     -> 15 : " + sumDigits2(12345));
        System.out.println("123456789 -> 45 : " + sumDigits2(123456789));
        System.out.println("987654321 -> 45 : " + sumDigits2(987654321));

    }
    private static int sumDigits(int number) {
        if (number < 10) {
            return -1;
        }
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
    private static int sumDigits2(int number) {
        if (number < 10) {
            return -1;
        }
        int sum = 0;
        do {
            sum += number % 10;
            number /= 10;
        }
        while (number > 0);
        return sum;
    }

    private static void doChallenge1() {

        printHeader("Exercises :");
        printHeader("1. isPalindrome() :");
        NumberPalindrome();

    }
    private static void NumberPalindrome() {
        System.out.println("123454320  -> false : " + isPalindrome(123454320));
        System.out.println("-123454321 ->  true : " + isPalindrome(-123454321));
        System.out.println("-123454320 -> false : " + isPalindrome(-123454320));
        System.out.println("123454321  ->  true : " + isPalindrome(123454321));
    }
    public static boolean isPalindrome(int number) {
        number = number * (number < 0 ? -1 : 1);
        int check = number, reverse = 0;
        while (check > 0) {
            reverse  = (reverse * 10) + check % 10;
            check  /= 10;
        }
        return number == reverse ;
    }
    private static void FirstLastDigitSum() {
    }
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) { return -1; }
        return 0;

    }
}
