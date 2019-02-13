package com.masterclass;

import java.util.ArrayList;

public class Album {
    String title;
    ArrayList<Song> songs;

    // Constructor
    public Album(String title) {
        this.title = title;
        this.songs = new ArrayList<>();
    }

    // Getters
    public String getTitle() {
        return title;
    }
    public ArrayList<Song> getSongs() {
        return songs;
    }
    public int getSongsCount() {
        return songs.size();
    }
    public Song getSong(int number, Result result) {
        if (number - 1 < songs.size()) {
            return songs.get(number);
        } else {
            result.setFail("Invalid song number");
            return null;
        }
    }

    // Helpers
    public Song findSong(String title, Result result) {
//        for ( int i = 0; i < songs.size(); i++) {
//            if (songs.get(i).getTitle().equals(title)) {
//                return songs.get(i);
//            }
//        }
//        return null;
        for ( Song checkedSong: this.songs ) {
            if ( checkedSong.getTitle().equals( title ) ) return checkedSong;
        }
        return null;
    }
    public Result addSong(Song song, Result result) {
        if ( title == "" ) {
            result.setFail("Song title is empty");
            return result;
        }
        if ( song.getDurationMinutes() < 0 || song.getDurationSeconds() < 0 ) {
            result.setFail("Duration is invalid");
            return result;
        }
        if (findSong( song.getTitle(), result) != null ) {
            result.setFail("Song " + song.getTitle() + " is already on album " + title);
            return result;
        }
        songs.add(song);
        result.setSucceed("Song " + song.getTitle() + " added to " + title);
        return result;
    }



    @Override
    public String toString() {
        String toString = "Album : " + title + "";
        int i = 0;
        while (i < songs.size()) {
            toString += "\n\t " + (i + 1)  + " : " + songs.get(i).getTitle();
            i++;
        }
        return toString;

    }
}
