/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.blood_management_system;

import com.mycompany.blood_management_system.model.Donor;
import com.mycompany.blood_management_system.model.Request;
import com.mycompany.blood_management_system.query.AppQuery;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class RecipientDashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         ShowDonorList();
         ShowReqList();
    }    
    
    @FXML
    private TextField blood;

    @FXML
    private TextField contact;

    @FXML
    private DatePicker date;

    @FXML
    private TextField disease;

    @FXML
    private TextField hospital;

    @FXML
    private TextField quantity;

    @FXML
    private TableColumn<Request, String> req_blood;

    @FXML
    private TableColumn<Request, String> req_contact;

    @FXML
    private TableColumn<Request, String> req_hospital;

    @FXML
    private TableColumn<Request,Integer> req_quantity;

    @FXML
    private TableColumn<Request, String> req_status;

    @FXML
    private TextField search;

    @FXML
    private TableView<Request> search_req;

    @FXML
    private TextField search_request;

    @FXML
    private TableView<Donor> table;

    @FXML
    private TableColumn<Donor,Integer> table_age;

    @FXML
    private TableColumn<Donor,String> table_blood;

    @FXML
    private TableColumn<Donor,String> table_gender;

    @FXML
    private TableColumn<Donor,String> table_mobile;

    @FXML
    private TableColumn<Donor,String> table_name;
    
    @FXML
    private void back() throws IOException {
        App.setRoot("HomePage");
    }
    
    
    @FXML
    private void RequestAdd(){
        
       
        
 try{
        if(blood.getText().isEmpty() || 
            contact.getText().isEmpty() || 
            date.getValue() == null || 
            disease.getText().isEmpty() || 
            hospital.getText().isEmpty() || 
            quantity.getText().isEmpty()){
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please Fill the all Blank");
            Optional<ButtonType> option = alert.showAndWait();
            
        }else{
            
            Request d = new Request(blood.getText(),
                    Integer.parseInt(quantity.getText()),
                    hospital.getText(),
                    contact.getText(),
                    date.getValue().toString(),
                    disease.getText(),"pending");
            
            AppQuery query = new AppQuery();
            query.AddDonor(d);
            
            clearField();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Request Done");
            alert.setHeaderText(null);
            alert.setContentText("Please wait.. for accepting your request and Finding perfect donor for you. We will contact You after matching perfect donor");
            Optional<ButtonType> option = alert.showAndWait();
            ShowReqList();
            
        }
   }catch(Exception e){
           e.printStackTrace();
       }
        
        
    }
    
    private void ShowReqList(){
        
        AppQuery query = new AppQuery();
        ObservableList<Request> list = query.showRequestRecipient();
        
        req_blood.setCellValueFactory(new PropertyValueFactory<Request,String>("blood"));
        req_contact.setCellValueFactory(new PropertyValueFactory<Request,String>("contact"));
        req_hospital.setCellValueFactory(new PropertyValueFactory<Request,String>("hospital"));
        req_quantity.setCellValueFactory(new PropertyValueFactory<Request,Integer>("quantity"));
        req_status.setCellValueFactory(new PropertyValueFactory<Request,String>("status"));
        
        
        search_req.setItems(list);
    }
    
    public void clearField(){
        blood.clear();
        contact.clear();
        date.setValue(null);
        disease.clear();
        hospital.clear();
        quantity.clear();
    }
    
    private void ShowDonorList(){
        AppQuery query = new AppQuery();
        ObservableList<Donor> list = query.showDonorRecipient();
        
        table_name.setCellValueFactory(new PropertyValueFactory<Donor,String>("userName"));
        table_blood.setCellValueFactory(new PropertyValueFactory<Donor,String>("bloodGroup"));
        table_gender.setCellValueFactory(new PropertyValueFactory<Donor,String>("gender"));
        table_mobile.setCellValueFactory(new PropertyValueFactory<Donor,String>("mobile"));
        table_age.setCellValueFactory(new PropertyValueFactory<Donor,Integer>("currentAge"));
        
        
        table.setItems(list);
    }
    
}
