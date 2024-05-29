package com.kodilla.finalproject.view;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import org.springframework.web.client.RestTemplate;

@Route("message")
public class MessageView extends VerticalLayout {

    private final RestTemplate restTemplate;

    private TextField recipientField;
    private TextField contentField;
    private Button sendButton;

    public MessageView(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

        recipientField = new TextField("Recipient ID:");
        contentField = new TextField("Message content:");
        sendButton = new Button("Send");

        sendButton.addClickListener(event -> {
            Long recipientId = Long.parseLong(recipientField.getValue());
            String content = contentField.getValue();
            // Tutaj dodaj logikę wysyłania wiadomości
            // np. restTemplate.postForObject("http://localhost:8080/api/messages/private", new Message(content, senderId, recipientId), String.class);
            recipientField.clear();
            contentField.clear();
            Notification.show("Message sent");
        });

        add(recipientField, contentField, sendButton);
    }
}
