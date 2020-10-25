package com.example.springbootsecurity1vaadin.security_model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

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



	@Column(name = "full_name")
	private String fullName = "";

	@Column(name = "phone")
	private String phone = "";

	@Column(name = "notes")
	private String notes = "";


	@JsonIgnore
	@OneToMany(mappedBy = "fuserBean")
	private List<FUserRoles> fuserRoles;
	@JsonIgnore
	@Transient
	private List<String> tempRoles;

	// @NotBlank
	// @Size(max = 255)
	// private String role;

	private boolean locked = false;

	@Column(name = "created")
	private Date created = new Date();
	@Column(name = "lastmodified")
	private Date lastModified = new Date();
	@Column(name = "modified_by")
	private String modifiedBy = "";


	@PrePersist
	@PreUpdate
	private void prepareData(){
		this.email = email == null ? null : email.toLowerCase();
	}


	public FUser() {
		// An empty constructor is needed for all beans
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		FUser fUser = (FUser) o;

		return id == fUser.id;
	}

	@Override
	public int hashCode() {
		return id;
	}

	@Override
	public String toString() {
		return "FUser{" +
				"id=" + id +
				", email='" + email + '\'' +
				", username='" + username + '\'' +
				'}';
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<FUserRoles> getFuserRoles() {
		return fuserRoles;
	}

	public void setFuserRoles(List<FUserRoles> fuserRoles) {
		this.fuserRoles = fuserRoles;
	}

	public List<String> getTempRoles() {
		return tempRoles;
	}

	public void setTempRoles(List<String> tempRoles) {
		this.tempRoles = tempRoles;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
}
