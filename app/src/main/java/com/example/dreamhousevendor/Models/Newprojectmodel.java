package com.example.dreamhousevendor.Models;

public class Newprojectmodel {
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    String empid,name,location,dimension, budget,type;
    public Newprojectmodel() {

    }
    public Newprojectmodel(String empid, String name, String location, String dimension, String budget, String type){
        this.name= name;
        this.empid=empid;
        this.location=location;
        this.dimension=dimension;
        this.budget=budget;
        this.type=type;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }


}
