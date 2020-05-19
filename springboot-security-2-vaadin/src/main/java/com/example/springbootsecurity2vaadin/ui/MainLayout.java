package com.example.springbootsecurity2vaadin.ui;

import com.example.springbootsecurity2vaadin.model.Role;
import com.example.springbootsecurity2vaadin.ui.Admin.AdminView;
import com.example.springbootsecurity2vaadin.ui.User.UserView;
import com.example.springbootsecurity2vaadin.ui.views.HomeView;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouterLink;

import org.springframework.security.access.annotation.Secured;

/**
 * Vaadin banyak perubahan dalam versinya
 * Lihat semuanya dipindahkan pada 
 *  "ListView.java"
 */
// @Route //artinya "mainlayout"
// @Route("/") //artinya "/"
// @Route("") //artinya "root"


// @Secured(Role.USER)
@CssImport("./styles/shared-styles.css")
public class MainLayout extends AppLayout {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createHeader() {
        H1 logo = new H1("Vaadin CRM");
        logo.addClassName("logo");

        Anchor logout = new Anchor("/logout", "Log out");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo, logout);
        header.addClassName("header");
        header.setWidth("100%");
        header.expand(logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);

        addToNavbar(header);
    }

    private void createDrawer() {

        // RouterLink listLink = new RouterLink("1. Home", HomeView.class);
        // listLink.setHighlightCondition(HighlightConditions.sameLocation());
        RouterLink listLink = new RouterLink();

        addToDrawer(new VerticalLayout( listLink, new RouterLink("Home", HomeView.class) ));
        addToDrawer(new VerticalLayout( listLink, new RouterLink("Admin", AdminView.class) ));
        addToDrawer(new VerticalLayout( listLink, new RouterLink("Users", UserView.class) ));
     
    }


}
