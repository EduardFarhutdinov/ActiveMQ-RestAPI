package com.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable  {

    @FXML
    private WebView webView;


    @FXML
    private Button loadPageButton;

    @FXML
    void loadPageButtonAction(ActionEvent event) {
        String url = "https://eclipse.org";

        System.out.println("fdsfs");

    }




    public void initialize(URL location, ResourceBundle resources) {

        WebEngine engine =webView.getEngine();
        engine.load("http://localhost:8080/registration");
    }
}
