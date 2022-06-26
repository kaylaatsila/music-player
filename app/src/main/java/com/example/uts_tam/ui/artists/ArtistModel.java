package com.example.uts_tam.ui.artists;

import java.io.Serializable;

public class ArtistModel implements Serializable {
    String path, id, artist;

    public ArtistModel(String artist) {
        this.artist = artist;
    }

    public ArtistModel(String path, String id, String artist) {
        this.path = path;
        this.id = id;
        this.artist = artist;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

