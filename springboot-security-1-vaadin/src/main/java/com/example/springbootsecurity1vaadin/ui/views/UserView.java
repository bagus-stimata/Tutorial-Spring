package com.example.springbootsecurity1vaadin.ui.views;

import com.example.springbootsecurity1vaadin.model.Role;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

@Route("user-view")
@Secured({Role.USER, Role.USER})
public class UserView extends VerticalLayout {
    @Autowired
    public UserView() {
        Label label = new Label("User View");
        add(label);
    }
}
