package controllers;

import collectionUsage.CollectionManipulator;
import data.Address;
import data.Coordinates;
import data.Organization;
import data.OrganizationType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import util.Window;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class Main implements Initializable {

    @FXML
    private TableColumn<OrganizationProp, Float> X;

    @FXML
    private TableColumn<OrganizationProp, Float> Y;

    @FXML
    private TableColumn<OrganizationProp, Float> annual;

    @FXML
    private Button btnVisualise;

    @FXML
    private TableColumn<OrganizationProp, LocalDate> date;

    @FXML
    private TableColumn<OrganizationProp, Long> emploees;

    @FXML
    private TableColumn<OrganizationProp, String> fullName;

    @FXML
    private TableColumn<OrganizationProp, Long> id;

    @FXML
    private TableColumn<OrganizationProp, String> name;

    @FXML
    private TableColumn<OrganizationProp, String> owner;

    @FXML
    private TableColumn<OrganizationProp, String> street;

    @FXML
    private TableView<OrganizationProp> table;

    @FXML
    private Text textUser;

    @FXML
    private TableColumn<OrganizationProp, Double> tX;

    @FXML
    private TableColumn<OrganizationProp, Long> tY;

    @FXML
    private TableColumn<OrganizationProp, Long> tZ;

    @FXML
    private TableColumn<OrganizationProp, OrganizationType> type;

    @FXML
    private TableColumn<OrganizationProp, String> zip;


    public static ObservableList<OrganizationProp> orgs = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        textUser.setText(CollectionManipulator.getLogin());
        table.setPlaceholder(new Text("No organizations"));
        CollectionManipulator.load();

        X.setCellValueFactory((d) -> d.getValue().xProperty().asObject());
        Y.setCellValueFactory((d) -> d.getValue().yProperty().asObject());
        annual.setCellValueFactory((d) -> d.getValue().annualTurnoverProperty().asObject());
        date.setCellValueFactory((d) -> d.getValue().creationDateProperty());
        emploees.setCellValueFactory((d) -> d.getValue().employeesCountProperty().asObject());
        fullName.setCellValueFactory((d) -> d.getValue().fullNameProperty());
        id.setCellValueFactory((d) -> d.getValue().idProperty().asObject());
        name.setCellValueFactory((d) -> d.getValue().nameProperty());
        owner.setCellValueFactory((d) -> d.getValue().ownerProperty());
        street.setCellValueFactory((d) -> d.getValue().streetProperty());
        tX.setCellValueFactory((d) -> d.getValue().tXProperty().asObject());
        tY.setCellValueFactory((d) -> d.getValue().tYProperty().asObject());
        tZ.setCellValueFactory((d) -> d.getValue().tZProperty().asObject());
        type.setCellValueFactory((d) -> d.getValue().typeProperty());
        zip.setCellValueFactory((d) -> d.getValue().zipCodeProperty());

        updateOrgs();


//        ID.setCellValueFactory((cellData) -> cellData.getValue().IDProperty().asObject());

//        table.setItems(movies);


        btnVisualise.setOnAction((e) -> {
            try {
                Window.setScene("visualise", "Visualisation");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        ContextMenu cm = new ContextMenu();
        MenuItem add = new MenuItem("Add");
        add.setOnAction((e) -> {
            try {
                Window.setScene("add", "Add");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        MenuItem clear = new MenuItem("Clear");
        clear.setOnAction((e) -> {
            CollectionManipulator.getOrganizations().removeIf(ee -> ee.getOwner().equals(CollectionManipulator.getLogin()));
            updateOrgs();
            CollectionManipulator.save();

        });
        MenuItem cltpa = new MenuItem("CountLessThenPostalAddress");
        cltpa.setOnAction((e) -> {

        });
        MenuItem help = new MenuItem("Help");
        help.setOnAction((e) -> {

        });
        MenuItem info = new MenuItem("Info");
        info.setOnAction((e) -> {

        });
        MenuItem show = new MenuItem("Show");
        show.setOnAction((e) -> {

        });
        MenuItem shuffle = new MenuItem("Shuffle");
        shuffle.setOnAction((e) -> {

        });
        MenuItem soat = new MenuItem("SumOfAnnualTurnover");
        soat.setOnAction((e) -> {
            Alert c = new Alert(Alert.AlertType.INFORMATION);
            c.setContentText("SumOfAnnualTurnover =" + CollectionManipulator.getOrganizations().stream().map((e3) -> e3.getAnnualTurnover()).reduce((a, b) -> a + b).orElse(new Float(0)));
            c.show();


        });

        MenuItem delete = new MenuItem("Delete");
        delete.setOnAction((e) -> {
            CollectionManipulator.getOrganizations().remove(table.getSelectionModel().getFocusedIndex());
            updateOrgs();
            CollectionManipulator.save();
        });
        cm.getItems().addAll(add, clear, cltpa, help, info, show, shuffle, soat, delete);


        table.addEventHandler(MouseEvent.MOUSE_CLICKED, t -> {
            if (t.getButton() == MouseButton.SECONDARY) {
                cm.show(table, t.getScreenX(), t.getScreenY());
            } else {
                cm.hide();
            }
        });

    }

    public void updateOrgs() {
        orgs = CollectionManipulator.getOrganizations().stream().map((e) -> OrganizationProp.getOrgProp(e)).collect(Collectors.toCollection(FXCollections::observableArrayList));
        table.setItems(orgs);
    }


}
