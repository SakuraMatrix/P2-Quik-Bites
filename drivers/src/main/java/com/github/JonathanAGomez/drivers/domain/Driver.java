package com.github.JonathanAGomez.drivers.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("driverstable")
public class Driver {

    @PrimaryKey
    private int driver_id;
    private String driver_name;
    //No longer used
    //private String location;
    //private String cust_location;
    //private String rest_location;

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

    //No longer used
    //public String getLocation(){return location;}
    //public void setLocation(String location){this.location = location;}

    //public String getCust_location(){return driver_name;}
    //public void setCust_location(String cust_location){this.cust_location = cust_location;}

    //public String getRest_location(){return driver_name;}
    //public void setRest_location(String rest_location){this.rest_location = rest_location;}
}