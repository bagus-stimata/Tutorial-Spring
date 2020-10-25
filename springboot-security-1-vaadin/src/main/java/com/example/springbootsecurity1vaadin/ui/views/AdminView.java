package com.example.springbootsecurity1vaadin.ui.views;

import com.example.springbootsecurity1vaadin.security_repository.UsersJPARepository;
import com.example.springbootsecurity1vaadin.security_model.FUser;
import com.example.springbootsecurity1vaadin.security_model.Role;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

@Route("admin-view")
@Secured(Role.ADMIN)
//@SpringComponent //Tanpa ini bisa jika bawah sudah autowire
public class AdminView extends VerticalLayout {

    private UsersJPARepository userRepository;

    /*
    KETIKA AUTO WIRE MAKA OTOMATIS KAN DIJALANKAN CONSTRUCTORNYA
    INI NAMANYA DENDENDCY INJECTION
     */
    @Autowired
    public AdminView(UsersJPARepository userRepository) {
        Label label = new Label("Page Admin");
        add(label);

        this.userRepository = userRepository;

       List<FUser> list = userRepository.findAll();
       for (FUser userBean: list) {
           Label labelUser = new Label(userBean.getFullName());
           add(labelUser);
       }

    }

}
