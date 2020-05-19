package com.example.springbootsecurity2vaadin.SecurityConfigUI;

public class AccessDeniedException extends RuntimeException {
	public AccessDeniedException() {
	}

	public AccessDeniedException(String message) {
		super(message);
	}
}
