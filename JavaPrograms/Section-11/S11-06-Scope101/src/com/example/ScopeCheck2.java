package com.example;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-16, 9:34
*/

public class ScopeCheck2 {
    // Go for it buddy!!
    public int publicVar = 0;
    private int privateVar = 1;
    private int varOne = 1;

    public ScopeCheck2() {
        System.out.println( "ScopeCheck created"
                + ",\n publicVar = " + publicVar
                + ",\n privateVar = " + privateVar
                + ",\n varOne = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {
        System.out.println("====");
        int varTwo = 2;
        int privateVar = this.privateVar * 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times " + varTwo + " is " + i * varTwo);
        }
    }

    public class InnerClass {
        public int varThree = varOne * 3;
        public int privateVar = ScopeCheck2.this.privateVar * 3;

        public InnerClass() {
            System.out.println( "InnerClass created, varThree = " + varThree );
        }

        public int getVarThree() {
            return varThree;
        }

        public void timesTwo() {
            ScopeCheck2.this.timesTwo();
            System.out.println("====");
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times " + varThree + " is " + i * varThree );
            }
        }
    }

}
