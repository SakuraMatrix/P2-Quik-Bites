package com.github.dmagare.customers.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("customers")
public class Customer {
	
	@PrimaryKey
    private int customerID;
    private String firstName;
    private String lastName;
    private String customerAddress;
    private String phoneNumber;

    public Customer() {
    }

    public Customer(int customerID, String firstName, String lastName, String customerAddress, String phoneNumber) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerAddress = customerAddress;
        this.phoneNumber = phoneNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String GetFirstName() {
        return firstName;
    }

    public void setFirstName(String fName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setlName(String lName) {
        this.lastName = lastName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + customerID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

