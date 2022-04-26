package com.example.dreamhousevendor.Models;

public class ImageuploadModel {
    String url,album;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public ImageuploadModel(){

    }
    public ImageuploadModel(String album,String url){
        this.album=album;
        this.url=url;

    }
}
