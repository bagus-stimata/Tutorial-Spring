package com.example.springbootsecurity3extended.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;
import javax.validation.constraints.*;


import java.util.List;
import java.util.Objects;

@Entity(name="fuser")
public class FUser {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="fuser_id_seq")
    // @SequenceGenerator(name="fuser_id_seq", sequenceName="fuser_id_seq", allocationSize=1)
    private int id=0;

	@NotEmpty
	@Email
	@Size(max = 255)	
	@Column(unique = true)
	private String email;

	@Size(max = 255)	
	@Column(unique = true)
	private String username;


	@NotNull
	@Size(min = 4, max = 255)
	private String password;

	@Transient
	private String passwordConfirm;


	
	@NotBlank
	@Size(max = 255)
	private String firstName;

	@NotBlank
	@Size(max = 255)
	private String lastName;

	// @NotBlank
	// @Size(max = 255)
	// private String role;

	private boolean locked = false;


    @OneToMany(mappedBy = "fuserBean")
	private List<FUserRoles> fuserRoles;
	
	@PrePersist
	@PreUpdate
	private void prepareData(){
		this.email = email == null ? null : email.toLowerCase();
	}



	
	public FUser() {
		// An empty constructor is needed for all beans
	}

	

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		if (!super.equals(o)) {
			return false;
		}
		FUser that = (FUser) o;
		return locked == that.locked &&
				Objects.equals(email, that.email) &&
				Objects.equals(firstName, that.firstName) &&
				Objects.equals(lastName, that.lastName) ;
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), email, firstName, lastName, locked);
	}

	public List<FUserRoles> getFuserRoles() {
		return fuserRoles;
	}

	public void setFuserRoles(List<FUserRoles> fuserRoles) {
		this.fuserRoles = fuserRoles;
	}

	public FUser(FUser users) {
		id = users.id;
		this.email = users.email;
		this.password = users.password;
		this.firstName = users.firstName;
		this.lastName = users.lastName;
		this.locked = users.locked;
		this.fuserRoles = users.fuserRoles;
	}

	

	

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

    /**
     * @return String return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
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

}
