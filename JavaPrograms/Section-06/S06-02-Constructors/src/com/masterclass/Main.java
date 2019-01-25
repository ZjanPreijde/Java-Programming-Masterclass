package com.masterclass;

public class Main {

    public static void main(String[] args) {
        testBankAccount();
        testVipCustomer();
    }
    private static void testVipCustomer() {
        VipCustomer newVipCustomer;

        newVipCustomer = new VipCustomer();
        newVipCustomer.printData();

        newVipCustomer = new VipCustomer("Frank", "frank@mail.com");
        newVipCustomer.printData();

        newVipCustomer = new VipCustomer("Bob", "bob@mail.com", 10_000d);
        newVipCustomer.printData();
    }
    private static void testBankAccount() {
        BankAccount newAccount;

        newAccount = new BankAccount();
        newAccount.setAccountNumber("US50ABNU0123456789");
        newAccount.setName("Frank");
        newAccount.setEmail("frank@masterclass.com");
        newAccount.setPhoneNumber("+1 512 45678");

        newAccount.withdraw(10d);
        newAccount.printData();
        newAccount.deposit(1000d);
        newAccount.printData();
        newAccount.withdraw(500d);
        newAccount.printData();

        newAccount = new BankAccount("US50ABNU0123456789", "Bob",
                "frank@masterclass.com", "+1 512 45678");
        newAccount.printData();

        newAccount = new BankAccount();
        newAccount.printData();


        newAccount = new BankAccount("US50ABNU0123456789");
        newAccount.printData();

    }
}
