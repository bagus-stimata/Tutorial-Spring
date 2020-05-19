package com.example.springbootsecurity1vaadin.ui.views;

import com.example.springbootsecurity1vaadin.model.Role;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;

@Route("barista-view")
@Secured({Role.USER, Role.USER})
public class BaristaView extends VerticalLayout {
    @Autowired
    public BaristaView() {
        Label label = new Label("Hello Barista!");
        add(label);
    }
}
