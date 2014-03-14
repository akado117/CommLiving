/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.User;
import com.swcguild.commliving.model.UserCost;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author apprentice
 */
public class iUserDao implements UserDao {

    private final String SQL_ADD_USER_TO_USERS
            = "INSERT INTO users (username,password,enabled) VALUES (?,?,?)";
            

    private final String SQL_ADD_USER_TO_AUTHORITIES
            = "INSERT INTO authorities (username,authority) VALUES (?,?)";

    private final String SQL_GET_USER_FROM_USERS
            = "SELECT * FROM users WHERE user_id = ?";
    
    private final String SQL_GET_USER_FROM_USERS_USERNAME
            = "SELECT * FROM users WHERE username = ?";
    
    private final String SQL_DELETE_USERS =
            "DELETE FROM users WHERE user_id = ?";
    
    private final String SQL_DELETE_AUTHORITIES =
            "DELETE FROM authorities WHERE username = ?";
    
    private final String SQL_ADD_USER_TO_ROOM=
            "UPDATE users SET room_id = ? WHERE username = ?";
    
    private final String SQL_CHECK_IF_USER_IN_DATABASE=
            "Select * FROM users WHERE username = ?";
    
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //adds a new user to the database and updated the authorities table to account for the new user
    @Override
    public User addUserFromLogin(User user) {

        jdbcTemplate.update(SQL_ADD_USER_TO_USERS,
                user.getUsername(),
                user.getPassword(),
                user.getEnabled());

        user.setUserId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));

        jdbcTemplate.update(SQL_ADD_USER_TO_AUTHORITIES,
                user.getUsername(),
                user.getAuthority());

        return user;
    }

    //gets the user by their id
    @Override
    public User getUserById(int userId) {

        try {

            return jdbcTemplate.queryForObject(SQL_GET_USER_FROM_USERS, new UserMapper(), userId);

        } catch (EmptyResultDataAccessException ex) {

            return null;
        }

    }

    
        //only to be used for deleteing test rows so they don't keep building up

    @Override
    public void deleteUser(User user) {
        //clear users row
        jdbcTemplate.update(SQL_DELETE_USERS,user.getUserId());
        //clear authorities row
        jdbcTemplate.update(SQL_DELETE_AUTHORITIES,user.getUsername());
        
    }
    //gets a user by their username
    @Override
    public User getUserByUsername(String username) {
       
         try {

            return jdbcTemplate.queryForObject(SQL_GET_USER_FROM_USERS_USERNAME, new UserMapper(), username);

        } catch (EmptyResultDataAccessException ex) {

            return null;
        }
        
        
    }

    @Override
    public void setUserToRoom(String username, int roomId) {
        jdbcTemplate.update(SQL_ADD_USER_TO_ROOM,roomId,username);
    }

    @Override
    public boolean checkForUserInDatabase(String username) {
        try{
            jdbcTemplate.queryForObject(SQL_CHECK_IF_USER_IN_DATABASE,  new UserMapper(),username);
            return true;
        }catch(EmptyResultDataAccessException ex){
            return false;
        }
    }



    private static final class UserMapper implements ParameterizedRowMapper<User> {

        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setUserId(rs.getInt("user_id"));
            user.setUsername(rs.getString("username"));
            user.setEnabled(rs.getInt("enabled"));
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setBio(rs.getString("bio"));
            user.setAmmountOwed(rs.getInt("amount_owed"));
            user.setExpectMonthlyRate(rs.getInt("expected_monthly_rate"));
            user.setHobbies(rs.getString("hobbies"));
            user.setSkills(rs.getString("skills"));
            user.setItems(rs.getString("items"));
            user.setPermanetAddress(rs.getString("permanent_address"));
            user.setRoomId(rs.getInt("room_id"));

            return user;
        }

    }
    
    

}
