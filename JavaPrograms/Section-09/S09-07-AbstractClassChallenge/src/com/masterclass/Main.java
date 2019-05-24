package com.masterclass;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        MyLL();
        MyBST();
    }

    private static void MyLL() {
        // Creating our own LinkedList
        MyLinkedList list = new MyLinkedList( null );

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        System.out.println("adding\n  " + stringData + "\nto Linked List\n");

        String[] data = stringData.split(" ");
        List<String> result = new ArrayList <>(  );

        for (String s : data)  {
            // create new item with value set to the string s
            if ( list.addItem( new Node( s ) ) ) {
                System.out.println(s + " added");
            }
        }

        System.out.println("\nResult :\n======");
        list.traverse( list.getRoot() );
        System.out.println("\nRemoving Melbourne");
        Node r = new Node("Melbourne");
        boolean removed = list.removeItem( r );
        System.out.println( r.getValue() + (removed ? "" : " NOT") + " removed from list");
        System.out.println("\nResult :\n======");
        list.traverse( list.getRoot() );
        System.out.println("\nRemoving Melbourne");
        removed = list.removeItem( r );
        System.out.println( r.getValue() + (removed ? "" : " NOT") + " removed from list");

    }
    private static void MyBST() {
        // Creating our own Binary Search Tree
        SearchTree tree = new SearchTree( null );

        String stringData = "Darwin Brisbane Perth Melbourne Canberra Adelaide Sydney Canberra";

        System.out.println("adding\n  " + stringData + "\nto Binary Search Tree\n");

        String[] data = stringData.split(" ");
        List<String> result = new ArrayList <>(  );

        for (String s : data)  {
            // create new item with value set to the string s
            if ( tree.addItem( new Node( s ) ) ) {
                System.out.println(s + " added");
            }
        }

        System.out.println("\nResult :\n======");
        tree.traverse( tree.getRoot() );
        System.out.println("\nRemoving Melbourne");
        Node r = new Node("Melbourne");
        boolean removed = tree.removeItem( r );
        System.out.println( r.getValue() + (removed ? "" : " NOT") + " removed from binary search tree");
        System.out.println("\nResult :\n======");
        tree.traverse( tree.getRoot() );
        System.out.println("\nRemoving Melbourne");
        removed = tree.removeItem( r );
        System.out.println( r.getValue() + (removed ? "" : " NOT") + " removed from binary search tree");

    }
}
