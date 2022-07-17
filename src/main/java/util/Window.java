package util;

import java.io.IOException;

import com.labs.lab8fx.App;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Window {
    private static Stage stage;
    private static Stage popout;

    public static void setStage(Stage stage) {
        Window.stage = stage;
    }

    public static void setScene(Stage st, String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(App.class.getResource(fxml + ".fxml"));
        Scene sc = new Scene(fxmlLoader.load(), 1300, 700);
        st.setScene(sc);
    }

    public static void setScene(String fxml) throws IOException {
       setScene(stage, fxml);
    }

    public static void setScene(String fxml, String title) throws IOException {
      setScene(fxml);
      stage.setTitle(title);
    }

    public static void showPopout(String fxml, String title) throws IOException {
        popout = new Stage();
        setScene(popout, fxml);
        popout.setTitle(title);
        popout.show();
    }

    //close popout window
    public static void closePopout() {
        popout.close();
    }

    //set title
    public static void setTitle(String title) {
        stage.setTitle(title);
    }

    //set min dimensions
    public static void setMinDimensions(int width, int height) {
        stage.setMinWidth(width);
        stage.setMinHeight(height);
    }

    //show
    public static void show() {
        stage.show();
    }


}
