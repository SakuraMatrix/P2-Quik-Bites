package com.github.JonathanAGomez.drivers.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("driverstable")
public class Driver {

    @PrimaryKey
    private int driver_id;
    private String driver_name;
    private String location;
    private String customer_Address;
    private String restaurant_Address;

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

    public String getLocation(){return location;}
    public void setLocation(String location){this.location = location;}

    public String getCustomer_Address(){return driver_name;}
    public void setCustomer_Address(String customer_Address){this.customer_Address = customer_Address;}

    public String getRestaurant_Address(){return driver_name;}
    public void setRestaurant_Address(String restaurant_Address){this.restaurant_Address = restaurant_Address;}
}