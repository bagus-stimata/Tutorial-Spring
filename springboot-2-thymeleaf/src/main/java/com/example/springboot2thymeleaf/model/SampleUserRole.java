package com.example.springboot2thymeleaf.model;

import java.time.LocalDateTime;

import nonapi.io.github.classgraph.json.Id;



public class SampleUserRole {
    
    @Id
    private int id=0;
    
    private EnumRole enumRole;

    private SampleUser sampleUserBean;

    
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
     * @return EnumRole return the enumRole
     */
    public EnumRole getEnumRole() {
        return enumRole;
    }

    /**
     * @param enumRole the enumRole to set
     */
    public void setEnumRole(EnumRole enumRole) {
        this.enumRole = enumRole;
    }

    /**
     * @return SampleUser return the sampleUserBean
     */
    public SampleUser getSampleUserBean() {
        return sampleUserBean;
    }

    /**
     * @param sampleUserBean the sampleUserBean to set
     */
    public void setSampleUserBean(SampleUser sampleUserBean) {
        this.sampleUserBean = sampleUserBean;
    }

    @Override
    public String toString() {
        return "SampleUserRole [enumRole=" + enumRole + ", id=" + id + ", sampleUserBean=" + sampleUserBean + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((enumRole == null) ? 0 : enumRole.hashCode());
        result = prime * result + id;
        result = prime * result + ((sampleUserBean == null) ? 0 : sampleUserBean.hashCode());
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
        SampleUserRole other = (SampleUserRole) obj;
        if (enumRole != other.enumRole)
            return false;
        if (id != other.id)
            return false;
        if (sampleUserBean == null) {
            if (other.sampleUserBean != null)
                return false;
        } else if (!sampleUserBean.equals(other.sampleUserBean))
            return false;
        return true;
    }

    public String getIdAsString() {
        return String.valueOf(id);
		// return new Long(id).toString();
	}

}