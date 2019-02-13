package com.masterclass;

import java.util.ArrayList;

public class Collection {
    private ArrayList<Album> albums = new ArrayList<>();

    public Album addAlbum(Album album, Result result) {
        albums.add(album);
        result.setSucceed("Album " + album.getTitle() + " added to your collection");
        return album;
    }
    public ArrayList<Album> getAlbums() {
        return albums;
    }
    public int getAlbumCount() {
        return albums.size();
    }
}
