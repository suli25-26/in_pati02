package com.example.controllers;

import java.util.List;

import com.example.App;
import com.example.models.Storage;
import com.example.models.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class UserController {

    @FXML
    private TableColumn<User, String> passCol;

    @FXML
    private TextField passField;

    @FXML
    private TableColumn<User, String> roleCol;

    @FXML
    private TextField roleField;

    @FXML
    private TableColumn<User, String> userCol;

    @FXML
    private TextField userField;

    @FXML
    private TableView<User> userTable;

    @FXML
    void initialize() {
        System.out.println("Init...");
        this.userCol.setCellValueFactory(new PropertyValueFactory<>("user"));
        this.passCol.setCellValueFactory(new PropertyValueFactory<>("pass"));
        this.roleCol.setCellValueFactory(new PropertyValueFactory<>("role"));

        List<User> userList = Storage.readContent();
        userTable.getItems().addAll(userList);
    }

    @FXML
    void onClickAddButton(ActionEvent event) {
        startAdd();
    }

    void startAdd() {
        if (!isValidFields()) {
            System.err.println("Hiba! A felhasználónév kötelező!");
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Hibás bevitel!");
            alert.setContentText("A felhasználónév kötelező!");
            alert.showAndWait();
            return;
        }

        User user = new User();
        user.setUser(userField.getText());
        user.setPass(passField.getText());
        user.setRole(roleField.getText());
        userTable.getItems().add(user);
    }

    boolean isValidFields() {
        boolean valid = true;
        if (userField.getText().isEmpty()) {
            valid = false;
        }
        return valid;
    }

    @FXML
    void onClickBackButton(ActionEvent event) {
        App.setRoot("mainScene");
    }

    @FXML
    void onClickDelButton(ActionEvent event) {

    }

    @FXML
    void onClickModifyButton(ActionEvent event) {

    }

    @FXML
    void onClickSaveButton(ActionEvent event) {

    }

}
