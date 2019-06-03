package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-06-03, 10:29
*/

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;

    public StockItem( String name, double price ) {
        this( name, price, 0);
    }

    public StockItem( String name, double price, int quantityStock ) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public void setPrice( double price ) {
        if ( price > 0 ) this.price = price;
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) this.quantityStock = newQuantity;
    }

    @Override
    public boolean equals( Object obj ) {
        System.out.println("Entering StockItems.equals()");
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
        System.out.println("Entering StockItem.compareTo()");
        if (this == that) return 0;
        if (that != null) return this.name.compareTo( that.getName() );
        throw new NullPointerException(  );

    }

    @Override
    public String toString() {
        return this.name + " : price " + this.price;
    }
}
