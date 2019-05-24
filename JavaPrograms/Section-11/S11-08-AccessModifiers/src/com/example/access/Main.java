package com.example.access;

//import com.example.access2.Account3; not accessible, package-private

public class Main {

    public static void main(String[] args) {
	// write your code here
        fraud1();
        fraud2();
    }
    public static void fraud1() {
        System.out.println("--------------");
        Account acc = new Account("Freddy Heineken");
        acc.deposit(500000);
//        acc.deposit( -1000000 ); // invalid
        acc.withdraw( 250000 );
//        acc.withdraw( -250000 ); // invalid
        System.out.println("Balance " + acc.getBalance());

        System.out.println("\nFraud, change balance");
        acc.balance += 1000000;
        System.out.println("Balance " + acc.getBalance());
        acc.calculateBalance();

        System.out.println("\nFraud, add transaction, change balance");
        acc.transactions.add(1000000);
        acc.balance += 1000000;
        System.out.println("Balance " + acc.getBalance());
        acc.calculateBalance();
        System.out.println("Balance " + acc.getBalance());

    }
    public static void fraud2() {
        System.out.println("--------------");
        Account2 acc = new Account2("Freddy Heineken");
        acc.deposit(500000);
        acc.withdraw( 250000 );
        System.out.println("Balance " + acc.getBalance());

        System.out.println("\nFraud attempt, change balance");
//        acc.balance += 1000000; // not possible any more
        System.out.println("Balance " + acc.getBalance());
        acc.calculateBalance();

        System.out.println("\nFraud attempt, add transaction, change balance");
//        acc.transactions.add(1000000);
//        acc.balance += 1000000; // not possible any more
        System.out.println("Balance " + acc.getBalance());
        acc.calculateBalance();
        System.out.println("Balance " + acc.getBalance());

    }
}
