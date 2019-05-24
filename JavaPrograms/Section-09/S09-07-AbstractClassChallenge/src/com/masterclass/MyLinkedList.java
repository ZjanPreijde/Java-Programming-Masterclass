package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-10, 17:07
*/

public class MyLinkedList implements NodeList {
    private ListItem root = null;

    public MyLinkedList( ListItem root ) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem( ListItem newItem ) {
        if (this.root == null) {
            // the list was empty, added item becomes root ot the list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo( newItem ));
            if (comparison < 0) {
                // newItem is greater than currentItem, move to next if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no next, so insert at the end of the list
                    currentItem.setNext( newItem );
                    newItem.setPrevious( currentItem );
                    return true;
                }

            } else if (comparison > 0) {
                // we are looping forward,
                //   newItem is smaller than currentItem, so must be inserted before
                if (currentItem.previous() != null) {
                    // currentItem has a previous item, embed by setting pointers
                    currentItem.previous().setNext( newItem );
                    newItem.setPrevious( currentItem.previous() );
                    newItem.setNext( currentItem );
                    currentItem.setPrevious( newItem );
                    /*
                    teacher abbreviated this to
                        currentItem.previous().setNext( newItem ).setPrevious( currentItem.previous() );
                        newItem.setNext( currentItem ).setPrevious( newItem );
                    Possible because setNext returns item handed to it and hands it to the next .method().
                    Very smart, but totally unreadable
                     */
                } else {
                    // there is no previous for currentItem, so newItem inserted at start of list
                    // set pointers
                    currentItem.setPrevious( newItem );
                    newItem.setNext( currentItem );
                    // set lists root to newItem
                    this.root = newItem;
                    /*
                    teachers solution :
                    newItem.setNext( this.root );
                    this.root.setPrevious( newItem );
                    this.root = newItem;
                    */
                }
                return true;
            } else {
                // newItem equal to currentItem, do not insert
                System.out.println(newItem.getValue() + " is already present, not added");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem( ListItem item ) {
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo( item );
            if (comparison == 0) {
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                } else {

                }
                currentItem.previous().setNext( currentItem.next()) ;
                if (currentItem.next() != null) {
                    currentItem.next().setPrevious( currentItem.previous() );
                }
                currentItem.setPrevious( null );
                currentItem.setNext( null );
                return true;
            } else if ( comparison < 0) {
                currentItem = currentItem.next();
            } else { // comparison > 0, past position in list where it could be, so not found
                return false;
            }
        }
        return false;
    }

    @Override
    public void traverse( ListItem root ) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
