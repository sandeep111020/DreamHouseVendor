package com.example.dreamhousevendor.Models;

public class MaterialModel {

    String materialname, total, balance;
    public MaterialModel(){

    }

    public String getMaterialname() {
        return materialname;
    }

    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public MaterialModel(String materialname, String total, String balance){
        this.materialname=materialname;
        this.total=total;
        this.balance=balance;
    }
}
