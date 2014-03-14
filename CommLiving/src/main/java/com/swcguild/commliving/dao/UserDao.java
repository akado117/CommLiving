/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.User;
import com.swcguild.commliving.model.UserCost;

/**
 *
 * @author apprentice
 */
public interface UserDao {
    //adds the user from the login screen, only needs username and password
    public User addUserFromLogin(User user);
    
    //gets a user by their id (obsoleted by usernameget somewhat) 
    public User getUserById(int userId);
    
    //only to be used for deleteing test rows so they don't keep building up
    public void deleteUser(User user);
    //gets user by their username (username is forced to be unique)
    public User getUserByUsername(String username);
    
    //sets the user to a room
    public void setUserToRoom(String userName, int RoomId);
    
    //checks to see if the user exists in the database
    public boolean checkForUserInDatabase(String username);
   
    
}
