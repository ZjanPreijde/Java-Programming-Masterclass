package com.masterclass;

import java.util.ArrayList;

public class Album {
    String title;
    SongList songList;

    // Constructor
    public Album(String title) {
        this.title = title;
        this.songList = new SongList();
    }

    // Getters
    public String getTitle() {
        return title;
    }

    // inner class
    private class SongList {
        private ArrayList<Song> songs;
        public SongList() {
            this.songs = new ArrayList <>(  );
        }
        public ArrayList<Song> getSongs() {
            return songs;
        }
        public Song getSong( int number, Result result ) {
            if (number - 1 < songs.size()) {
                return songs.get(number);
            } else {
                result.setFail("Invalid song number");
                return null;
            }
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

        private Song findSong( String title, Result result) {
            for ( Song checkedSong: this.songs ) {
                if ( checkedSong.getTitle().equals( title ) ) return checkedSong;
            }
            return null;
        }
        @Override
        public String toString() {
            String toString = "";
            int i = 0;
            while (i < songs.size()) {
                toString += "\n\t " + (i + 1)  + " : " + songs.get(i).getTitle();
                i++;
            }
            return toString;
        }
    }

    public ArrayList<Song> getSongs() {
        return songList.getSongs();
    }
    public int getSongsCount() {
        return songList.getSongs().size();
    }
    public Song getSong(int number, Result result) {
        return songList.getSong( number, result );
    }
    public Result addSong(Song song, Result result) {
        return songList.addSong( song, result );
    }



    @Override
    public String toString() {
        return "Album : " + title + songList.toString();

    }
}
