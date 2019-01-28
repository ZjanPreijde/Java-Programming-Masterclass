package com.masterclass;

public class Dimensions {
    private int width, height, depth;
    private String unit;

    public Dimensions(int width, int height, int depth, String unit) {
        this.width = width;
        this.height = height;
        this.depth = depth;
        this.unit = unit;
    }
    public String getDimensionsData() {
        return "height " + height + unit
                + ", width " + width + unit
                + ", depth " + depth + unit;
    }
}
