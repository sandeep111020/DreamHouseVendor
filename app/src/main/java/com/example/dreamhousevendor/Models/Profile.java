package com.example.dreamhousevendor.Models;

public class Profile {

    String name, number,email,type;
    public Profile(){

    }
    public Profile(String name, String number, String email, String type){
        this.name=name;
        this.number=number;
        this.email=email;
        this.type=type;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
