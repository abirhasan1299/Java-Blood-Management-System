/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.blood_management_system.query;
import com.mycompany.blood_management_system.model.ConfirmRequest;
import com.mycompany.blood_management_system.model.Donor;
import com.mycompany.blood_management_system.model.Request;
import com.mycompany.blood_management_system.model.RequestOverview;
import com.mycompany.blood_management_system.model.getData;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Abir Hasan
 */

public class AppQuery {
    DbConnection c = new DbConnection();
    
        
    public ObservableList<RequestOverview> showHistory(){
        
            ObservableList<RequestOverview> list = FXCollections.observableArrayList();
            
            try{
                
                String sql = "SELECT date,quantity,hospital,disease FROM request JOIN confirm_request ON confirm_request.request_id = request.id JOIN donor_registration ON donor_registration.id ="+UserId();
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                
                RequestOverview x;
                while(rs.next()){
                    x = new RequestOverview(
                                rs.getString("date"),
                                rs.getInt("quantity"),                
                                rs.getString("hospital"),
                                rs.getString("disease"));
                               
                    list.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    
    public ObservableList<RequestOverview> showAllRequestWithData(){
        
            ObservableList<RequestOverview> list = FXCollections.observableArrayList();
            
            try{
                String sql = "SELECT request.blood,request.quantity,request.hospital,request.date,request.disease,request.status,donor_registration.d_username,donor_registration.d_mobile,donor_registration.d_gender,donor_registration.d_blood_group FROM donor_registration JOIN confirm_request ON confirm_request.donor_id = donor_registration.id JOIN request ON request.id=confirm_request.request_id;";
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                RequestOverview x;
                while(rs.next()){
                    x = new RequestOverview(
                                rs.getString("blood"),
                                rs.getInt("quantity"),                
                                rs.getString("hospital"),
                                rs.getString("date"),
                                rs.getString("disease"),
                                rs.getString("status"),
                                rs.getString("d_username"),
                                rs.getString("d_mobile"),
                                rs.getString("d_gender"),
                                rs.getString("d_blood_group"));
                               
                    list.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    
    
    public ObservableList<Donor> showDonorOverview(){
        
            ObservableList<Donor> list = FXCollections.observableArrayList();
            
            try{
                String sql = "select * from donor_registration order by id desc";
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                Donor x;
                while(rs.next()){
                    x = new Donor(
                                rs.getInt("id"),
                                rs.getString("d_username"),                
                                rs.getString("d_blood_group"),
                                rs.getString("d_mobile"),
                                rs.getInt("d_current_age"),
                                rs.getString("d_gender")
                               );
                               
                    list.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    
    public int TotalDonor(){
         int count= 0;
        try{
            
             String sql = "SELECT COUNT(id) AS Total FROM donor_registration";
               
             c.getDBConn();
             Statement st = c.getCon().createStatement();
             ResultSet rs = st.executeQuery(sql);
             
             if (rs.next()) {
                count = rs.getInt("Total");
            }
            
           rs.close();
           st.close();
           c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }
    public int TotalRequest(){
         int count= 0;
        try{
            
             String sql = "SELECT COUNT(id) AS Total FROM request";
               
             c.getDBConn();
             Statement st = c.getCon().createStatement();
             ResultSet rs = st.executeQuery(sql);
             
             if (rs.next()) {
                count = rs.getInt("Total");
            }
            
           rs.close();
           st.close();
           c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }
    
    public int UserId(){
       int id= 0;
       
        try{
            
             String sql = "SELECT id FROM donor_registration WHERE d_mobile='"+getData.userMobile +"'";
               
             c.getDBConn();
             Statement st = c.getCon().createStatement();
             ResultSet rs = st.executeQuery(sql);
             
             if (rs.next()) {
                id = rs.getInt("id");
            }
            
           rs.close();
           st.close();
           c.closeConnection();
            
            
        }catch(Exception e){
            e.printStackTrace();
        }
        return id;
        
    }
    
    
    public void UpdateRequestStatus(int x){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement
        ("update  request set status=? where id=?");
            
            ps.setString(1,"Approved");
            ps.setInt(2,x);
            
            ps.execute();
            ps.close();
            
            c.closeConnection();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void AddConfirm(ConfirmRequest x){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement
        ("insert into confirm_request(donor_id,request_id) values(?,?)");
            
            ps.setInt(1, x.getDonor_id());
            ps.setInt(2,x.getRequest_id());
            
            
            ps.execute();
            ps.close();
            
            c.closeConnection();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ObservableList<Request> showRequestRecipient(){
        
            ObservableList<Request> list = FXCollections.observableArrayList();
            try{
                String sql = "select * from request order by id desc";
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                Request x;
                while(rs.next()){
                    x = new Request(
                                rs.getInt("id"),
                                rs.getString("blood"),
                                rs.getInt("quantity"),
                                rs.getString("hospital"),
                                rs.getString("contact"),
                                rs.getString("date"),
                                rs.getString("disease"),
                                rs.getString("status")
                               );
                               
                    list.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    
    public void AddDonor(Request d){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement
        ("insert into request(blood,quantity,hospital,contact,date,disease,status) values(?,?,?,?,?,?,?)");
            
            ps.setString(1, d.getBlood());
            ps.setInt(2,d.getQuantity());
            ps.setString(3, d.getHospital());
            ps.setString(4, d.getContact());
            ps.setString(5, d.getDate());
            ps.setString(6, d.getDisease());
            ps.setString(7,d.getStatus());
            
            ps.execute();
            ps.close();
            
            c.closeConnection();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public ObservableList<Request> showSameBloodDetails(){
        
            ObservableList<Request> list = FXCollections.observableArrayList();
            try{
                String sql = "select * from request where blood='"+getData.bloodGroup+"' order by id desc";
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                Request x;
                 while(rs.next()){
                    x = new Request(
                                rs.getInt("id"),
                                rs.getString("blood"),
                                rs.getInt("quantity"),
                                rs.getString("hospital"),
                                rs.getString("contact"),
                                rs.getString("date"),
                                rs.getString("disease"),
                                rs.getString("status")
                               );
                               
                    list.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return list;
    }
    
    public ObservableList<Donor> showDonorRecipient(){
        
            ObservableList<Donor> donorList = FXCollections.observableArrayList();
            try{
                String sql = "select * from donor_registration order by id desc";
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                Donor x;
                while(rs.next()){
                    x = new Donor(
                                rs.getInt("id"),
                                rs.getString("d_username"),
                                rs.getString("d_blood_group"),
                                rs.getString("d_mobile"),
                                rs.getInt("d_current_age"),
                                rs.getString("d_gender")
                               );
                               
                    donorList.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return donorList;
    }
    
    public ObservableList<Donor> showDonorDetails(){
        
            ObservableList<Donor> donorList = FXCollections.observableArrayList();
            try{
                String sql = "select * from donor_registration where d_mobile='"+getData.userMobile+"'";
               
                c.getDBConn();
                Statement st = c.getCon().createStatement();
                ResultSet rs = st.executeQuery(sql);
                
                Donor x;
                while(rs.next()){
                    x = new Donor(
                                rs.getInt("id"),
                                rs.getString("d_username"),
                                rs.getString("d_blood_group"),
                                rs.getString("d_mobile"),
                                rs.getInt("d_current_age"),
                                rs.getString("d_gender")
                               );
                               
                    donorList.add(x);
                }
                
                rs.close();
                st.close();
                c.closeConnection();
                
            }catch(Exception e){
                e.printStackTrace();
            }
            return donorList;
    }
    
    public void LoginDonor(Donor d){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("select * from donor_registration where d_username=? and d_mobile=?");
            ps.setString(1, d.getUserName());
            ps.setString(2, d.getMobile());
            
            ResultSet r = ps.executeQuery();
            
            if(r.next()){
                
                getData.loginStatus = true;
                
            }else{
                
                Alert alert;
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setContentText("Wrong Credential");
                alert.showAndWait();
                
                getData.loginStatus = false;
                
            }
            ps.close();
            
            c.closeConnection();
            
          
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void AddDonor(Donor d){
        try{
            c.getDBConn();
            java.sql.PreparedStatement ps = c.getCon().prepareStatement("insert into donor_registration(d_username,d_blood_group,d_mobile,d_current_age,d_gender) values(?,?,?,?,?)");
            
            ps.setString(1, d.getUserName());
            ps.setString(2,d.getBloodGroup());
            ps.setString(3, d.getMobile());
            ps.setInt(4, d.getCurrentAge());
            ps.setString(5, d.getGender());
            
            ps.execute();
            ps.close();
            
            c.closeConnection();
            
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    
}
