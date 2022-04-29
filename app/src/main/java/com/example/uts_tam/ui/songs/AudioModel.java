package com.example.uts_tam.ui.songs;

import java.io.Serializable;

public class AudioModel implements Serializable {
    String path;
    String duration;
    String title, artist, id, album, num_tracks, num_albums;

    public AudioModel(String path, String title, String artist, String duration) {
        this.path = path;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getNum_tracks() {
        return num_tracks;
    }

    public void setNum_tracks(String num_tracks) {
        this.num_tracks = num_tracks;
    }

    public String getNum_albums() {
        return num_albums;
    }

    public void setNum_albums(String num_albums) {
        this.num_albums = num_albums;
    }
}
