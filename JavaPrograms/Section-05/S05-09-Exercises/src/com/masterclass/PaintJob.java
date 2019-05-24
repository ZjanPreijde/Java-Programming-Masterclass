package com.masterclass;
/*
    Another great class by Zjan Preijde
    Creation : 2019-05-08, 15:04
*/

public class PaintJob {
    public static int getBucketCount( double width, double height
            , double areaPerBucket ) {
        return getBucketCount( width, height, areaPerBucket, 0 );
    }
    public static int getBucketCount( double area
            , double areaPerBucket) {
        return getBucketCount( area, 1, areaPerBucket, 0 );
    }
    public static int getBucketCount( double width, double height
            , double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <= 0 || areaPerBucket <= 0 || extraBuckets < 0) {
            return -1;
        }
        double area     = height * width;
        double areaLeft = area - (extraBuckets * areaPerBucket);
        return (int) Math.ceil(areaLeft / areaPerBucket);
    }
}
