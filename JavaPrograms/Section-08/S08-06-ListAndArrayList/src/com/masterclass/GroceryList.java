package com.masterclass;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public Result getStringGroceryList() {
        Result result = new Result();
        String message = "";
        message += "-------------"
                + "\nYou have " + groceryList.size()
                + " items on your grocerylist\n";
        for (int i = 0; i < groceryList.size(); i++) {
            message += (i + 1) + ". " + groceryList.get(i) + "\n";
        }
        message += "-------------";
        result.setResult(true, message );
        return result;
    }
    public Result addGroceryItem(String item) {
        groceryList.add(item);
        Result result = new Result();
        result.setResult(true
                , item + " added");
        return result;
    }
    // Overload
    public Result modifyGroceryItem(String currentItem, String newItem) {
        int position = findItem(currentItem);
        Result result = new Result();
        if (position >= 0) {
            modifyGroceryItem(position, newItem);
            result.setResult(true
                    , currentItem + " replaced with " + newItem);
        } else {
            result.setResult(false
                    , currentItem + " not found");
        }
        return result;
    }
    // Overloaded, private
    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
    }
    // Overload
    public Result removeGroceryItem(String item) {
        int position = findItem(item);
        Result result = new Result();
        if (position >= 0) {
            removeGroceryItem(position);
            result.setResult(true
                    , item + " removed");
        } else {
            result.setResult(false
                    , item + " not found");
        }
        return result;
    }
    // Overloaded, private
    private void removeGroceryItem(int position) {
        groceryList.remove(position);

    }
    public Result onList(String searchItem) {
        Result result = new Result();
        if (findItem(searchItem) >= 0) {
            result.setResult(true
                    , searchItem + " found");
        } else {
            result.setResult(false
                    , searchItem + " not found");
        }
        return result;
    }
    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);
    }
}
