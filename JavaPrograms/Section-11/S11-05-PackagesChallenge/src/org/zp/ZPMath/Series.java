package org.zp.ZPMath;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-15, 15:18
*/

public class Series {
    // Go for it buddy!!
    public static long nSum( int n ) {
        long total = 0;
        for (int i = 0; i <= n; i++) {
            total += i;
        }
        return total;
    }

    public static long factorial( int n) {
        long result = 0;
        for (int i = 1; i <= n; i++) {
            result = Math.max(result, 1) * i;
        }
        return result;
    }

    public static long fibonacci( int n) {
        // fibonacci(n) returns the nth Fibonacci number. These are defined as:
        // f(0) = 0
        // f(1) = 1
        // f(n) = f(n-1) + f(n-2)
        // (so f(2) is also 1. The first 10 fibonacci numbers are:
        // 0 (0 + 0), 1, 1, 2, 3, 5, 8, 13, 21, 34, 55.
        long result = 0;
        if (n==0) {
            result = 0;
        } else if (n==1) {
            result = 1;
        } else {
            result = fibonacci( n - 1) + fibonacci( n - 2);
        }

        return result;
    }
}
