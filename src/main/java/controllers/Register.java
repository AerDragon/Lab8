package controllers;

import collectionUsage.CollectionManipulator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import util.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Register implements Initializable {

    @FXML
    private Button btnRegister;

    @FXML
    private TextField fldLogin;

    @FXML
    private PasswordField fldPassword;

    @FXML
    private Hyperlink login;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnRegister.setOnAction((e) -> {
            if (CollectionManipulator.register(fldLogin.getText(), fldPassword.getText())) {
                try {
                    Window.setScene("main", "Main");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Register error");
                a.show();
            }
        });

        login.setOnAction((e) -> {
            try {
                Window.setScene("login", "Login");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }
}
