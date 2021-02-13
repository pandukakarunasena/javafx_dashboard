package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class WindowBController {
    public Button btnBack;
    public AnchorPane windowB;

    public void onClickAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) windowB.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        window.centerOnScreen();
    }
}
