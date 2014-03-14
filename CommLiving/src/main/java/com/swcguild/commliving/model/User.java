/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.commliving.model;

/**
 *
 * @author apprentice
 */
public class User {
    private int userId;
    private String username;
    private String authority="ROLE_USER";
    private String password;
    private int enabled = 1;
    private String firstName ="";
    private String lastName="";
    private String bio="";
    private double ammountOwed=0;
    private double expectMonthlyRate=0;
    private String hobbies="";
    private String skills="";
    private String items="";
    private String permanetAddress="";
    private int roomId=0;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public double getAmmountOwed() {
        return ammountOwed;
    }

    public void setAmmountOwed(double ammountOwed) {
        this.ammountOwed = ammountOwed;
    }

    public double getExpectMonthlyRate() {
        return expectMonthlyRate;
    }

    public void setExpectMonthlyRate(double expectMonthlyRate) {
        this.expectMonthlyRate = expectMonthlyRate;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getItems() {
        return items;
    }

    public void setItems(String items) {
        this.items = items;
    }

    public String getPermanetAddress() {
        return permanetAddress;
    }

    public void setPermanetAddress(String permanetAddress) {
        this.permanetAddress = permanetAddress;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
    
}
