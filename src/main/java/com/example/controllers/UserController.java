package com.example.controllers;

import com.example.models.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    }

    @FXML
    void onClickAddButton(ActionEvent event) {

    }

    @FXML
    void onClickBackButton(ActionEvent event) {

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
