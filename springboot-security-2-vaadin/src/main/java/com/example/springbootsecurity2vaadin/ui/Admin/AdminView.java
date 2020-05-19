package com.example.springbootsecurity2vaadin.ui.Admin;

import com.example.springbootsecurity2vaadin.model.Role;
import com.example.springbootsecurity2vaadin.ui.MainLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;

/**
 * @PreAutorize tidak bisa digunakan untuk View Vaadin karena mempunyai konsep security yang hampir berbeda
 * dia berpasangan dengan
 * @EnableGlobalMethodSecurity(prePostEnabled = true) 
 */
// @PreAuthorize("hasRole('ADMIN')") 

@Secured(Role.ADMIN)
@Route(value = "admin-view", layout = MainLayout.class)
public class AdminView extends VerticalLayout {
    
   
    private static final long serialVersionUID = 1L;

    public AdminView() {
        add(new Label("Admin View"));
        test();
    }

    // @PreAuthorize("hasRole('" + Role.USER + "')")
    public void test(){
        add(new Label("Tambahan Jika  oke untuk test: @PreAutorize"));
    }
}