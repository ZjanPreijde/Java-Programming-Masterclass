package com.masterclass;

public class Song {
    private String title;
    private int durationMinutes, durationSeconds;

    // Constructor
    public Song(String title, int durationMinutes, int durationSeconds) {
        this.title = title;
        this.durationMinutes = durationMinutes;
        this.durationSeconds = durationSeconds;
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public double getDurationMinutes() {
        return durationSeconds;
    }
    public double getDurationSeconds() {
        return durationSeconds;
    }

    @Override
    public String toString() {
        return "Song : " + title + ", " + durationMinutes + "m" + durationSeconds + "s";
    }
}
