package controllers;

import collectionUsage.CollectionManipulator;
import data.*;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import util.Window;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class Add implements Initializable {

    @FXML
    private TextField aX;

    @FXML
    private TextField aY;

    @FXML
    private TextField aZ;

    @FXML
    private TextField annual;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnSave;

    @FXML
    private TextField emploees;

    @FXML
    private TextField fullName;

    @FXML
    private TextField name;

    @FXML
    private TextField street;

    @FXML
    private ChoiceBox<OrganizationType> type;

    @FXML
    private TextField x;

    @FXML
    private TextField y;

    @FXML
    private TextField zip;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnBack.setOnAction((e) -> {
            try {
                Window.setScene("main", "Main");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        btnSave.setOnAction((e) -> {
            try {

                CollectionManipulator.getOrganizations().add(new Organization(new Long(new Random().nextInt(10000)),
                        name.getText(),
                        new Coordinates(new Float(x.getText()),
                                new Float(y.getText())),
                        LocalDate.now(),
                        new Float(annual.getText()),
                        fullName.getText(),
                        new Long(emploees.getText()),
                        type.getValue(),
                        new Address(street.getText(),
                                zip.getText(),
                                new Location(new Double(aX.getText()),
                                        new Long(aY.getText()),
                                        new Long(aZ.getText()))),
                        CollectionManipulator.getLogin()));
                CollectionManipulator.save();
                Window.setScene("main", "Main");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        ObservableList en = FXCollections.observableArrayList(OrganizationType.COMMERCIAL, OrganizationType.GOVERNMENT, OrganizationType.OPEN_JOINT_STOCK_COMPANY);
        type.setItems(en);
    }
}