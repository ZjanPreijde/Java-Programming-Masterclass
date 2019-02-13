package com.masterclass;

import java.util.ArrayList;

public class Branch {
    String branchName, bankName;
    ArrayList<Customer> customers = new ArrayList<>();

    public Branch(String branchName, String bankName) {
        this.branchName = branchName;
        this.bankName   = bankName;
    }

    public String getBranchName() {
        return branchName;
    }
    public String getFullName() {
        return "'" + bankName + " - " + branchName + "'";
    }
    public int getCustomerCount() {
        return customers.size();
    }
    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public Customer addCustomer(String name, double amount) {
        Result result = new Result();
        return addCustomer(name, amount, result);
    }
    public Customer addCustomer(String name, double amount, Result result) {
        Customer customer = null;
        if (name == "") {
            result.setFail("Name customer was empty");
            return customer;
        }
        customer = findCustomer(name);
        if (customer != null) {
            result.setFail("Customer " + name + " already exists for branch '" + branchName + "'");
            return customer;
        }
        customer = new Customer(name, amount);
        customers.add( customer );
        result.setSucceed( "Customer " + name + " added\n\tto '" + getFullName() + "'"
                + (amount == 0d ? "" : "\n\tstart balance " + String.format( "%.2f", amount) ) );
        return customer;
    }
    public Customer getCustomer(String name) {
        Result result = new Result();
        return getCustomer(name, result);
    }

    public Customer getCustomer(String name, Result result) {
        Customer customer = null;
        if (name == "") {
            result.setFail("No name to find given");
            return null;
        }
        customer = findCustomer(name);
        if (customer == null) {
            result.setFail("Customer " + name + " does not exist for branch '" + branchName + "'");
        } else {
            result.setSucceed("Customer " + name + " found");
        }
        return customer;
    }
    public Customer findCustomer(String name) {
        Result result = new Result();
        return findCustomer(name, result);
    }
    public Customer findCustomer(String name, Result result) {
        Customer customer = null;
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getCustomerName().equals(name)) {
                customer = customers.get(i);
                break;
            }
        }
        return customer;
    }

    public ArrayList<String> listCustomers() {
        ArrayList<String> list = new ArrayList<>();
        if (this.customers.size() == 0) {
            list.add("Branch has no customers");
        } else {
            for (int i = 0; i < customers.size(); i++) {
                list.add( customers.get(i).getCustomerName()
                        + ", balance = " + String.format("%.2f", customers.get(i).getBalance() )
                        + ", " + customers.get(i).getTransactionCount() + " transactions"
                );
            }
        }
        return list;
    }
    @Override
    public String toString() {
        return String.format("Branch{Name='%s', %d customers}", branchName, customers.size());
    }
}
