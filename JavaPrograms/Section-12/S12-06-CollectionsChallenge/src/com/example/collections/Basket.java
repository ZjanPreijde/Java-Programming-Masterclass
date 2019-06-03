package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-06-03, 12:02
*/

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private final Map <StockItem, Integer> shoppingList;

    public Basket( String name ) {
        this.name = name;
        this.shoppingList = new TreeMap <>(  );
    }

    public int addToBasket(StockItem item, int quantity) {
//        System.out.println("Entering addToBasket()");
        if ((item != null) && (quantity > 0)) {
            int inBasket = shoppingList.getOrDefault(item, 0);
            shoppingList.put(item, inBasket + quantity);
            if (inBasket + quantity == 0) {
                System.out.println("REMOVE ITEM");
                shoppingList.remove( item );
            }
            return inBasket;
        }
        return 0;
    }

    public int inBasket(StockItem item) {
        return shoppingList.getOrDefault( item, 0);
    }

    public int removeFromBasket(StockItem item, int quantity, boolean clearIfZero) {
//        System.out.println("Entering addToBasket()");
        if ((item != null) && (quantity > 0)) {
            int inBasket = shoppingList.getOrDefault(item, 0);
            if (inBasket - quantity >= 0) {
                shoppingList.put( item, inBasket - quantity );
                if ( inBasket - quantity == 0 && clearIfZero) {
                    // can not do .remove() when called from loop in checkoutBasket,
                    //  ConcurrentModificationException
                    System.out.println( "REMOVE ITEM" );
                    shoppingList.remove( item );
                }
                return inBasket;
            } else {
                return 0;
            }
        }
        return 0;
    }

    public void checkoutBasket(StockList stockList) {
        System.out.println("\nChecking out basket");
        shoppingList.forEach( (item, qty) -> {
            System.out.println("- " + item.getName());
            if (stockList.sellStock( item.getName(), qty ) != 0) {
                stockList.reserveStock( item.getName(), -qty );
                removeFromBasket( item, qty, false) ;
            }
        } );
        shoppingList.clear();
    }

    public Map<StockItem, Integer> items() {
        return Collections.unmodifiableMap( shoppingList );
    }

    @Override
    public String toString() {
        String result = "\nBasket contains " + shoppingList.size() + " items\n";
        double totalCost = 0;
        for (Map.Entry<StockItem, Integer> item : shoppingList.entrySet()) {
            result += item.getKey() + ". " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        result += "-----------\nTotal cost : " + String.format("%.2f", totalCost) + "\n===============" ;
        return result;
    }
}
