package com.example.springbootsecurity4vaadin.SecurityConfig;

import com.example.springbootsecurity4vaadin.views.main.MainView;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.polymertemplate.PolymerTemplate;
import com.vaadin.flow.router.*;
import com.vaadin.flow.templatemodel.TemplateModel;

import java.nio.file.AccessDeniedException;

import javax.servlet.http.HttpServletResponse;

@Tag("access-denied-view")
// @JsModule("./src/views/errors/access-denied-view.js")
//@ParentLayout(MainView.class) //Minta sesuatu
@Route
public class AccessDeniedView extends PolymerTemplate<TemplateModel> implements HasErrorParameter<AccessDeniedException> {

	@Override
	public int setErrorParameter(BeforeEnterEvent beforeEnterEvent, ErrorParameter<AccessDeniedException> errorParameter) {
		return HttpServletResponse.SC_FORBIDDEN;
	}
}
