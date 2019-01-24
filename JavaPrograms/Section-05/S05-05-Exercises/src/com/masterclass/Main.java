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
        NumberPalindrome();
        FirstLastDigitSum();
        EvenDigitSum();
        SharedDigit();
        LastDigitChecker();
        GreatestCommonDivisor();
        FactorPrinter();
        PerfectNumber();
        NumberToWords();
    }

    private static void NumberPalindrome() {
        printHeader("1. isPalindrome() :");
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
        printHeader("2. sumFirstAndLastDigit() :");
        System.out.println("252  ->  4 : " + sumFirstAndLastDigit(252));
        System.out.println("257  ->  9 : " + sumFirstAndLastDigit(257));
        System.out.println("0    ->  0 : " + sumFirstAndLastDigit(0));
        System.out.println("5    -> 10 : " + sumFirstAndLastDigit(5));
        System.out.println("-10  -> -1 : " + sumFirstAndLastDigit(-10));
    }
    public static int sumFirstAndLastDigit(int number) {
        if (number < 0) { return -1; }
        int firstDigit = number % 10, lastDigit = firstDigit;
        while (number > 0) {
            firstDigit = number % 10;
            number /= 10;
        }
        return firstDigit + lastDigit ;
    }

    private static void EvenDigitSum() {
        printHeader("2. getEvenDigitSum() :");
        System.out.println("123456789 -> 20 : " + getEvenDigitSum(1234567890));
        System.out.println("252       ->  4 : " + getEvenDigitSum(252));
        System.out.println("-22       -> -1 : " + getEvenDigitSum(-22));

    }
    public static int getEvenDigitSum(int number) {
        if (number < 0) { return -1; }
        int sum = 0, digit;
        while (number > 0) {
            digit   = number % 10;
            number /= 10;
            sum    += (digit % 2 == 0) ? digit : 0;
        }
        return sum;
    }

    private static void SharedDigit() {
        printHeader("3. hasSharedDigit() :");
        System.out.println("12, 23 ->  true : " + hasSharedDigit(12, 23));
        System.out.println("9, 99  -> false : " + hasSharedDigit(9, 99));
        System.out.println("15,55  ->  true : " + hasSharedDigit(15, 55));
    }
    public static boolean hasSharedDigit(int number1, int number2) {
        boolean sharedFound = false ;
        if ( number1 > 9 && number1 < 100 && number2 > 9 && number2 < 100 ) {
            int digit1, digit2, check2;
            while ((number1 > 0) && !sharedFound) {
                digit1   = number1 % 10;
                number1 /= 10;
                check2   = number2;
                while ((check2 > 0) && !sharedFound) {
                    digit2  = check2 % 10;
                    check2 /= 10;
                    sharedFound = (digit1 == digit2);
                }
            }
        }
        return sharedFound;
    }

    private static void LastDigitChecker() {
        printHeader("4. hasSameLastDigit() :");
        System.out.println("41, 22, 71 ->  true : " + hasSameLastDigit(41, 22, 71));
        System.out.println("23, 32, 42 ->  true : " + hasSameLastDigit(23, 32, 42));
        System.out.println("9, 99, 999 -> false : " + hasSameLastDigit(9, 99, 999));
    }
    public static boolean hasSameLastDigit(int number1, int number2, int number3) {
        boolean sameFound = false;
        if ( number1 >= 10 && number1 <= 1000
                && number2 >= 10 && number2 <= 1000
                && number3 >= 10 && number3 <= 1000 ) {
            sameFound = ( (number1 % 10 == number2 % 10)
                    || (number1 % 10 == number3 % 10)
                    || (number2 % 10 == number3 % 10) );
        }
        return sameFound;
    }

    private static void GreatestCommonDivisor() {
        printHeader("4. hasSameLastDigit() :");
        System.out.println("25, 15  ->  5 : " + getGreatestCommonDivisor(25, 15));
        System.out.println("12, 30  ->  6 : " + getGreatestCommonDivisor(12, 30));
        System.out.println("9, 18   -> -1 : " + getGreatestCommonDivisor(9, 18));
        System.out.println("39, 26  -> 13 : " + getGreatestCommonDivisor(39, 26));
        System.out.println("104, 91 -> 13 : " + getGreatestCommonDivisor(104, 91));
        System.out.println("17, 23  ->  1 : " + getGreatestCommonDivisor(17, 23));
    }
    public static int getGreatestCommonDivisor(int number1, int number2) {
        int divisor = (number1 < 10 || number2 < 10) ? -1 : 1;
        if (divisor == 1) {
            int maxDivisor = (number1 < number2) ? number1 : number2;
            while (maxDivisor > 1) {
                if ( (number1 % maxDivisor == 0) && (number2 % maxDivisor == 0)) {
                    divisor = maxDivisor;
                    break;
                }
                maxDivisor--;
            }
        }
        return divisor;
    }

    private static void FactorPrinter() {
        printHeader("5. printFactors() :");
        System.out.print("6  ->        1 2 3 6 : ");
        printFactors(6);
        System.out.print("32 ->  1 2 4 8 16 32 : ");
        printFactors(32);
        System.out.print("10 ->       1 2 5 10 : ");
        printFactors(10);
        System.out.print("-1 ->  Invalid Value : ");
        printFactors(-1);
    }
    public static void printFactors(int number) {
        String result = number < 1 ? "Invalid Value" : "";
        if (number > 0) {
            int check = 1;
            while (check <= number) {
                if (number % check == 0) {
                    result += " " + check;
                }
                check++;
            }
        }
        System.out.println(result);
    }

    private static void PerfectNumber() {
        printHeader("6. isPerfectNumber() :");
        System.out.println("6  ->  true : " + isPerfectNumber(6));
        System.out.println("28 ->  true : " + isPerfectNumber(28));
        System.out.println("5  -> false : " + isPerfectNumber(5));
        System.out.println("-1 -> false : " + isPerfectNumber(-1));
    }
    public static boolean isPerfectNumber(int number) {
        boolean result = false;
        if ( number > 0 ) {
            int divisorTotal = 0, check = 1;
            while ( check < number ) {
                if ( number % check == 0 ) {
                    divisorTotal += check;
                }
                check++;
            }
            result = ( divisorTotal == number );
        }
        return result;
    }

    private static void NumberToWords() {
        printHeader("7. numberToWords() :");
//        System.out.print("123  ->      One Two Three : ");
        numberToWords(123);
//        System.out.print("1010 ->  One Zero One Zero : ");
        numberToWords(1010);
//        System.out.print("1000 -> One Zero Zero Zero : ");
        numberToWords(1000);
//        System.out.print("-12  ->      Invalid Value : ");
        numberToWords(-12);
//        System.out.print("-12  ->      Invalid Value : ");
        numberToWords(-12);
//        System.out.print("10   ->           One Zero : ");
        numberToWords(10);
    }
    public static void numberToWords(int number) {
        String result = (number < 0 ? "Invalid Value" : "");
        if (number > 0) {
            int reverse      = reverse(number),
                digitCount   = getDigitCount(number),
                digitCounted = 0,
                digit;
            while (reverse > 0) {
                digitCounted++;
                digit    = reverse % 10;
                reverse /= 10;
                switch (digit) {
                    case 1:
                        result += "One ";
                        break;
                    case 2:
                        result += "Two ";
                        break;
                    case 3:
                        result += "Three ";
                        break;
                    case 4:
                        result += "Four ";
                        break;
                    case 5:
                        result += "Five ";
                        break;
                    case 6:
                        result += "Six ";
                        break;
                    case 7:
                        result += "Seven ";
                        break;
                    case 8:
                        result += "Eight ";
                        break;
                    case 9:
                        result += "Nine ";
                        break;
                    default:
                        result += "Zero ";
                        break;
                }

            }
            while (digitCounted < digitCount) {
                result += "Zero ";
                digitCounted++;
            }
        }
        System.out.println(result.trim());
    }
    public static int getDigitCount(int number) {
        int result = (number < 0) ? -1 : 1;
        if (result > -1) {
            while (number > 0) {
                number /= 10;
                if (number > 0) {
                    result++;
                }
            }
        }
        return result;
    }
    public static int reverse(int number) {
        boolean isNegative = number < 0;
        int check   = number * (isNegative ? -1 : 1);
        int reverse = 0;
        while (check > 0) {
            reverse = (reverse * 10) + check % 10;
            check  /= 10;
        }
        return reverse * (isNegative ? -1 : 1);
    }
}
