package com.example.project2;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Scanner;

public class Gesprek {
    private Stage stage;
    private Parent root;
    private int gesprekID;
    private String onderwerp;
    private Gebruiker gebruiker;
    private AiComponent aiComponent;
    Scanner scanner = new Scanner(System.in);


    public void nieuweGesprek(){
        System.out.println("Wat is het onderwerp van het gesprek?");
        onderwerp = scanner.nextLine();
        System.out.println("Gesprek gestart met onderwerp: " + onderwerp);
        Vragen vragen = new Vragen(aiComponent);
        vragen.vragenStellen();
    }

    public void ChatNaarInstellingen(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Instellingen.fxml"));
        root = loader.load();

        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
    }


}