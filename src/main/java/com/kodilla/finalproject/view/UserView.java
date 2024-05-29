package com.kodilla.finalproject.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;

@Route("users")
public class UserView extends FormLayout {

    public UserView() {
        Button addUserButton = new Button("Add User");
        addUserButton.addClickListener(event -> {
            UserForm userForm = new UserForm();
            Dialog dialog = new Dialog();
            dialog.add(userForm);
            dialog.open();
        });

        add(addUserButton);
    }

    private class UserForm extends FormLayout {
        private final TextField usernameField = new TextField("Username");
        private final TextField emailField = new TextField("Email");
        private final Button saveButton = new Button("Save");

        public UserForm() {
            saveButton.addClickListener(event -> {
                // Logika zapisu użytkownika
                Notification.show("User added successfully");
                clearFields();
            });

            add(usernameField, emailField, saveButton);
        }

        private void clearFields() {
            usernameField.clear();
            emailField.clear();
        }
    }
}
