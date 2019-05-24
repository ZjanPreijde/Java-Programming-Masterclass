package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-13, 14:56
*/

import java.util.List;

public class SearchTree implements NodeList {

    private ListItem root = null;

    public SearchTree(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem( ListItem newItem ) {
        if (this.root == null) {
            // the tree was empty, added item becomes root ot the list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = (currentItem.compareTo( newItem ));
            if (comparison < 0) {
                // newItem is greater than currentItem, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    // there is no node to the right, so add at this point
                    currentItem.setNext( newItem );
                    return true;
                }
            } else if (comparison > 0) {
                // newItem is smaller than currentItem, move left if possible
                if (currentItem.previous() != null) {
                    currentItem = currentItem.previous();
                } else {
                    // there is no node to the left, so add at this point
                    currentItem.setPrevious( newItem );
                    return true;
                }
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
        if (item != null) {
            System.out.println("Deleting " + item.getValue());
        }
        ListItem currentItem = this.root;
        ListItem parentItem  = currentItem;
        while (currentItem != null) {
            int comparison = currentItem.compareTo( item );
            if (comparison < 0) {
                parentItem = currentItem;
                currentItem = currentItem.next();
            } else if (comparison > 0) {
                parentItem = currentItem;
                currentItem = currentItem.previous();
            } else  {
                // Found it, remove it.
                performRemoval(currentItem, parentItem);
                return true;
            }
        }
        return false;
    }

    private void performRemoval( ListItem item, ListItem parent ) {
        // remove item from the tree
        if (item.next() == null) {
            // no right tree, so make parent point to left tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext( item.next() );
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious( item.previous() );
            } else {
                // parent must be item, which means we are looking at the root of the tree
                this.root = item.previous();
            }
        } else if (item.previous() == null) {
            // no left tree, so make parent point to right tree (which may be null)
            if (parent.next() == item) {
                // item is right child of its parent
                parent.setNext( item.next() );
            } else if (parent.previous() == item) {
                // item is left child of its parent
                parent.setPrevious(item.next());
            } else {
                // parent is item, we are at the root
                this.root = item.next();
            }
        } else {
            // Both left and right tree are not null, deletions is a lot trickier
            // From the right sub-tree, find the smallest value (i.e., the leftmost).
            ListItem current = item.next();
            ListItem leftmostParent = item;
            while (current.previous() != null) {
                leftmostParent = current;
                current = current.previous();
            }
            // Now put the smallest value into our node to be deleted
            item.setValue( current.getValue() );
            // and delete the smallest
            if (leftmostParent == item) {
                // there was no leftmost node, so 'current' points to the smallest
                // node (the one that must now be deleted).
                item.setNext(current.next());
            } else {
                // set the smallest node's parent to point to
                // the smallest node's right child (which may be null).
                leftmostParent.setPrevious( current.next() );
            }
        }
    }

    @Override
    public void traverse( ListItem root ) {
        // recursive method
        if (root != null) {
            traverse( root.previous() ) ;
            System.out.println(root.getValue());
            traverse( root.next() );
        }

    }
}
