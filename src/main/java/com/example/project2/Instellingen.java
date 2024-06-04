package com.example.project2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import java.net.URL;
import java.util.ResourceBundle;

public class Instellingen implements Initializable{

    @FXML
    private Label myLabel;
    @FXML
    private ChoiceBox<String> myChoiceBox;

    private String[] taal = {"Dutch/Nederlands", "English/Engels"};

    public void initialize (URL arg0, ResourceBundle arg1) {

        myChoiceBox.getItems().addAll(taal);
        myChoiceBox.setOnAction(this::getTaal);
    }

    private void getTaal(ActionEvent event) {

        String myTaal = myChoiceBox.getValue();
        myLabel.setText(myTaal);
    }

}
