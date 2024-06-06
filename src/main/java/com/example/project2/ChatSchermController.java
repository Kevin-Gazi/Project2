package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import java.io.IOException;

public class ChatSchermController {
    @FXML
    private TabPane tabPane;
    @FXML
    private TextField chatNameInput;
    @FXML
    private TextArea chatArea1;
    @FXML
    private TextField chatInput1;
    private Stage stage;
    private Button instellingenbutton;
    private Parent root;
    private Gebruiker gebruiker;

    public void setGebruiker (Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }
    public void sendChat1(ActionEvent event) {
        chatArea1.appendText("Gebruiker: " + chatInput1.getText() + "\n");
        chatInput1.clear();
    }

    public void addNewTab(ActionEvent event) {
        showAddChatDialog();
    }

    private void showAddChatDialog() {
        // Create the dialog
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Nieuwe Chat");

        TextField chatNameField = new TextField();
        chatNameField.setPromptText("Onderwerp");

        Button createButton = new Button("Maak nieuwe chat aan");
        createButton.setOnAction(e -> {
            String chatName = chatNameField.getText();
            if (chatName.isEmpty()) {
                chatName = "Chat " + (tabPane.getTabs().size() + 1);
            }
            createNewTab(chatName);
            dialog.close();
        });

        VBox vbox = new VBox(10, chatNameField, createButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    private void createNewTab(String chatName) {
        Tab newTab = new Tab(chatName);

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
        AnchorPane.setRightAnchor(chatInput, 100.0);  // Adjust to avoid overlapping with sendButton
        AnchorPane.setBottomAnchor(sendButton, 14.0);
        AnchorPane.setRightAnchor(sendButton, 14.0);

        newTab.setContent(content);

        // Add the context menu to the tab
        addContextMenuToTab(newTab);

        tabPane.getTabs().add(newTab);
    }

    private void addContextMenuToTab(Tab tab) {
        ContextMenu contextMenu = new ContextMenu();

        MenuItem removeItem = new MenuItem("Verwijder chat");
        removeItem.setOnAction(e -> tabPane.getTabs().remove(tab));

        MenuItem renameItem = new MenuItem("Wijzig onderwerp");
        renameItem.setOnAction(e -> showRenameDialog(tab));

        contextMenu.getItems().addAll(renameItem, removeItem);

        tab.setContextMenu(contextMenu);
    }

    private void showRenameDialog(Tab tab) {
        // Create the dialog
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Wijzig onderwerp");

        // Create input field
        TextField chatNameField = new TextField(tab.getText());
        chatNameField.setPromptText("Nieuw onderwerp");

        Button renameButton = new Button("Wijzig");
        renameButton.setOnAction(e -> {
            tab.setText(chatNameField.getText());
            dialog.close();
        });

        VBox vbox = new VBox(10, chatNameField, renameButton);
        vbox.setPadding(new Insets(10));

        Scene scene = new Scene(vbox);
        dialog.setScene(scene);
        dialog.showAndWait();
    }

    public void switchScene (ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Instellingen.fxml"));
        root = loader.load();

        Instellingen controller = loader.getController();
        controller.setGebruiker2(gebruiker);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene((Parent) root));
        stage.show();
    }
}