/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.Room;
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
public class iRoomDao implements RoomDao {
    
    private final String SQL_ADD_USER_TO_ROOM =
            "INSERT INTO room (building_id,room_sqft,room_number,total_room_rent) VALUES (?,?,?,?)";
    
    private final String SQL_GET_ROOM_BY_ID =
            "SELECT * FROM room WHERE room_id=?";
    
    private final String SQL_SQL_DELETE_ROOM_BY_ID=
            "DELETE FROM room WHERE room_id=?";
    
    private final String SQL_GET_ALL_ROOMS_FROM_BUILDING =
            "SELECT * FROM room WHERE building_id=?";
    
    
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Room addNewRoom(Room room) {
        //add the room to the database
        jdbcTemplate.update(SQL_ADD_USER_TO_ROOM,
                room.getBuildingId(),
                room.getRoomSqFt(),
                room.getRoomNumber(),
                room.getTotalRoomRent());
        
       room.setRoomId(jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class));
       
       return room;
    }

    @Override
    public Room getRoomBYId(int roomId) {
        try{
        
            Room room = jdbcTemplate.queryForObject(SQL_GET_ROOM_BY_ID, new RoomMapper(), roomId);
            return room;
            
        }catch(EmptyResultDataAccessException ex ){
            return null;
        }
    }

    @Override
    public void deleteRoomById(int roomId) {
        jdbcTemplate.update(SQL_SQL_DELETE_ROOM_BY_ID,roomId);
    }

    @Override
    public Room[] getAllRoomsFromBuilding(int buildingId) {
        List<Room> rlist = jdbcTemplate.query(SQL_GET_ALL_ROOMS_FROM_BUILDING, new RoomMapper(), buildingId);
        
        return rlist.toArray(new Room[0]);
    }

    
    
     private static final class RoomMapper implements ParameterizedRowMapper<Room>{
        
        public Room mapRow(ResultSet rs, int rowNum ) throws SQLException{
            Room room = new Room();
            room.setRoomId(rs.getInt("room_id"));
            room.setBuildingId(rs.getInt("building_id"));
            room.setRoomSqFt(rs.getInt("room_sqft"));
            room.setRoomNumber(rs.getString("room_number"));
            room.setTotalRoomRent(rs.getInt("total_room_rent"));
                        
            return room;
        }

        
        
    }
    
}
