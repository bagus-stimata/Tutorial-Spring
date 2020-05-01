package com.example.springbootdata1jdbc.model;

import java.util.List;

public class Person {

    private int ID=0;
    
    private String name = "";
    private String address = "";

    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ID;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Person other = (Person) obj;
        if (ID != other.ID)
            return false;
        return true;
    }
 
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Person(){}
    
    @Override
    public String toString() {
        return "Person [address=" + address + ", name=" + name + "]";
    }


  

}