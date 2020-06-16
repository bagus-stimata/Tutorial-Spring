package com.example.springdata1thymeleaf.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
@Entity
@Table(name = "todo")
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID = 0;

    private String description = "";
     
    // private LocalDate dateFrom = LocalDate.now();
    // private LocalDate dateTo = LocalDate.now();

    // @JsonManagedReference //Tidak boleh diisi for xml
    @ManyToOne
    @JoinColumn(name = "personBean", referencedColumnName = "ID")
    private Person personBean;

    
    @JsonBackReference
    @OneToMany(mappedBy = "todoBean")
    private List<Aktifitas> todos;

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

    // public LocalDate getDateFrom() {
    //     return dateFrom;
    // }

    // public void setDateFrom(LocalDate dateFrom) {
    //     this.dateFrom = dateFrom;
    // }

    // public LocalDate getDateTo() {
    //     return dateTo;
    // }

    // public void setDateTo(LocalDate dateTo) {
    //     this.dateTo = dateTo;
    // }

    public Person getPersonBean() {
        return personBean;
    }

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

    



    /**
     * @return List<Aktifitas> return the todos
     */
    public List<Aktifitas> getTodos() {
        return todos;
    }

    /**
     * @param todos the todos to set
     */
    public void setTodos(List<Aktifitas> todos) {
        this.todos = todos;
    }

}