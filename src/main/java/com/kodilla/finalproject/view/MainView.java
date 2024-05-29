package com.kodilla.finalproject.view;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import java.util.ArrayList;
import java.util.List;

@Route("")
public class MainView extends VerticalLayout {

    public MainView() {
        // Tworzenie przycisków
        Button userViewButton = new Button("User View");
        Button groupViewButton = new Button("Group View");
        Button messageButton = new Button("Message View");
        Button availableUsersButton = new Button("Available Users");

        // Ustawianie kolorów przycisków
        userViewButton.getStyle().set("background-color", "#4CAF50").set("color", "white");
        groupViewButton.getStyle().set("background-color", "#008CBA").set("color", "white");
        messageButton.getStyle().set("background-color", "#f44336").set("color", "white");
        availableUsersButton.getStyle().set("background-color", "#555555").set("color", "white");

        // Przekierowywanie do odpowiednich widoków po kliknięciu przycisków
        userViewButton.addClickListener(event -> {
            userViewButton.getUI().ifPresent(ui -> ui.navigate("users"));
        });

        groupViewButton.addClickListener(event -> {
            groupViewButton.getUI().ifPresent(ui -> ui.navigate("groups"));
        });

        messageButton.addClickListener(event -> {
            getUI().ifPresent(ui -> ui.navigate("message"));
        });

        availableUsersButton.addClickListener(event -> {
            getUI().ifPresent(ui -> ui.navigate("available-users"));
        });

        // Ustawianie układu
        HorizontalLayout buttonsLayout = new HorizontalLayout(userViewButton, groupViewButton, messageButton, availableUsersButton);
        buttonsLayout.setSpacing(true);

        // Panel z listą użytkowników
        VerticalLayout userListLayout = new VerticalLayout();
        userListLayout.setWidth("300px");
        List<String> userList = generateUserList();
        for (String user : userList) {
            Label userLabel = new Label(user);
            userListLayout.add(userLabel);
        }
        Div usersPanel = new Div(new Label("Available Users"), userListLayout);
        usersPanel.getStyle().set("border", "1px solid #555555").set("padding", "10px");

        // Ustawianie komponentów na ekranie
        add(buttonsLayout, usersPanel);
    }

    // Metoda generująca listę przykładowych użytkowników
    private List<String> generateUserList() {
        List<String> userList = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            userList.add("User " + i);
        }
        return userList;
    }
}
