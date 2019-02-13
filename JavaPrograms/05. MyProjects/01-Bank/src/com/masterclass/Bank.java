package com.masterclass;

import java.util.ArrayList;

public class Bank {
    String bankName;
    ArrayList<Branch> branches = new ArrayList<>();

    public Bank(String bankName) {
//        this.bankName = (bankName.equals("") ? "noName" : "");
        this.bankName = bankName;
    }

    public String getBankName() {
        return bankName;
    }

    public ArrayList<Branch> getBranches() {
        return branches;
    }

    public Branch addBranch(String name) {
        Result result = new Result();
        Branch branch = addBranch(name, result);
        return branch;
    }
    public Branch addBranch(String name, Result result) {
        Branch branch;
        if ( name.equals("")) {
            result.setFail("Name branch is empty");
            return null;
        }
        branch = findBranch(name, result);
        if (branch != null) {
            result.setFail("Branch '" + name + "' already exists for " + this.bankName);
            return branch;
        }
        branch = new Branch(name, bankName);
        branches.add( branch );
        result.setSucceed("Branch '" + name + "' added\n\tto " + this.bankName);
        return branch;
    }
    public Branch getBranch(String name) {
        Result result = new Result();
        return getBranch(name, result);
    }
    public Branch getBranch(String name, Result result) {
        Branch branch;
        if ( name.equals("")) {
            result.setFail("Name branch is empty");
            return null;
        }
        branch = findBranch(name, result);
        if ( branch == null) {
            result.setFail("Branch '" + name + "' not found for " + this.bankName);
        }
        return branch;
    }

    private Branch findBranch(String name, Result result) {
        Branch branch = null;
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).getBranchName().equals(name)) {
                branch = branches.get(i);
                break;
            }
        }
        return branch;
    }

    public ArrayList<String> listBranches() {
        ArrayList<String> list = new ArrayList<>();
        if (this.branches.size() == 0) {
            list.add("Bank has no branches");
        } else {
            for (int i = 0; i < branches.size(); i++) {
                list.add( branches.get(i).getBranchName() + ", "
                        + branches.get(i).getCustomerCount() + " customers");
            }
        }
        return list;
    }
    @Override
    public String toString() {
        return "Bank{" +
                "Name='" + bankName + '\'' +
                ", " + branches.size() + " branches" +
                "}";
    }
}
