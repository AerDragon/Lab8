package controllers;

import collectionUsage.CollectionManipulator;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import util.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    @FXML
    private Button btnLogin;

    @FXML
    private TextField fldLogin;

    @FXML
    private PasswordField fldPassword;

    @FXML
    private Hyperlink register;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        btnLogin.setOnAction((e) -> {
            if (CollectionManipulator.login(fldLogin.getText(), fldPassword.getText())) {
                try {
                    Window.setScene("main", "Main");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                Alert a = new Alert(Alert.AlertType.ERROR);
                a.setContentText("Incorrect password");
                a.show();
            }
        });

        register.setOnAction((e) -> {
            try {
                Window.setScene("register", "Registration");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }
}
