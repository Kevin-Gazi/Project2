package com.example.project2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class ChatSchermController {
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField chatNameInput;
    @FXML
    private Button instellingenButton;
    private Stage stage;
    private Parent root;
    private Gebruiker gebruiker;

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    public void sendChat1(ActionEvent event) {
        TextArea chatArea = (TextArea) tabPane.getTabs().get(0).getContent().lookup("#chatArea1");
        TextField chatInput = (TextField) tabPane.getTabs().get(0).getContent().lookup("#chatInput1");
        chatArea.appendText("Gebruiker: " + chatInput.getText() + "\n");
        chatInput.clear();
    }

    public void addNewTab(ActionEvent event) {
        int tabCount = tabPane.getTabs().size();
        Tab newTab = new Tab("Chat " + (tabCount + 1));

        String chatName = chatNameInput.getText();
        if (chatName.isEmpty()) {
            chatName = "Chat " + (tabPane.getTabs().size() + 1);
        }
        newTab.setText(chatName);

        TextArea chatArea = new TextArea();
        chatArea.setPrefHeight(400);
        chatArea.setPrefWidth(650);

        TextField chatInput = new TextField();
        chatInput.setPrefWidth(550);

        Button sendButton = new Button("Stuur");
        sendButton.setOnAction(e -> {
            chatArea.appendText("Gebruiker: " + chatInput.getText() + "\n");
            chatInput.clear();
        });
        AnchorPane content = new AnchorPane();
        content.getChildren().addAll(chatArea, chatInput, sendButton);
        AnchorPane.setTopAnchor(chatArea, 14.0);
        AnchorPane.setLeftAnchor(chatArea, 14.0);
        AnchorPane.setRightAnchor(chatArea, 14.0);
        AnchorPane.setBottomAnchor(chatInput, 14.0);
        AnchorPane.setLeftAnchor(chatInput, 14.0);
        AnchorPane.setRightAnchor(chatInput, 14.0);
        AnchorPane.setBottomAnchor(sendButton, 14.0);
        AnchorPane.setRightAnchor(sendButton, 14.0);
        newTab.setContent(content);
        tabPane.getTabs().add(newTab);
    }

    public void switchScene (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Instellingen.fxml"));
        root = loader.load();

        Instellingen controller = loader.getController();
        controller.setGebruiker2(gebruiker); // De gebruiker instellen

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
