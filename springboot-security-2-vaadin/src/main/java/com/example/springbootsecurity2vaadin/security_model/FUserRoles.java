package com.example.springbootsecurity2vaadin.security_model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "fuser_roles")
public class FUserRoles {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID=0;

    
    private String roleID = Role.GUEST; //as default

    @ManyToOne
    @JoinColumn(name = "fuserBean", referencedColumnName = "ID")
    private FUser fuserBean;

   

    @Override
    public String toString() {
        return "Todo [description=" + roleID + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = prime * result + ((fuserBean == null) ? 0 : fuserBean.hashCode());
        result = prime * result + ((roleID == null) ? 0 : roleID.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (!super.equals(obj))
            return false;
        if (getClass() != obj.getClass())
            return false;
        FUserRoles other = (FUserRoles) obj;
        if (fuserBean == null) {
            if (other.fuserBean != null)
                return false;
        } else if (!fuserBean.equals(other.fuserBean))
            return false;
        if (roleID == null) {
            if (other.roleID != null)
                return false;
        } else if (!roleID.equals(other.roleID))
            return false;
        return true;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    public FUser getFuserBean() {
        return fuserBean;
    }

    public void setFuserBean(FUser fuserBean) {
        this.fuserBean = fuserBean;
    }

    


}