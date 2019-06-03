package com.example.collections;
/*
    Another great class by Zjan Preijde
    Creation : 2019-06-03, 11:02
*/

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map <String, StockItem> stockList;

    public StockList() {
        this.stockList = new LinkedHashMap <>(  );
    }

    public int addStock( StockItem item) {
        if (item != null) {
            StockItem inStock = stockList.getOrDefault(item.getName(), item);
            if (inStock != item) {
                // item was already in stock, adjust stock of passed item with existing value
                item.adjustStock( inStock.quantityInStock() );
            }
            // add or overwrite
            stockList.put(item.getName(), item);
            return item.quantityInStock();

        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = stockList.getOrDefault( item, null );
        if (( inStock != null ) && (inStock.quantityInStock() >= quantity) && (quantity > 0)) {
            inStock.adjustStock( -quantity );
            return quantity;
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        System.out.println("reserveStock(), " + item + ", " + quantity);
        StockItem inStock = stockList.getOrDefault( item, null );
        if (( inStock != null ) && (inStock.quantityAvailable() - quantity >= 0)) {
            inStock.adjustReservation( quantity );
            return quantity;
        }
        return 0;
    }

    public StockItem get( String key) {
        return stockList.get(key);
    }

    public Map<String, Double> priceList() {
        Map<String, Double> priceList = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : stockList.entrySet()) {
            priceList.put( item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap( priceList );
    }

    public Map<String, StockItem> items() {
        return Collections.unmodifiableMap( stockList );
    }

    @Override
    public String toString() {
        String result = "\nStock List\n";
        double totalValue = 0.0;
        for (Map.Entry<String, StockItem> item : stockList.entrySet()) {
            StockItem stockItem = item.getValue();
            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();

            result += stockItem.getName() + ". " + stockItem.quantityInStock()+ " in stock. "
                    + stockItem.quantityReserved()+ " reserved"
                    + ", value " + String.format( "%.2f", itemValue) + "\n";
            totalValue += itemValue;
        }
        result += "--------\nTotal value " + String.format("%.2f", totalValue) + "\n===========";
        return result;
    }
}
