package com.example.springbootsecurity2vaadin.ui.views;

import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@Route("public_view")
//@Secured(Role.ADMIN) //Bisa diakses semua orang
public class PublicView extends VerticalLayout {
    @Autowired
    public PublicView() {
        Label label = new Label("Looks like you are PUblic view!");
        add(label);
    }

}
