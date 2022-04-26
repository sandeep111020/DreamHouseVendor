package com.example.dreamhousevendor.Models;

public class Vendoritemmodel {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getImg() {
        return img;
    }

    public String getLatlo() {
        return latlo;
    }

    public void setLatlo(String latlo) {
        this.latlo = latlo;
    }

    public void setImg(String img) {
        this.img = img;
    }

    String name,number, address, title,desc,img,latlo;
    public Vendoritemmodel(){

    }
    public Vendoritemmodel(String name, String address,String number,String title,String desc,String img,String latlo){
        this.address=address;
        this.name=name;
        this.number=number;
        this.title=title;
        this.desc=desc;
        this.latlo=latlo;
        this.img=img;

    }
}
