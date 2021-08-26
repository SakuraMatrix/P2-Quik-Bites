package com.github.JonathanAGomez.drivers.domain;

public class Driver {

    private int id;
    private String name;
    //private double latitude;
    //private double longitude;

    public Driver(){

    }

    public Driver(int id, String name){
        this.id = id;
        this.name = name;
    }

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    //public double getLatitude(){return this.latitude;}
    //public void setLatitude(double latitude){this.latitude = latitude;}

    //public double getLongitude(){return  this.longitude;}
    //public void setLongitude(double longitude){this.longitude = longitude;}
}