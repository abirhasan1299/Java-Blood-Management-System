/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blood_management_system.model;

/**
 *
 * @author Abir Hasan
 */
public class RequestOverview {
    
    private String requestBlood;
    private int requestQuantity;
    private String requestHospital;
    private String requestDate;
    private String requestDisease;
    private String Status;
    private String donorUsername;
    private String donorMobile;
    private String donorGender;
    private String donorBlood;
    
    public RequestOverview(String requestDate,int requestQuantity,String requestHospital,String requestDisease){
        this.requestDate =requestDate;
        this.requestQuantity =requestQuantity;
        this.requestHospital = requestHospital;
        this.requestDisease = requestDisease;
    }
    
    public RequestOverview(String requestBlood,
            int requestQuantity,
            String requestHospital,
            String requestDate,
            String requestDisease,
            String Status,
            String donorUsername,
            String donorMobile,
            String donorGender,
            String donorBlood){
        this.requestBlood = requestBlood;
        this.requestQuantity = requestQuantity;
        this.requestHospital= requestHospital;
        this.requestDate = requestDate;
        this.requestDisease =requestDisease;
        this.Status = Status;
        this.donorUsername = donorUsername;
        this.donorMobile =donorMobile;
        this.donorGender = donorGender;
        this.donorBlood  =donorBlood;
        
    }

    /**
     * @return the requestBlood
     */
    public String getRequestBlood() {
        return requestBlood;
    }

    /**
     * @param requestBlood the requestBlood to set
     */
    public void setRequestBlood(String requestBlood) {
        this.requestBlood = requestBlood;
    }

    /**
     * @return the requestQuantity
     */
    public int getRequestQuantity() {
        return requestQuantity;
    }

    /**
     * @param requestQuantity the requestQuantity to set
     */
    public void setRequestQuantity(int requestQuantity) {
        this.requestQuantity = requestQuantity;
    }

    /**
     * @return the requestHospital
     */
    public String getRequestHospital() {
        return requestHospital;
    }

    /**
     * @param requestHospital the requestHospital to set
     */
    public void setRequestHospital(String requestHospital) {
        this.requestHospital = requestHospital;
    }

    /**
     * @return the requestDate
     */
    public String getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * @return the requestDisease
     */
    public String getRequestDisease() {
        return requestDisease;
    }

    /**
     * @param requestDisease the requestDisease to set
     */
    public void setRequestDisease(String requestDisease) {
        this.requestDisease = requestDisease;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    /**
     * @return the donorUsername
     */
    public String getDonorUsername() {
        return donorUsername;
    }

    /**
     * @param donorUsername the donorUsername to set
     */
    public void setDonorUsername(String donorUsername) {
        this.donorUsername = donorUsername;
    }

    /**
     * @return the donorMobile
     */
    public String getDonorMobile() {
        return donorMobile;
    }

    /**
     * @param donorMobile the donorMobile to set
     */
    public void setDonorMobile(String donorMobile) {
        this.donorMobile = donorMobile;
    }

    /**
     * @return the donorGender
     */
    public String getDonorGender() {
        return donorGender;
    }

    /**
     * @param donorGender the donorGender to set
     */
    public void setDonorGender(String donorGender) {
        this.donorGender = donorGender;
    }

    /**
     * @return the donorBlood
     */
    public String getDonorBlood() {
        return donorBlood;
    }

    /**
     * @param donorBlood the donorBlood to set
     */
    public void setDonorBlood(String donorBlood) {
        this.donorBlood = donorBlood;
    }
    
    
    
}
