/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.Room;

/**
 *
 * @author apprentice
 */
public interface RoomDao {
    
    //adds  a new room to the database
    public Room addNewRoom(Room room);
    
    //gets the room from the database
    public Room getRoomBYId(int roomId);
    
    //deletes the room from the database
    public void deleteRoomById(int roomId);
    
    //gets all the rooms for a building
    public Room[] getAllRoomsFromBuilding(int buildingId);
    
    
}
