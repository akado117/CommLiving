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
public class Building {
    private int buildingId;
    private String buildingName;
    private int internet;
    private int water;
    private int trash;
    private int electric;
    private int gas;
    private int totalUtil;
    private int totalSqFt;
    private int totalBaseRent;
    private int RenterInsurance;

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public int getInternet() {
        return internet;
    }

    public void setInternet(int internet) {
        this.internet = internet;
    }

    public int getWater() {
        return water;
    }

    public void setWater(int water) {
        this.water = water;
    }

    public int getTrash() {
        return trash;
    }

    public void setTrash(int trash) {
        this.trash = trash;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public int getGas() {
        return gas;
    }

    public void setGas(int gas) {
        this.gas = gas;
    }

    public int getTotalUtil() {
        return totalUtil;
    }

    public void setTotalUtil(int totalUtil) {
        this.totalUtil = totalUtil;
    }

    public int getTotalSqFt() {
        return totalSqFt;
    }

    public void setTotalSqFt(int totalSqFt) {
        this.totalSqFt = totalSqFt;
    }

    public int getTotalBaseRent() {
        return totalBaseRent;
    }

    public void setTotalBaseRent(int totalBaseRent) {
        this.totalBaseRent = totalBaseRent;
    }

    public int getRenterInsurance() {
        return RenterInsurance;
    }

    public void setRenterInsurance(int RenterInsurance) {
        this.RenterInsurance = RenterInsurance;
    }

    

   
    
}
