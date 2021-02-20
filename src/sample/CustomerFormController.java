package sample;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import database.Customer;
import database.Database;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class CustomerFormController {
    public TextField customerIDInputField;
    public TextField customerNameInputField;
    public TextField customerAddressInputField;
    public TextField customerSalaryInputField;
    public Button btnAddCustomer;
    public Button btnEditCustomer;
    public Button btnDeleteCustomer;
    public Button backToDashboard;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableView customerTable;
    public AnchorPane customerFormPanel;

    private Customer selectedCustomer;


    public void initialize(){
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        loadCustomers();


        //---------------------------
//        customerTable.getSelectionModel().selectedItemProperty().addListener((observableValue, o, t1) -> {
//            selectUniqueCustomer((Customer) t1);
//            selectedCustomer = (Customer) t1;
//        });
        //---------------------------

    }

    private void loadCustomers(){
        customerTable.setItems(FXCollections.observableArrayList(Database.customerList));
    }

    private void removeInputFields(){
        customerSalaryInputField.setText("");
        customerNameInputField.setText("");
        customerIDInputField.setText("");
        customerAddressInputField.setText("");
    }

    public void selectCustomer(){
        Customer selectedCustomer = (Customer) customerTable.getSelectionModel().getSelectedItem();

        customerIDInputField.setText(selectedCustomer.getId()+"");
        customerNameInputField.setText(selectedCustomer.getName());
        customerAddressInputField.setText(selectedCustomer.getAddress());
        customerSalaryInputField.setText(selectedCustomer.getSalary()+"");
    }

    public void onClickActionAddCustomer(ActionEvent actionEvent) throws IOException {
        Customer customer = new Customer(
                Integer.parseInt(customerIDInputField.getText()),
                customerNameInputField.getText(),
                customerAddressInputField.getText(),
                Double.parseDouble(customerSalaryInputField.getText()));

        if(Database.customerList.add(customer)){
            new Alert(Alert.AlertType.CONFIRMATION, "success", ButtonType.OK).show();
            removeInputFields();
        }else{
            new Alert(Alert.AlertType.ERROR, "failed", ButtonType.CLOSE).show();
        }

        loadCustomers();
    }

    public void onClickActionEditCustomer(ActionEvent actionEvent) {

    }

    public void onClickActionDeleteCustomer(ActionEvent actionEvent) {
        Customer selectedCustomer = (Customer) customerTable.getSelectionModel().getSelectedItem();
        Database.customerList.remove(selectedCustomer);
        removeInputFields();
        loadCustomers();
    }

    public void onClickActionBackToDashBoard(ActionEvent actionEvent) throws IOException {
        Stage window = (Stage) customerFormPanel.getScene().getWindow();
        window.setScene(new Scene(FXMLLoader.load(getClass().getResource("windowB.fxml"))));
        window.centerOnScreen();
    }
}
