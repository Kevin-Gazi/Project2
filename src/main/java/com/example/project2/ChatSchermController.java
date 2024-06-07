package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.Node;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChatSchermController extends ResponseManager {
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

    private String taal = "Nederlands";
private ISendMessage antwoordGenerator = new AiComponent();

    private String[] AntwoordenNederlands = {
            "We zijn momenteel offline.",
            "Sorry, ik kan nu niet antwoorden.",
            "De service is momenteel niet beschikbaar.",
            "We zijn momenteel bezig met onderhoud.",
            "Ik ben momenteel niet bereikbaar."
    };

    private String[] AntwoordenEngels = {
            "We are currently offline.",
            "Sorry, I can't respond right now.",
            "The service is currently unavailable.",
            "We are currently undergoing maintenance.",
            "I am currently not reachable."
    };

    private Random random = new Random();

    private List<TabData> tabsData = new ArrayList<>();

    private String getRandomResponse(String[] responses) {
        int index = random.nextInt(responses.length);
        return responses[index];
    }

    public void setGebruiker(Gebruiker gebruiker) {
        this.gebruiker = gebruiker;
    }

    @FXML
    public void initialize() {
        if (!tabsData.isEmpty()) {
            restoreTabs();
        }
    }

    public void sendChat1(ActionEvent event) {

        long startTime = System.currentTimeMillis();

        chatArea1.appendText(gebruiker.getGebruikersnaam() + ": " + chatInput1.getText() + "\n");
        if (gebruiker == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Gebruiker is niet ingesteld.");
            alert.show();
            return;
        }

        String aiResponse;
        if (taal.equals("Nederlands")) {
            aiResponse = antwoordGenerator.getAntwoordNederlands();
        } else {
            aiResponse = antwoordGenerator.getAntwoordEngels();
        }
        chatArea1.appendText("AI: " + aiResponse + "\n");

        long endTime = System.currentTimeMillis();
        long responseTime = endTime - startTime;

        notifyObservers(responseTime);
    }

    public void addNewTab(ActionEvent event) {
        showAddChatDialog();
    }

    private void showAddChatDialog() {
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
            chatArea.appendText(gebruiker.getGebruikersnaam() + ": " + chatInput.getText() + "\n");
            chatInput.clear();

            // AI Response
            String aiResponse;
            if (taal.equals("Nederlands")) {
                aiResponse = antwoordGenerator.getAntwoordNederlands();
            } else {
                aiResponse = antwoordGenerator.getAntwoordEngels();
            }
            chatArea.appendText("AI: " + aiResponse + "\n");
        });

        AnchorPane content = new AnchorPane();
        content.getChildren().addAll(chatArea, chatInput, sendButton);
        AnchorPane.setTopAnchor(chatArea, 14.0);
        AnchorPane.setLeftAnchor(chatArea, 14.0);
        AnchorPane.setRightAnchor(chatArea, 14.0);
        AnchorPane.setBottomAnchor(chatInput, 14.0);
        AnchorPane.setLeftAnchor(chatInput, 14.0);
        AnchorPane.setRightAnchor(chatInput, 100.0);
        AnchorPane.setBottomAnchor(sendButton, 14.0);
        AnchorPane.setRightAnchor(sendButton, 14.0);

        newTab.setContent(content);

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
        Stage dialog = new Stage();
        dialog.initModality(Modality.APPLICATION_MODAL);
        dialog.setTitle("Wijzig onderwerp");

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

    private void saveTabs() {
        tabsData.clear();
        for (Tab tab : tabPane.getTabs()) {
            AnchorPane content = (AnchorPane) tab.getContent();
            TextArea chatArea = (TextArea) content.lookup(".text-area");
            TextField chatInput = (TextField) content.lookup(".text-field");
            String chatContent = chatArea.getText();
            String chatInputText = chatInput.getText();
            tabsData.add(new TabData(tab.getText(), chatContent, chatInputText));
        }
    }

    private void restoreTabs() {
        tabPane.getTabs().clear();
        for (TabData tabData : tabsData) {
            Tab newTab = new Tab(tabData.getTabName());

            TextArea chatArea = new TextArea(tabData.getChatAreaText());
            chatArea.setPrefHeight(400);
            chatArea.setPrefWidth(650);

            TextField chatInput = new TextField(tabData.getChatInputText());
            chatInput.setPrefWidth(550);

            Button sendButton = new Button("Stuur");
            sendButton.setOnAction(e -> {
                chatArea.appendText(gebruiker.getGebruikersnaam() + ": " + chatInput.getText() + "\n");
                chatInput.clear();

                String aiResponse;
                if (taal.equals("Nederlands")) {
                    aiResponse = getRandomResponse(AntwoordenNederlands);
                } else {
                    aiResponse = getRandomResponse(AntwoordenEngels);
                }
                chatArea.appendText("AI: " + aiResponse + "\n");
            });

            AnchorPane content = new AnchorPane();
            content.getChildren().addAll(chatArea, chatInput, sendButton);
            AnchorPane.setTopAnchor(chatArea, 14.0);
            AnchorPane.setLeftAnchor(chatArea, 14.0);
            AnchorPane.setRightAnchor(chatArea, 14.0);
            AnchorPane.setBottomAnchor(chatInput, 14.0);
            AnchorPane.setLeftAnchor(chatInput, 14.0);
            AnchorPane.setRightAnchor(chatInput, 100.0);
            AnchorPane.setBottomAnchor(sendButton, 14.0);
            AnchorPane.setRightAnchor(sendButton, 14.0);

            newTab.setContent(content);

            addContextMenuToTab(newTab);

            tabPane.getTabs().add(newTab);
        }
    }

    public void switchScene(ActionEvent event) throws IOException {
        saveTabs();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Instellingen.fxml"));
        root = loader.load();

        Instellingen controller = loader.getController();
        controller.setGebruiker2(gebruiker);

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }

    @FXML
    public void switchLanguageToDutch() {
        taal = "Nederlands";
    }

    @FXML
    public void switchLanguageToEnglish() {
        taal = "Engels";
    }

    @Override
    protected void notifyObservers(long responseTime) {
        for (Observer observer : observers) {
            observer.update(responseTime);
        }
    }
}
