package com.example.springboot2thymeleaf.model;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

public class Role {
	/**
	 * boleh tidak ditambahkan ROLE_ 
	 * misal ADMIN menjadi ROLE_ADMIN
	 * penambahan pada:
	 *  	authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	 * 	oleh karena untuk menyamakan dengan konsep @Secure("ROLE_ADMIN") 
	 *  vaadin maka sebaiknya ditambahkan
	 */
	public static final String USER 	= "ROLE_USER";
	public static final String ADMIN 	= "ROLE_ADMIN";
	public static final String GUEST 	= "ROLE_GUEST"; //as default
	public static final String USER1 	= "ROLE_USER1"; //as default
	public static final String USER2 	= "ROLE_USER2"; //as default

	

	private Role() {
	}

	public static String[] getAllRoles() {
		// return new String[] { USER, ADMIN, MNU_ADMIN_1 };
		String allRoles[] = ArrayUtils.addAll(getAuthRoles() );		
		return allRoles;
	}

	public static List getAllRolesList() {
		List<String> list = new ArrayList<>(); 
  
        // Iterate through the array 
        for (String t : getAllRoles()) { 
            list.add(t); 
		} 
		return list;
	}
	public static String[] getAuthRoles() {
		return new String[] { USER, ADMIN, GUEST, USER1, USER2 };
	}

}
