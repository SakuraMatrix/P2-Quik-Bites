package com.github.lawdcoder.restaurants.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Objects;

@Table("restaurant")
public class restaurant {
    @PrimaryKey
    private int restaurantId;
    private String name;
    private String location;

    public restaurant(int restaurantId, String name, String location)
    {
        this.restaurantId=restaurantId;
        this.location=location;
        this.name=name;
        ;

    }
    public restaurant()
    {

    }
    public String getName() {
        return name;
    }
    public int getRestaurantId() {
        return restaurantId;
    }
    public String getLocation() {
        return location;
    }
    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString()
    {
        return "restaurant{" +"resturantId=" + restaurantId+ ",location="
                +location+ " }";
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        restaurant that = (restaurant) o;
        return restaurantId == that.restaurantId  && Objects.equals(name, that.name)
                && Objects.equals(location, that.location);

    }

    @Override
    public int hashCode() {
        return Objects.hash(restaurantId, name,  location);
    }
}
