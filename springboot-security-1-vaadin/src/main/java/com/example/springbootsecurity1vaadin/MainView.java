package com.example.springbootsecurity1vaadin;

import com.example.springbootsecurity1vaadin.SecurityConfig.SecurityUtils;
import com.example.springbootsecurity1vaadin.ui.views.AdminView;
import com.example.springbootsecurity1vaadin.ui.views.UserView;
import com.example.springbootsecurity1vaadin.ui.views.BaristaView;
import com.example.springbootsecurity1vaadin.ui.views.PublicView;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.dom.Element;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = true)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     */
    public MainView() {

        // Use TextField for standard text input

        // Use custom CSS classes to apply styling. This is defined in shared-styles.css.
        addClassName("centered-content");


        /*
         * GRANTED MENU
         */
        if (SecurityUtils.isAccessGranted(AdminView.class) ) { //Tidak bisa dipakai
            String route = UI.getCurrent().getRouter()
                    .getUrl(AdminView.class);
            Anchor link = new Anchor(route, "Menu Admin");
            add(link);
        }

        if (SecurityUtils.isAccessGranted(UserView.class)) {
            String route = UI.getCurrent().getRouter()
                    .getUrl(UserView.class);
            Anchor link = new Anchor(route, "Menu Baker");
            add(link);
        }
        if (SecurityUtils.isAccessGranted(BaristaView.class)) {
            String route = UI.getCurrent().getRouter()
                    .getUrl(BaristaView.class);
            Anchor link = new Anchor(route, "Menu Barista");
            add(link);
        }
        if (SecurityUtils.isAccessGranted(PublicView.class)) {
            String route = UI.getCurrent().getRouter()
                    .getUrl(PublicView.class);
            Anchor link = new Anchor(route, "Public Area");
            add(link);
        }

        // simple link to the logout endpoint provided by Spring Security
        Element logoutLink = ElementFactory.createAnchor("logout", "Logout");
        getElement().appendChild(logoutLink);

    }


}
