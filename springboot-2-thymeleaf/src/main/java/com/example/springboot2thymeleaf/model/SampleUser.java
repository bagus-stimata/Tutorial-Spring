package com.example.springboot2thymeleaf.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SampleUser {

    private int id;


    private EnumRole[] enumRoles;

    //Transient
    private String[] roles;


    private List<SampleUserRole> sampleUserRoles = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public EnumRole[] getEnumRoles() {
        return enumRoles;
    }

    public void setEnumRoles(EnumRole[] enumRoles) {
        this.enumRoles = enumRoles;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }

    public List<SampleUserRole> getSampleUserRoles() {
        return sampleUserRoles;
    }

    public void setSampleUserRoles(List<SampleUserRole> sampleUserRoles) {
        this.sampleUserRoles = sampleUserRoles;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Arrays.hashCode(enumRoles);
        result = prime * result + id;
        result = prime * result + Arrays.hashCode(roles);
        result = prime * result + ((sampleUserRoles == null) ? 0 : sampleUserRoles.hashCode());
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
        SampleUser other = (SampleUser) obj;
        if (!Arrays.equals(enumRoles, other.enumRoles))
            return false;
        if (id != other.id)
            return false;
        if (!Arrays.equals(roles, other.roles))
            return false;
        if (sampleUserRoles == null) {
            if (other.sampleUserRoles != null)
                return false;
        } else if (!sampleUserRoles.equals(other.sampleUserRoles))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SampleUser [enumRoles=" + Arrays.toString(enumRoles) + ", roles=" + Arrays.toString(roles)
                + ", sampleUserRoles=" + sampleUserRoles + "]";
    }



  


    
}
