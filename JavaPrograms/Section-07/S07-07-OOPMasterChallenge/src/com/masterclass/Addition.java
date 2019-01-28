package com.masterclass;

public class Addition {
    private String desc;
    private double price;

    public Addition(String desc) {
        this(desc, 0);
    }
    public Addition(String desc, double price) {
        this.desc = desc;
        this.price = price;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public double getPrice() {
        return price;
    }
}
