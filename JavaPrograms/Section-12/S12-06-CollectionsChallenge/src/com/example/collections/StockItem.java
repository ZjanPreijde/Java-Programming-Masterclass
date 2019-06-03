package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-06-03, 10:29
*/

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityInStock, quantityReserved;

    public StockItem( String name, double price ) {
        this( name, price, 0);
    }

    public StockItem( String name, double price, int quantityInStock) {
        this.name = name;
        this.price = price;
        this.quantityInStock = quantityInStock;
        this.quantityReserved = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityInStock;
    }

    public int quantityReserved() {
        return quantityReserved;
    }

    public int quantityAvailable() {
        return quantityInStock - quantityReserved;
    }

    public void adjustStock(int quantity) {
        System.out.println("adjustStock(), " + this.getName() + ", " + quantity);
        int newQuantity = this.quantityInStock + quantity;
        if (newQuantity >= 0) this.quantityInStock = newQuantity;
    }

    public void adjustReservation(int quantity) {
        System.out.println("adjustReservation(), " + this.getName() + ", " + quantity);
        int newQuantity = this.quantityReserved + quantity;
        if (newQuantity >= 0) this.quantityReserved = newQuantity;
    }

    @Override
    public boolean equals( Object obj ) {
//        System.out.println("Entering StockItems.equals()");
        if (this == obj) return true;
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        return this.name.equals( ((StockItem) obj).getName() );
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo( StockItem that ) {
//        System.out.println("Entering StockItem.compareTo()");
        if (this == that) return 0;
        if (that != null) return this.name.compareTo( that.getName() );
        throw new NullPointerException(  );

    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
