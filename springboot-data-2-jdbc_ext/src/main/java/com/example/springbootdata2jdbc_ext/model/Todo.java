package com.example.springbootdata2jdbc_ext.model;

import java.time.LocalDate;

public class Todo {

    private int ID = 0;

    private String description = "";
    private LocalDate dateFrom;
    private LocalDate dateTo;

    private Person personBean;

    
    public int getID() {
        return ID;
    }

    public void setID(int iD) {
        ID = iD;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * @return Person return the personBean
     */
    public Person getPersonBean() {
        return personBean;
    }

    /**
     * @param personBean the personBean to set
     */
    public void setPersonBean(Person personBean) {
        this.personBean = personBean;
    }


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
        Todo other = (Todo) obj;
        if (ID != other.ID)
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Todo [description=" + description + "]";
    }

    



}