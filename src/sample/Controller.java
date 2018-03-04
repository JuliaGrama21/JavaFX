package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.TextField;

public class Controller {

    private ObservableList<Character> operations = FXCollections.observableArrayList('+', '-', '*', '/');

    @FXML
    private TextField number1;

    @FXML
    private ComboBox<Character> operation;

    @FXML
    private TextField number2;

    @FXML
    private Button calculate;

    @FXML
    private TextField result;

    @FXML
    void initialize() {
        operation.setItems(operations);
        calculate.setOnAction(event -> {
            Integer first = Integer.parseInt(number1.getText());
            Integer second = Integer.parseInt(number2.getText());
            Integer resultik = 0;

            SingleSelectionModel<Character> selectionModel = operation.getSelectionModel();
            Character selectedItem;
            if (selectionModel == null) {
                return;
            }

            selectedItem = selectionModel.getSelectedItem();

            switch (selectedItem){
                case '+': resultik = first + second; break;
                case '-': resultik = first - second; break;
                case '*': resultik = first * second; break;
                case '/': resultik = first / second; break;
            }

            result.setText(resultik.toString());
        });

    }

}
