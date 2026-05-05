package com.example.controllers;

import com.example.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MainController {

    @FXML
    void onClickAboutButton(ActionEvent event) {
        App.setRoot("aboutScene");
    }

    @FXML
    void onClickUsersButton(ActionEvent event) {
        App.setRoot("userScene");
    }

}
