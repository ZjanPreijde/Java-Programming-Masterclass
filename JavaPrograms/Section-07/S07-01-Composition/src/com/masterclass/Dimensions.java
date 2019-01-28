package com.masterclass;

public class Dimensions {
    private int width, height, depth;
    private String unit;

    public Dimensions(int width, int height, int depth) {
        this(width, height, depth, "mm");
    }
    public Dimensions(int width, int height, int depth, String unit) {
        this.width = width;
        this.height = height;
        this.depth = depth;
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getDepth() {
        return depth;
    }
}
