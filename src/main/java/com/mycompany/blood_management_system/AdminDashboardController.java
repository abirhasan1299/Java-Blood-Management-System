/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.blood_management_system;

import com.mycompany.blood_management_system.model.Donor;
import com.mycompany.blood_management_system.model.RequestOverview;
import com.mycompany.blood_management_system.query.AppQuery;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class AdminDashboardController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       ShowCounting();
       showDonorDetails();
       showAllRequest();
    }  
    
    @FXML
    private TableColumn<Donor,Integer> don_age;

    @FXML
    private TableColumn<Donor, String> don_blood;

    @FXML
    private TableColumn<Donor, String> don_gender;

    @FXML
    private TableColumn<Donor, Integer> don_id;

    @FXML
    private TableColumn<Donor, String> don_mobile;

    @FXML
    private TableColumn<Donor, String> don_username;

    @FXML
    private Text in_stock;

    @FXML
    private TableColumn<RequestOverview,String> req_date;

    @FXML
    private TableColumn<RequestOverview,String> req_disease;

    @FXML
    private TableColumn<RequestOverview,String> req_gender;

    @FXML
    private TableColumn<RequestOverview,String> req_hospital;

    @FXML
    private TableColumn<RequestOverview,String> req_mobile;

    @FXML
    private TableColumn<RequestOverview,String> req_need_blood;

    @FXML
    private TableColumn<RequestOverview,Integer> req_quantity;

    @FXML
    private TableColumn<RequestOverview,String> req_status;

    @FXML
    private TableView<RequestOverview> req_table;

    @FXML
    private TableColumn<RequestOverview,String> req_user_blood;

    @FXML
    private TableColumn<RequestOverview,String> req_username;

    @FXML
    private TableView<Donor> tab_donor;

    @FXML
    private Text total_donor;

    @FXML
    private Text total_request;
    
    @FXML
    private void showAllRequest(){
        AppQuery query  = new AppQuery();
        ObservableList<RequestOverview> list = query.showAllRequestWithData();
        
        req_date.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("requestDate"));
        req_disease.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("requestDisease"));
        req_gender.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("donorGender"));
        req_hospital.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("requestHospital"));
        req_mobile.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("donorMobile"));
        req_need_blood.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("requestBlood"));
        req_quantity.setCellValueFactory(new PropertyValueFactory<RequestOverview,Integer>("requestQuantity"));
        req_status.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("Status"));
        req_username.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("donorUsername"));
        req_user_blood.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("donorBlood"));
        
        req_table.setItems(list);
        
    }
    
    @FXML
    private void showDonorDetails(){
        AppQuery query = new AppQuery();
        ObservableList<Donor> list = query.showDonorOverview();
        
        don_age.setCellValueFactory(new PropertyValueFactory<Donor,Integer>("currentAge"));
        don_blood.setCellValueFactory(new PropertyValueFactory<Donor,String>("bloodGroup"));
        don_gender.setCellValueFactory(new PropertyValueFactory<Donor,String>("gender"));
        don_id.setCellValueFactory(new PropertyValueFactory<Donor,Integer>("id"));
        don_mobile.setCellValueFactory(new PropertyValueFactory<Donor,String>("mobile"));
        don_username.setCellValueFactory(new PropertyValueFactory<Donor,String>("userName"));
        
        tab_donor.setItems(list);
    }
  
    @FXML
    private void Logout() throws IOException{
        App.setRoot("HomePage");
    }
    
    @FXML
    private void ShowCounting(){
        try{
            AppQuery query = new AppQuery();
            total_donor.setText(String.valueOf(query.TotalDonor()));
            total_request.setText(String.valueOf(query.TotalRequest()));
            in_stock.setText(String.valueOf(query.TotalRequest()));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
 
    

    
}
