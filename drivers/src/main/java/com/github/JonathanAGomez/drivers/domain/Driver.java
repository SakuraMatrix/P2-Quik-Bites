package com.github.JonathanAGomez.drivers.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("driverstable")
public class Driver {

    @PrimaryKey
    private int driver_id;
    private String driver_name;
    //private double latitude;
    //private double longitude;

    public Driver(){

    }

    public Driver(int id, String name){
        this.driver_id = id;
        this.driver_name = name;
    }

    public int getDriver_id(){return driver_id;}
    public void setDriver_id(int driver_id){this.driver_id = driver_id;}

    public String getDriver_name(){return driver_name;}
    public void setDriver_name(String driver_name){this.driver_name = driver_name;}

    //public double getLatitude(){return this.latitude;}
    //public void setLatitude(double latitude){this.latitude = latitude;}

    //public double getLongitude(){return  this.longitude;}
    //public void setLongitude(double longitude){this.longitude = longitude;}
}