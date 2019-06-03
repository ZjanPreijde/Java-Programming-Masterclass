package com.example.collections;

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


        sellItem( basket,"bread" , 5 );
        sellItem( basket,"bread" , 5 );
        sellItem( basket,"bread" , 5 );
        sellItem( basket,"bread" , 5 );
        sellItem( basket,"milk" , 75 );
        sellItem( basket,"beer" , 75 ); // not on stock
        sellItem( basket,"milk" , 50 ); // qty to high

        System.out.println(basket);
        System.out.println(stockList);
    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.get( item );
        if (stockItem == null) {
            System.out.println("We do not sell " + item);
            return 0;
        }
        if (stockList.sellStock( item, quantity ) != 0) {
            basket.addToBasket( stockItem, quantity );
            return quantity;
        }
        return 0;
    }
}
