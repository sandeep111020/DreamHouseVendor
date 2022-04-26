package com.example.dreamhousevendor.Models;

public class TestModel {
    String rate,name,url;

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }



    public TestModel(){

    }
    public  TestModel(String name,  String rate,String url){
        this.name=name;
        this.rate=rate;
        this.url=url;
    }
}
