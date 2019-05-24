package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-02-13, 18:40
*/


public class Button {
    // Example of local class
    private String title;
    private OnClickListener onClickListener;

    public Button( String title ) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setOnClickListener( OnClickListener onClickListener ) {
        System.out.println("I've been attached");
        this.onClickListener = onClickListener;
    }

    public void onClick() {
        this.onClickListener.onClick( this.title );
    }

    public interface OnClickListener {
        public void onClick( String title );
    }
}
