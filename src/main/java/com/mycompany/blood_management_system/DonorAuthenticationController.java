/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.blood_management_system;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.mycompany.blood_management_system.model.Donor;
import com.mycompany.blood_management_system.model.getData;
import java.util.Optional;
import com.mycompany.blood_management_system.query.AppQuery;
import java.io.IOException;
import javafx.event.ActionEvent;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
public class DonorAuthenticationController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    

    @FXML
    private TextField age;

    @FXML
    private TextField bloodGroup;

    @FXML
    private RadioButton female;

    @FXML
    private Button loginBtn;

    @FXML
    private PasswordField login_mobile;

    @FXML
    private TextField login_username;

    @FXML
    private RadioButton male;

    @FXML
    private TextField mobile;
    
    @FXML
    private ToggleGroup gender;
    
    @FXML
    private RadioButton others;

    @FXML
    private Button registerBtn;

    @FXML
    private TextField username;
     
    @FXML
    private void login() throws IOException
    {
        AppQuery query =new  AppQuery();
        
        Donor d = new Donor(login_username.getText(),login_mobile.getText());
        
        if(login_username.getText().isEmpty() || login_mobile.getText().isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Blank ERROR");
            alert.setHeaderText(null);
            alert.setContentText("Please ..Fill the blank fields");
            Optional<ButtonType> option = alert.showAndWait();
            
            
        }else{
            
            query.LoginDonor(d);
            
            if(getData.loginStatus){
                
                 getData.username = username.getText();
                 getData.userMobile = login_mobile.getText();
                 App.setRoot("donorProfile");
            }
                 
        }
    }
    
    
    @FXML
    private void RegisterUser(){
        
        String GENDER ;
        if(male.isSelected()){
            GENDER = "Male";
        }else if(female.isSelected()){
            GENDER = "Female";
        }else{
            GENDER = "Others";
        }
        
 try{
        if(username.getText().isEmpty() || age.getText().isEmpty() || GENDER.isEmpty() || mobile.getText().isEmpty() || bloodGroup.getText().isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please Fill the all Blank");
            Optional<ButtonType> option = alert.showAndWait();
            
        }else if(Integer.parseInt(age.getText())<17){
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Under Age");
            alert.setHeaderText(null);
            alert.setContentText("Sorry, Minimum age of Donation of Blood is 17");
            Optional<ButtonType> option = alert.showAndWait();
            
        }else{
            
            Donor d = new Donor(username.getText(),bloodGroup.getText(),mobile.getText(),Integer.parseInt(age.getText()),GENDER);
            
            AppQuery query = new AppQuery();
            query.AddDonor(d);
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Registration Done");
            alert.setHeaderText(null);
            alert.setContentText("Done . . .Go to login for enter profile");
            Optional<ButtonType> option = alert.showAndWait();
            clearField();
        }
   }catch(Exception e){
           e.printStackTrace();
       }
        
        
    }
    
    public void clearField(){
       username.clear();
       bloodGroup.clear();
       mobile.clear();
       age.clear();
       male.setSelected(false);
       female.setSelected(false);
       others.setSelected(false);
   }
    
}
