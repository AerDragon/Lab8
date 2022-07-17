package com.labs.lab8fx;

import collectionUsage.Client;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import util.Window;

import java.io.IOException;

public class App extends Application {
    @Override
    public void start(Stage stage) {
        Window.setStage(stage);
        try {
            Window.setScene("login", "Login");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Window.setMinDimensions(1300, 700);
        Window.show();
        Client.start();


    }

    public static void main(String[] args) {
        launch();
    }
}