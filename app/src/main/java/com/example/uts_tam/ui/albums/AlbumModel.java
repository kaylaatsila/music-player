package com.example.uts_tam.ui.albums;

import java.io.Serializable;

public class AlbumModel implements Serializable {
    int album_art;
    String album, artist;

    public AlbumModel(int album_art, String album, String artist) {
        this.album_art = album_art;
        this.album = album;
        this.artist = artist;
    }

    public int getAlbum_art() {
        return album_art;
    }

    public void setAlbum_art(int album_art) {
        this.album_art = album_art;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
}
