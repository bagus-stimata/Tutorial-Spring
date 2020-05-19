package com.example.springbootsecurity2vaadin.ui.views;

import com.example.springbootsecurity2vaadin.ui.MainLayout;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;


@Route(value="", layout = MainLayout.class)
// @Route(value = "", layout = MainLayout.class) //Ini yang bikin jadi route tapi menempel pada routte utama
@PageTitle("Home | Vaadin CRM")
public class HomeView extends VerticalLayout {

    

    public HomeView(){
        setSizeFull();
        add(new Label("Home View | Unsecured Area"));
    }

    // public ListView(ContactService contactService,
    //                 CompanyService companyService) {

    //     this.contactService = contactService;
        // addClassName("list-view");
        // setSizeFull();
        // configureGrid();


        // form = new ContactForm(companyService.findAll());
        // form.addListener(ContactForm.SaveEvent.class, this::saveContact);
        // form.addListener(ContactForm.DeleteEvent.class, this::deleteContact);
        // form.addListener(ContactForm.CloseEvent.class, e -> closeEditor());

        // Div content = new Div(grid, form);
        // content.addClassName("content");
        // content.setSizeFull();

        // add(getToolBar(), content);
        // updateList();
        // closeEditor();
    // }

  
}
