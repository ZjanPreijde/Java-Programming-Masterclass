package com.example.collections;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();
    private static Basket basket = new Basket("John Doe");

    public static void main(String[] args) {
        StockItem temp;

        temp = new StockItem("bread", 0.86, 100);
        stockList.addStock( temp );
        temp = new StockItem("cheese", 1.11, 100);
        stockList.addStock( temp );
        temp = new StockItem("milk", 0.33, 100);
        stockList.addStock( temp );
        temp = new StockItem("butter", 0.39, 100);
        stockList.addStock( temp );

        System.out.println(stockList);


        reserveItem( basket,"bread" , 5 );
        System.out.println(basket);
        unreserveItem( basket,"bread" , 3 );
        System.out.println(basket);
        unreserveItem( basket,"bread" , 2 );

        System.out.println("Test unreserve nonreserved");
        unreserveItem( basket,"milk" , 2 );


        System.out.println(basket);
        reserveItem( basket,"bread" , 5 );
        reserveItem( basket,"bread" , 5 );
        reserveItem( basket,"milk" , 75 );
        reserveItem( basket,"beer" , 75 ); // not on stock
        reserveItem( basket,"milk" , 50 ); // qty to high

        System.out.println(basket);
        System.out.println(stockList);

        basket.checkoutBasket( stockList);

        System.out.println(basket);
        System.out.println(stockList);

    }

    public static int reserveItem( Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get( item );
        if (stockItem == null) {
            System.out.println("We do not sell " + item);
            return 0;
        }
        if (stockList.reserveStock( item, quantity ) != 0) {
            basket.addToBasket( stockItem, quantity );
            return quantity;
        }
        return 0;
    }
    public static int unreserveItem( Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get( item );
        if (stockItem == null) {
            System.out.println("We do not sell " + item);
            return 0;
        }
        if (basket.inBasket(stockItem) - quantity < 0) {
            System.out.println("Qty to unreserve is too high");
            return 0;
        } else if (stockList.reserveStock( item, -quantity ) != 0) {
            basket.removeFromBasket( stockItem, quantity, true );
            return quantity;
        }
        return 0;
    }
}
