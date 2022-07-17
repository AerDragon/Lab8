package controllers;

import collectionUsage.CollectionManipulator;
import data.Coordinates;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import util.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Visualise implements Initializable {

    @FXML
    private Button btnBack;

    @FXML
    private Canvas canvas;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        GraphicsContext gr = canvas.getGraphicsContext2D();

        CollectionManipulator.getOrganizations().stream().forEach((e)->{
            gr.setFill(Color.hsb(e.getOwner().hashCode(), 1, 1));
            long size = e.getEmployeesCount();
            Coordinates cor = e.getCoordinates();

            gr.fillRoundRect(cor.getX(), cor.getY(), size, size/2, 20, 20);
        });




        btnBack.setOnAction((e) -> {
            try {
                Window.setScene("main", "Main");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
