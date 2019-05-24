package com.example;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-16, 9:34
*/

public class ScopeCheck {
    // Go for it buddy!!
    public int publicVar = 0;
    private int varOne;

    public ScopeCheck() {
        setVarOne(1);
        System.out.println( "ScopeCheck created"
                + ",\n publicVar = " + publicVar
                + ",\n varOne = " + varOne);
    }
    private void setVarOne( int value) {
        varOne = 1;
    }

    // package-private, no access modifier
    int getVarOne() {
        return varOne;
    }

    public void multiply() {
        System.out.println("---");
        int varTwo = varOne * 2;
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times " + varTwo + " is " + i * varTwo);
        }
        System.out.println("====");
    }

    public void useInner() {
        InnerClass ic = new InnerClass();
        System.out.println("varThree from outer class is " + ic.varThree);

    }

    public class InnerClass {
        public int varThree = varOne * 3;
        public int varFive  = ScopeCheck.this.varOne * 4;

        public InnerClass() {
            System.out.println( "InnerClass created"
                    + ", varThree = " + varThree
                    + ", varFive is " + varFive);
        }

        public int getVarThree() {
            return varThree;
        }

        public void multiply() {
            ScopeCheck.this.multiply();
            System.out.println("---");
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times " + varThree + " is " + i * varThree );
            }
            System.out.println("====");
        }
    }

}
