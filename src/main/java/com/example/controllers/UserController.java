package com.example.controllers;

import java.util.List;

import com.example.App;
import com.example.models.Password;
import com.example.models.Storage;
import com.example.models.User;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

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
        startValidate();
        User user = new User();
        user.setUser(userField.getText());
        user.setPass(passField.getText());
        user.setRole(roleField.getText());
        userTable.getItems().add(user);

        clearFields();
    }

    boolean startValidate() {
        boolean valid = true;
        if (!isValidUserField()) {
            showError("A felhasználónév kötelező!");
            valid = false;
        }
        if (!isValidPassField()) {
            showError("A jelszó kötelező!");
            valid = false;
        }
        if (!isValidRoleField()) {
            showError("A szerep megadása kötelező");
            valid = false;
        }
        return valid;
    }

    void showError(String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText("Hibás bevitel!");
        System.err.println("Hiba!" + msg);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    boolean isValidUserField() {
        boolean valid = true;
        if (userField.getText().isEmpty()) {
            valid = false;
        }
        return valid;
    }

    boolean isValidPassField() {
        boolean valid = true;
        if (passField.getText().isEmpty()) {
            valid = false;
        }
        return valid;
    }

    boolean isValidRoleField() {
        boolean valid = true;
        if (roleField.getText().isEmpty()) {
            valid = false;
        }
        return valid;
    }

    void clearFields() {
        userField.setText("");
        passField.setText("");
        roleField.setText("");
    }

    @FXML
    void onClickBackButton(ActionEvent event) {
        App.setRoot("mainScene");
    }

    @FXML
    void onClickDelButton(ActionEvent event) {
        int index = userTable.getSelectionModel().getSelectedIndex();
        userTable.getItems().remove(index);
    }

    @FXML
    void onClickGeneratePasswordButton(ActionEvent event) {
        String newPassword = Password.generate();
        passField.setText(newPassword);
    }    

    @FXML
    void onClickModifyButton(ActionEvent event) {
        System.out.println("Módosít...");
        int index = userTable.getSelectionModel().getFocusedIndex();
        System.out.println(index);
        User user = new User();
        user.setUser(userField.getText());
        user.setPass(passField.getText());
        user.setRole(roleField.getText());

        userTable.getItems().set(index, user);
        userTable.setDisable(false);
        clearFields();
    }

    @FXML
    void onClickSaveButton(ActionEvent event) {
        Storage.writeContent(userTable.getItems());
    }

    @FXML
    void onMouseClicked(MouseEvent event) {
        if(event.getClickCount() == 2) {
            User user = userTable.getSelectionModel().getSelectedItem();
            userField.setText(user.getUser());
            passField.setText(user.getPass());
            roleField.setText(user.getRole());
            userTable.setDisable(true);
        }
    }    

}
