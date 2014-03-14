/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.UserCost;

/**
 *
 * @author apprentice
 */
public interface UserCostDao {
    
    //returns a usercost object from a database using username a query parameter
    public UserCost getUserCostUsingUserName(String username);
    //adds a new usercost object to the database 
    public UserCost addUserCost(UserCost userCost);
    //deletes a usercost object from the database using username
    public void deleteUserCost(String userName);
    
    
}
