/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.blood_management_system;

import com.mycompany.blood_management_system.model.ConfirmRequest;
import com.mycompany.blood_management_system.model.Donor;
import com.mycompany.blood_management_system.model.Request;
import com.mycompany.blood_management_system.model.RequestOverview;
import com.mycompany.blood_management_system.model.getData;
import com.mycompany.blood_management_system.query.AppQuery;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


/**
 * FXML Controller class
 *
 * @author Abir Hasan
 */
public class DonorProfileController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showDonorData();
        showRequestDetails();
        fetchHistory();
        
        acceptBtn.setDisable(false);  
    }  
    
     @FXML
    private Text bloodGrp;

    @FXML
    private ImageView female_img;

    @FXML
    private TableColumn<RequestOverview, String> h_date;

    @FXML
    private TableColumn<RequestOverview, String> h_hospital;

    @FXML
    private TableColumn<RequestOverview, String> h_problem;

    @FXML
    private TableColumn<RequestOverview, Integer> h_quantity;

    @FXML
    private TableView<RequestOverview> history_table_view;

    @FXML
    private TextField in_blood;

    @FXML
    private TextField in_contact;

    @FXML
    private TextField in_date;

    @FXML
    private TextField in_hospital;

    @FXML
    private TextField in_quantity;

    @FXML
    private TextField in_status;

    @FXML
    private TextField input_current_age;

    @FXML
    private TextField input_mobile;

    @FXML
    private TextField input_username;

    @FXML
    private ImageView male_img;

    @FXML
    private TableColumn<Request, String> req_blood;

    @FXML
    private TableColumn<Request, String> req_contact;

    @FXML
    private TableColumn<Request, String> req_date;

    @FXML
    private TableColumn<Request, String> req_disease;

    @FXML
    private TableColumn<Request, String> req_hospital;

    @FXML
    private TableColumn<Request, Integer> req_quantity;

    @FXML
    private TableColumn<Request, String> req_status;

    @FXML
    private TableView<Request> req_table;

    @FXML
    private Text text_username;
    
    private Request r;
    
    @FXML
    private Button acceptBtn;
    
    @FXML
    private Label req_id;
    
    @FXML
    private Label id;
    
    @FXML
    private void fetchHistory(){
        AppQuery query = new AppQuery();
        ObservableList<RequestOverview> list = query.showHistory();
        
        h_date.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("requestDate"));
        h_hospital.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("requestHospital"));
        h_problem.setCellValueFactory(new PropertyValueFactory<RequestOverview,String>("requestDisease"));
        h_quantity.setCellValueFactory(new PropertyValueFactory<RequestOverview,Integer>("requestQuantity"));
        
        history_table_view.setItems(list);
    }
    
    @FXML
    private void addConfirmRequest(){
        try{
            AppQuery query =new AppQuery();
            ConfirmRequest x = new ConfirmRequest(Integer.parseInt(id.getText()),Integer.parseInt(req_id.getText()));
            query.AddConfirm(x);
            clearField();
            
            query.UpdateRequestStatus(Integer.parseInt(req_id.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Request Approved");
            alert.setHeaderText(null);
            alert.setContentText("Request Recorded ! Contact with Recipient Mobile Number for further queries and information..");
            Optional<ButtonType> option = alert.showAndWait();
            showRequestDetails();
           
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
    @FXML
    private void clearField(){
        in_blood.clear();
        in_contact.clear();
        in_date.clear();
        in_hospital.clear();
        in_quantity.clear();
        in_status.clear();
        acceptBtn.setDisable(true);
    }
    
    @FXML
    private void mouseClicked(MouseEvent e){
        try{
            
            Request r = (Request) req_table.getSelectionModel().getSelectedItem();
            
            r = new Request(r.getId(),r.getBlood(),r.getQuantity(),r.getHospital(),r.getContact(),r.getDate(),r.getDisease(),r.getStatus());
            this.r =r;
            
            in_blood.setText(r.getBlood());
            in_contact.setText(r.getContact());
            in_date.setText(r.getDate());
            in_hospital.setText(r.getHospital());
            in_quantity.setText(String.valueOf(r.getQuantity()));
            in_status.setText(r.getStatus());
            req_id.setText(String.valueOf(r.getId()));
            
            acceptBtn.setDisable(false);        
            
            
        }catch(Exception error){
            error.printStackTrace();
        }
    }
    
    @FXML
    private void showRequestDetails(){
        AppQuery query = new AppQuery();
        ObservableList<Request> list = query.showSameBloodDetails();
        
        req_blood.setCellValueFactory(new PropertyValueFactory<Request,String>("blood"));
        req_contact.setCellValueFactory(new PropertyValueFactory<Request,String>("contact"));
        req_date.setCellValueFactory(new PropertyValueFactory<Request,String>("date"));
        req_disease.setCellValueFactory(new PropertyValueFactory<Request,String>("disease"));
        req_hospital.setCellValueFactory(new PropertyValueFactory<Request,String>("hospital"));
        req_quantity.setCellValueFactory(new PropertyValueFactory<Request,Integer>("quantity"));
        req_status.setCellValueFactory(new PropertyValueFactory<Request,String>("status"));
        
        req_table.setItems(list);
    }
    
    @FXML
    private void logout() throws IOException{
       getData.loginStatus = false;
       getData.userMobile=null;
       getData.bloodGroup = null;
       App.setRoot("HomePage");
    }
    
    @FXML
    private void showDonorData(){
        
       AppQuery query = new AppQuery();
       ObservableList<Donor> donorList = query.showDonorDetails();
       
       Donor d = donorList.get(0);
        
        text_username.setText(d.getUserName());
        input_username.setText(d.getUserName());
        input_mobile.setText(d.getMobile());
        input_current_age.setText(String.valueOf(d.getCurrentAge()));
        bloodGrp.setText(d.getBloodGroup());
        id.setText(String.valueOf(d.getId()));
        
        getData.bloodGroup = d.getBloodGroup();
        
        if("Male".equalsIgnoreCase(d.getGender())){
            male_img.setVisible(true);
        }else{
             female_img.setVisible(true);
        }
        
    }
    
}
 