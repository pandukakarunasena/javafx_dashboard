package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class WindowAController {
    public Button btnBack;
    public AnchorPane windowA;
    public AnchorPane contextContainer;


    public void onClickAction(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) windowA.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        window.centerOnScreen();
    }

    public void onClickActionBtnTask(ActionEvent actionEvent) throws IOException {
        contextContainer.getChildren().clear();
        contextContainer.getChildren().add(FXMLLoader.load(getClass().getResource("tasksPanel.fxml")));
    }

    public void onClickActionBtnReminders(ActionEvent actionEvent) throws IOException {
        contextContainer.getChildren().clear();
        contextContainer.getChildren().add(FXMLLoader.load(getClass().getResource("remindersPanel.fxml")));
    }
}
