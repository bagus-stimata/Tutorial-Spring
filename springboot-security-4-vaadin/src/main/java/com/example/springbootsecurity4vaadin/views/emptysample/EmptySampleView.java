package com.example.springbootsecurity4vaadin.views.emptysample;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.templatemodel.TemplateModel;
import com.example.springbootsecurity4vaadin.views.main.MainView;

import com.example.springbootsecurity4vaadin.views.emptysample.EmptySampleView.EmptySampleViewModel;

@Route(value = "empty-sample", layout = MainView.class)
@PageTitle("EmptySample")
@JsModule("./src/views/emptysample/empty-sample-view.js")
@Tag("empty-sample-view")
public class EmptySampleView extends PolymerTemplate<EmptySampleViewModel> {

    // This is the Java companion file of a design
    // You can find the design file in /frontend/src/views/src/views/emptysample/empty-sample-view.js
    // The design can be easily edited by using Vaadin Designer (vaadin.com/designer)

    public static interface EmptySampleViewModel extends TemplateModel {
    }

    public EmptySampleView() {
    }
}
