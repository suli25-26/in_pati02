package com.example.controllers;

import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField passwordField;

    @FXML
    private TextField usernameField;

    @FXML
    void onClickLoginButton(ActionEvent event) {
        App.setRoot("mainScene");
    }

}
