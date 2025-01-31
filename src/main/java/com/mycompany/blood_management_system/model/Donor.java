/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.blood_management_system.model;

/**
 *
 * @author Abir Hasan
 */
public class Donor {
     private int id;
    private String userName;
    private String bloodGroup;
    private String mobile;
    private int currentAge;
    private String gender;
    
    public Donor(int id,String userName,String bloodGroup,String mobile,int currentAge,String gender)
    {
        this.id = id;
        this.userName= userName;
        this.bloodGroup=bloodGroup;
        this.mobile = mobile;
        this.currentAge = currentAge;
        this.gender = gender;
    }
    public Donor(String userName,String bloodGroup,String mobile,int currentAge,String gender)
    {
        this.userName= userName;
        this.bloodGroup=bloodGroup;
        this.mobile = mobile;
        this.currentAge = currentAge;
        this.gender = gender;
    }
    public Donor(String userName,String mobile)
    {
        this.userName= userName;
        this.mobile = mobile;

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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the bloodGroup
     */
    public String getBloodGroup() {
        return bloodGroup;
    }

    /**
     * @param bloodGroup the bloodGroup to set
     */
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile the mobile to set
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the currentAge
     */
    public int getCurrentAge() {
        return currentAge;
    }

    /**
     * @param currentAge the currentAge to set
     */
    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
