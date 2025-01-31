/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blood_management_system.model;

/**
 *
 * @author Abir Hasan
 */
public class ConfirmRequest {
    private int id;
    private int donor_id;
    private int request_id;
    
    public ConfirmRequest(int id,int donor_id,int request_id){
        this.id = id;
        this.donor_id = donor_id;
        this.request_id = request_id;
    }
    public ConfirmRequest(int donor_id,int request_id){
        this.donor_id = donor_id;
        this.request_id = request_id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the donor_id
     */
    public int getDonor_id() {
        return donor_id;
    }

    /**
     * @param donor_id the donor_id to set
     */
    public void setDonor_id(int donor_id) {
        this.donor_id = donor_id;
    }

    /**
     * @return the request_id
     */
    public int getRequest_id() {
        return request_id;
    }

    /**
     * @param request_id the request_id to set
     */
    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }
}
