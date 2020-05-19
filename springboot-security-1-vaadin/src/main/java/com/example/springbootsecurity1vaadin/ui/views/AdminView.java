package com.example.springbootsecurity1vaadin.ui.views;

import com.example.springbootsecurity1vaadin.jpa_repository.UsersRepository;
import com.example.springbootsecurity1vaadin.model.FUser;
import com.example.springbootsecurity1vaadin.model.Role;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

@Route("admin-view")
@Secured(Role.ADMIN)
//@SpringComponent //Tanpa ini bisa jika bawah sudah autowire
public class AdminView extends VerticalLayout {

    private UsersRepository userRepository;

    /*
    KETIKA AUTO WIRE MAKA OTOMATIS KAN DIJALANKAN CONSTRUCTORNYA
    INI NAMANYA DENDENDCY INJECTION
     */
    @Autowired
    public AdminView(UsersRepository userRepository) {
        Label label = new Label("Page Admin");
        add(label);

        this.userRepository = userRepository;

       List<FUser> list = userRepository.findAll();
       for (FUser userBean: list) {
           Label labelUser = new Label(userBean.getFirstName());
           add(labelUser);
       }

    }

}
