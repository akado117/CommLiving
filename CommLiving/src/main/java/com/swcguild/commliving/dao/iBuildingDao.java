/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.Building;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedRowMapper;

/**
 *
 * @author apprentice
 */
public class iBuildingDao implements BuildingDao {

    private final String SQL_GET_BUILDING_NAME_BY_USERNAME
            = "SELECT building_name \n"
            + "FROM users u\n"
            + "INNER JOIN room r\n"
            + "ON u.room_id = r.room_id\n"
            + "INNER JOIN building b\n"
            + "ON r.building_id = b.building_id\n"
            + "WHERE username = ?";

    private final String SQL_GET_ALL_BUILDING_NAMES
            = "SELECT building_name FROM building";

    private final String SQL_CREATE_NEW_BUILDING
            = "INSERT INTO building (building_name,internet,water,trash,electric,gas,total_util,total_sqft,base_rent,renter_insurance) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private final String SQL_UPDATE_BUILDING
            = "UPDATE building SET internet = ?, water = ?, trash = ?,electric=?,gas=?,total_util=?,total_sqft=?,base_rent=?,renter_insurance=? WHERE building_name = ?";

    private final String SQL_GET_BUILDING_BY_BUILDING_NAME
            = "SELECT * FROM building WHERE building_name = ?";
    
    private final String SQL_DELETE_BUILDING_BY_NAME =
            "DELETE FROM building WHERE building_name = ?";
    
    private final String SQL_GET_ALL_BUILDINGS =
            "SELECT * FROM building";
    
    

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    

    @Override
    public String getBuildingNameByUsername(String username) {

        return jdbcTemplate.queryForObject(SQL_GET_BUILDING_NAME_BY_USERNAME, String.class, username);

    }

    @Override
    public String[] getBuildingList() {

        //Query for a list of buildings and return null if the list is empty
        try {
            List<String> bList = jdbcTemplate.queryForList(SQL_GET_ALL_BUILDING_NAMES, String.class);

            return bList.toArray(new String[0]);

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    //create the new building
    @Override
    public void newBuildingName(Building building) {
        jdbcTemplate.update(SQL_CREATE_NEW_BUILDING,
                building.getBuildingName(), 
                building.getInternet(),
                building.getWater(),
                building.getTrash(),
                building.getElectric(),
                building.getGas(),
                building.getTotalUtil(),
                building.getTotalSqFt(),
                building.getTotalBaseRent(),
                building.getRenterInsurance());

    }

    //update the information in the building
    @Override
    public void updateBuilding(Building building) {
        jdbcTemplate.update(SQL_UPDATE_BUILDING,
                building.getInternet(),
                building.getWater(),
                building.getTrash(),
                building.getElectric(),
                building.getGas(),
                building.getTotalUtil(),
                building.getTotalSqFt(),
                building.getTotalBaseRent(),
                building.getRenterInsurance(),
                building.getBuildingName());

    }

    @Override
    public Building getBuildingFromDatabase(String buildingName) {
        try {
            Building building = jdbcTemplate.queryForObject(SQL_GET_BUILDING_BY_BUILDING_NAME, new BuildingMapper(), buildingName);
            return building;

        } catch (EmptyResultDataAccessException ex) {
            return null;
        }

    }

    @Override
    public void deleteBuildingByName(String buildingName) {
        jdbcTemplate.update(SQL_DELETE_BUILDING_BY_NAME, buildingName);
    }

    @Override
    public Building[] getAllBuildings() {
        List<Building> blist = jdbcTemplate.query(SQL_GET_ALL_BUILDINGS, new BuildingMapper());
        return blist.toArray(new Building[0]);
    }

    private static final class BuildingMapper implements ParameterizedRowMapper<Building> {
        
        public Building mapRow(ResultSet rs, int rowNum) throws SQLException {
            Building building = new Building();
            building.setBuildingId(rs.getInt("building_id"));
            building.setBuildingName(rs.getString("building_name"));
            building.setInternet(rs.getInt("internet"));
            building.setWater(rs.getInt("water"));
            building.setTrash(rs.getInt("trash"));
            building.setElectric(rs.getInt("electric"));
            building.setGas(rs.getInt("gas"));
            building.setTotalUtil(rs.getInt("total_util"));
            building.setTotalSqFt(rs.getInt("total_sqft"));
            building.setTotalBaseRent(rs.getInt("base_rent"));
            building.setRenterInsurance(rs.getInt("renter_insurance"));

            return building;
        }

    }
}
