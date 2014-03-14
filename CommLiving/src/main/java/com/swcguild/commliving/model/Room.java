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
public class Room {
    private int roomId;
    private int buildingId;
    private int roomSqFt;
    private String roomNumber;
    private int totalRoomRent;

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(int buildingId) {
        this.buildingId = buildingId;
    }

    public int getRoomSqFt() {
        return roomSqFt;
    }

    public void setRoomSqFt(int roomSqFt) {
        this.roomSqFt = roomSqFt;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getTotalRoomRent() {
        return totalRoomRent;
    }

    public void setTotalRoomRent(int totalRoomRent) {
        this.totalRoomRent = totalRoomRent;
    }
    
}
