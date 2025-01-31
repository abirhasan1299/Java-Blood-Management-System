/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.blood_management_system;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class HomePageController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    @FXML
    private Button adminBtn;

    @FXML
    private Button donorBtn;

    @FXML
    private Button recepBtn;
    
    @FXML
    private void AdminLogin() throws IOException{
        App.setRoot("AdminAuthentication");
    }
    
    @FXML
    private void DonorArea() throws IOException{
        App.setRoot("DonorAuthentication");
    }
    
    @FXML
    private void Recipient() throws IOException{
        App.setRoot("recipientDashboard");
    }

    
}
