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
        System.out.println("Entering addToBasket()");
        if ((item != null) && (quantity > 0)) {
            int inBasket = shoppingList.getOrDefault(item, 0);
            shoppingList.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public Map<StockItem, Integer> Items() {
        return Collections.unmodifiableMap( shoppingList );
    }

    @Override
    public String toString() {
        String result = "\nBasket contains " + shoppingList.size() + " items\n";
        double totalCost = 0;
        for (Map.Entry<StockItem, Integer> item : shoppingList.entrySet()) {
            result += item.getKey() + ". " + item.getValue() + " purchased at " + item.getKey().getPrice() + "\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        result += "-----------\nTotal cost : " + String.format("%.2f", totalCost) + "\n===============" ;
        return result;
    }
}
