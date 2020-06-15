package com.example.springbootrest3security.model;


public class Role {
	/**
	 * boleh tidak ditambahkan ROLE_ 
	 * misal ADMIN menjadi ROLE_ADMIN
	 * penambahan pada:
	 *  	authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	 * 	oleh karena untuk menyamakan dengan konsep @Secure("ROLE_ADMIN") 
	 *  vaadin maka sebaiknya ditambahkan
	 */
	public static final String USER = "ROLE_USER";
	public static final String ADMIN = "ROLE_ADMIN";
	public static final String ACCOUNTING = "ROLE_ACCOUNTING";
	public static final String GUEST = "ROLE_GUEST"; //as default

	//Menu digunakan suatu penanda MNU
	public static final String MNU_ADMIN_1 = "ROLE_MNU_ADMIN_1";
	public static final String MNU_PROFILE_1 = "ROLE_MNU_PROFILE_1";
	public static final String MNU_PERSON_1 = "ROLE_MNU_PERSON_1";

	private Role() {
		// Static methods and fields only
	}

	public static String[] getAllRoles() {
		// return new String[] { USER, ADMIN, MNU_ADMIN_1 };

		int lenght = getAuthRoles().length + getMenuRoles().length;

		String result[] = new String[lenght];
		int pos = 0;
		for (String element: getAuthRoles()) {
			result[pos] = element;
			pos++;
		}
		for (String element: getMenuRoles()) {
			result[pos] = element;
			pos++;
		}
		

		return result;
	}

	public static String[] getAuthRoles() {
		return new String[] { USER, ADMIN, ACCOUNTING, GUEST };
	}
	public static String[] getMenuRoles() {
		return new String[] { MNU_ADMIN_1, MNU_PROFILE_1, MNU_PERSON_1};
	}

}
