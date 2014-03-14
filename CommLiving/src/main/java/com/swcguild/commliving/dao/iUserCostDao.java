/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.commliving.dao;

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
public class iUserCostDao implements UserCostDao {
    
    private final String SQL_GET_USER_COST_WITH_USERNAME
            = "SELECT * FROM user_costs WHERE username = ?";
    
    private final String SQL_ADD_USER_COST
            = "INSERT INTO user_costs (username,renters_insurance,utilities,base_rent,"
            + "internet,water,trash,electric,gas) VALUES (?,?,?,?,?,?,?,?,?)";
    
    private final String SQL_DELETE_USER_COST = 
            "DELETE FROM user_costs WHERE username = ?";
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    

    @Override
    public UserCost getUserCostUsingUserName(String username) {
        //will return null should no rows be found for query 
        try{
            return jdbcTemplate.queryForObject(SQL_GET_USER_COST_WITH_USERNAME, new UserCostMapper(), username);
        }catch(EmptyResultDataAccessException ex){
            return null;
        }
    }

    @Override
    public UserCost addUserCost(UserCost userCost) {
        
        jdbcTemplate.update(SQL_ADD_USER_COST, 
                userCost.getUsername(),
                userCost.getRentersInsurance(),
                userCost.getUtilities(),
                userCost.getBaseRent(),
                userCost.getInternet(),
                userCost.getWater(),
                userCost.getTrash(),
                userCost.getElectric(),
                userCost.getGas());
        
        return userCost;

    }

    @Override
    public void deleteUserCost(String username) {
        jdbcTemplate.update(SQL_DELETE_USER_COST,username);
    }

    
    private static final class UserCostMapper implements ParameterizedRowMapper<UserCost> {

        public UserCost mapRow(ResultSet rs, int rowNum) throws SQLException {
            UserCost user = new UserCost();
            user.setUsername(rs.getString("username"));
            user.setRentersInsurance(rs.getInt("renters_insurance"));
            user.setUtilities(rs.getInt("utilities"));
            user.setBaseRent(rs.getInt("base_rent"));
            user.setInternet(rs.getInt("internet"));
            user.setWater(rs.getInt("water"));
            user.setTrash(rs.getInt("trash"));
            user.setElectric(rs.getInt("electric"));
            user.setGas(rs.getInt("gas"));
            

            return user;
        }

    }
}
