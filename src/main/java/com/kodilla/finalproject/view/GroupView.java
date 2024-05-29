package com.kodilla.finalproject.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route("groups")
public class GroupView extends VerticalLayout {

    private final RestTemplate restTemplate;

    private Button addGroupButton;
    private Button deleteGroupButton;
    private Button selectGroupButton;

    public GroupView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        // Inicjalizacja przycisków operacji na grupach
        addGroupButton = new Button("Add Group");
        deleteGroupButton = new Button("Delete Group");
        selectGroupButton = new Button("Select Group");

        // Dodajemy obsługę przycisków
        addGroupButton.addClickListener(event -> {
            TextField groupNameField = new TextField("Enter group name:");
            Button confirmButton = new Button("Confirm");

            confirmButton.addClickListener(confirmEvent -> {
                String groupName = groupNameField.getValue();
                // Tutaj dodaj logikę dodawania nowej grupy
                // np. restTemplate.postForObject("http://localhost:8080/api/groups", groupName, String.class);
                groupNameField.clear();
                Notification.show("Group added: " + groupName);
            });

            add(groupNameField, confirmButton);
        });

        deleteGroupButton.addClickListener(event -> {
            TextField groupIdField = new TextField("Enter group ID:");
            Button confirmButton = new Button("Confirm");

            confirmButton.addClickListener(confirmEvent -> {
                Long groupId = Long.parseLong(groupIdField.getValue());
                // Tutaj dodaj logikę usuwania grupy
                // np. restTemplate.delete("http://localhost:8080/api/groups/" + groupId);
                groupIdField.clear();
                Notification.show("Group deleted: " + groupId);
            });

            add(groupIdField, confirmButton);
        });

        selectGroupButton.addClickListener(event -> {
            // Tutaj dodaj logikę pobierania listy dostępnych grup i wyświetlenia ich w widoku
            Notification.show("Select Group clicked");
        });

        // Dodajemy przyciski do layoutu
        add(addGroupButton, deleteGroupButton, selectGroupButton);
    }
}
