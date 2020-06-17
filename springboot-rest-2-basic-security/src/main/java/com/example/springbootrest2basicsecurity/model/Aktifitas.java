package com.example.springbootrest2basicsecurity.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement
@Entity
@Table(name = "aktifitas")
public class Aktifitas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id = 0;

    private String description = "";

   
    // @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "todoBean", referencedColumnName = "ID")
    private Todo todoBean;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
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
        Aktifitas other = (Aktifitas) obj;
        if (id != other.id)
            return false;
        return true;
    }




 


    /**
     * @return int return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return String return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

   

    /**
     * @return Todo return the todoBean
     */
    public Todo getTodoBean() {
        return todoBean;
    }

    /**
     * @param todoBean the todoBean to set
     */
    public void setTodoBean(Todo todoBean) {
        this.todoBean = todoBean;
    }

    public Aktifitas(int id, String description, Todo todoBean) {
        this.id = id;
        this.description = description;
        this.todoBean = todoBean;
    }
    public Aktifitas() {
    }
}