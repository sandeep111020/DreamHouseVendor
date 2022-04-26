package com.example.dreamhousevendor.Models;

public class PaymentModel {

    String paymentname, paymentcost;
    public PaymentModel(){

    }

    public String getPaymentname() {
        return paymentname;
    }

    public void setPaymentname(String paymentname) {
        this.paymentname = paymentname;
    }

    public String getPaymentcost() {
        return paymentcost;
    }

    public void setPaymentcost(String paymentcost) {
        this.paymentcost = paymentcost;
    }

    public PaymentModel(String paymentname, String paymentcost){
        this.paymentcost=paymentcost;
        this.paymentname=paymentname;

    }
}
