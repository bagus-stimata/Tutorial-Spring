package com.example.springbootsecurity2vaadin.frontend_ui.User;

import com.example.springbootsecurity2vaadin.security_model.Role;
import com.example.springbootsecurity2vaadin.frontend_ui.MainLayout;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import org.springframework.security.access.annotation.Secured;
import org.vaadin.gatanaso.MultiselectComboBox;

/**
 * @PreAutorize tidak bisa digunakan untuk View Vaadin karena mempunyai konsep security yang hampir berbeda
 * dia berpasangan dengan
 * @EnableGlobalMethodSecurity(prePostEnabled = true) 
 */
// @PreAuthorize("hasRole('USER')")



@Secured(Role.USER)
@Route(value = "user-view", layout = MainLayout.class)
public class UserView extends VerticalLayout {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public UserView() {
        add(new Label("User View"));
        test();

        VerticalLayout messageLayout1 = new VerticalLayout();
        messageLayout1.add(new Label("Hello Baris Pertama"));
        messageLayout1.add(new Label("Hello Baris Kedua"));

        add(messageLayout1);

        VerticalLayout messageLayout = new VerticalLayout();
        messageLayout.add(new Label("Hello Baris Pertama"));
        messageLayout.add(new Label("Hello Baris Kedua"));


        // ConfirmDialog.createQuestion()
        //     .withCaption("System alert: Judul Bos")

        //     .withMessage(messageLayout)
        //     // .withMessage("Do you want to continue?, Do you want to continue?, \nDo you want to continue?")

        //     .withOkButton(() -> {
        //             System.out.println("YES. Implement logic here.");
        //         }, ButtonOption.caption("YES").icon(VaadinIcon.USER_CHECK))
        //     // .withCancelButton(ButtonOption.caption("NO"))
        //     .withCancelButton(() -> {
        //             System.out.println("No. Implement logic here.");
        //          }, ButtonOption.focus(), ButtonOption.caption("No"))
        //     .withWidthForAllButtons("150px")
        //     .open();

        // System.out.println("Dijalankan Kapan Ini?");


      

    }

    /**
     * Tidak akan berjalan pada Class Vaadin
     * Lihat pada role user tapi admin
     */    
    // @PreAuthorize("hasRole('" + Role.ADMIN + "')")
    public void test(){

        add(new Label("Tambahan Jika  oke untuk test: @PreAutorize"));

        // create a MultiselectComboBox of Users
        // MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox<>("Combo Box");            
        // multiselectComboBox.setLabel("Select users");
            
        // List<User> users = Arrays.asList(
        //     new User("Leanne Graham","leanne","leanne@demo.dev"),
        //     new User("Ervin Howell","ervin","ervin@demo.dev"),
        //     new User("Samantha Doe","samantha","samantha@demo.dev")
        // );

        // // by default uses `User.toString()` to generate item labels
        // multiselectComboBox.setItems(users);

        MultiselectComboBox<String> multiselectComboBox = new MultiselectComboBox<>("String Select");
        multiselectComboBox.setWidth("100%");
        multiselectComboBox.setLabel("Select items");
        multiselectComboBox.setPlaceholder("Choose...");
        multiselectComboBox.setItems("Item 1", "Item 2", "Item 3", "Item 4", "Item 5", "Item 6", "Item 7", "Item 8");
        
        multiselectComboBox.setRequired(true); // mark as mandatory
        multiselectComboBox.setErrorMessage("This field is required"); // set erro        
        multiselectComboBox.setClearButtonVisible(true);

        add(multiselectComboBox);

    }
    
}


// class User {
//     private String name;
//     private String username;
//     private String email;

//     public User(String name, String username, String email) {
//         this.username = username;
//         this.email = email;
//     }

//     // getters and setters intentionally omitted for brevity

//     @Override
//     public String toString() {
//         return name;
//     }
// }