/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.Building;

/**
 *
 * @author apprentice
 */
public interface BuildingDao {
    //gets the building by the username
    public String getBuildingNameByUsername(String username);
    
    //gets a list of building names
    public String[] getBuildingList();
    
    //adds a new building to the database
    public void newBuildingName(Building building);
    
    //updated a building with whatever is in the building object passed
    public void updateBuilding(Building building);
    
    //get a building from the database by building name
    public Building getBuildingFromDatabase(String buildingName);
    
    //deletes the building by it's name
    public void deleteBuildingByName(String buildingName);
}
