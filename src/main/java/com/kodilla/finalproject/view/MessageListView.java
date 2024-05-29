package com.kodilla.finalproject.view;

import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import com.vaadin.flow.router.PageTitle;

@Route(value = "messages")
@PageTitle("Messages")
public class MessageListView extends VerticalLayout {

    public MessageListView() {
        // Tutaj dodajemy komponenty, które chcemy wyświetlić w widoku
        add("Lista wiadomości:");
        add("1. Wiadomość 1");
        add("2. Wiadomość 2");
        add("3. Wiadomość 3");
    }
}