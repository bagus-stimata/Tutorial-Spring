package com.example.springbootsecurity1vaadin.SecurityConfigUI;

public class AccessDeniedException extends RuntimeException {
	public AccessDeniedException() {
	}

	public AccessDeniedException(String message) {
		super(message);
	}
}
