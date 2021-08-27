package com.github.lawdcoder.restaurants.domain;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import java.util.Objects;


import javax.swing.*;
import java.util.Objects;

@Table("menus")
public class menu {
    @PrimaryKey
    int menuId;
    String name;
    double price;
    public menu()
    {

    }
    public menu(int menuId, double price, String name)
    {
        this.menuId=menuId;
        this.name=name;
        this.price=price;
    }

    public menu(int incrementAndGet, int i, double parseDouble, String curryChicken) {
    }

    @Override
    public String toString()
    {
        return "menu{"+"menuId="+menuId+
                ",name='" +name+ '\''+",price="+price+'}';
    }
    @Override
    public boolean equals(Object o)
    {
        if(this ==o)return true;
        if(o==null || getClass()!=o.getClass())return false;
        menu menu=(menu)o;
        return menuId == menu.menuId && Double.compare(menu.price, price) == 0 && Objects.equals(name, menu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, name, price);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getMenuId() {
        return menuId;
    }
}
