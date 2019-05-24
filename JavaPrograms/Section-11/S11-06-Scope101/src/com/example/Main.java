package com.example;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String varFour = "this is private to main()";
        ScopeCheck sc = new ScopeCheck();
        System.out.println("sc.publicVar       : " + sc.publicVar);
        System.out.println("sc.getVarOne() : " + sc.getVarOne());
        System.out.println("varFour: " + varFour);

        sc.multiply();
        sc.useInner();

        ScopeCheck.InnerClass scIc = sc.new InnerClass();
        scIc.multiply();
    }
}
