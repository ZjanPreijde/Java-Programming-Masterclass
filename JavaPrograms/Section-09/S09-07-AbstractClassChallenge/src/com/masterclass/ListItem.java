package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-10, 16:48
*/

public abstract class ListItem {
    protected ListItem rightLink = null, leftLink = null;
    protected Object value;

    public ListItem( Object value ) {
        this.value = value;
    }
    abstract ListItem next();
    abstract ListItem setNext(ListItem item);
    abstract ListItem previous();
    abstract ListItem setPrevious(ListItem item);

    abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }

    public void setValue( Object value ) {
        this.value = value;
    }
}
