package com.example.springbootsecurity3extended.model;

import org.apache.commons.lang3.ArrayUtils;

public class Role {
	public static final String USER = "USER";
	// This role implicitly allows access to all views.
	public static final String ADMIN = "ADMIN";
	public static final String ACCOUNTING = "ACCOUNTING";
	public static final String GUEST = "GUEST"; //as default

	//Menu digunakan suatu penanda MNU
	public static final String MNU_ADMIN_1 = "MNU_ADMIN_1";
	public static final String MNU_PROFILE_1 = "MNU_PROFILE_1";
	public static final String MNU_PERSON_1 = "MNU_PERSON_1";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllRoles() {
		// return new String[] { USER, ADMIN, MNU_ADMIN_1 };
		String allRoles[] = ArrayUtils.addAll(getAuthRoles(), getMenuRoles());		
		return allRoles;
	}

	public static String[] getAuthRoles() {
		return new String[] { USER, ADMIN, ACCOUNTING, GUEST };
	}
	public static String[] getMenuRoles() {
		return new String[] { MNU_ADMIN_1, MNU_PROFILE_1, MNU_PERSON_1};
	}

}
