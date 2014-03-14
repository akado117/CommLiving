/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.Room;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class RoomDaoTest {
    
    RoomDao roomDao;
    
    public RoomDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        ApplicationContext ctx = new ClassPathXmlApplicationContext("test-applicationcontext.xml");
        
        roomDao = (RoomDao) ctx.getBean("RoomDao");
        
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void addGetDeleteTest() {
    
        Room room = new Room();
        room.setBuildingId(1);
        room.setRoomSqFt(25);
        room.setRoomNumber("25F");
        room.setTotalRoomRent(250);
        
        //add the room to the database
        roomDao.addNewRoom(room);
        
        //get the room from the database
        
        Room room2 =roomDao.getRoomBYId(room.getRoomId());
        
        //test the rooms values
        assertEquals(room.getBuildingId(),room2.getBuildingId());
        assertEquals(room.getRoomSqFt(),room2.getRoomSqFt());
        assertEquals(room.getRoomNumber(),room2.getRoomNumber());
        assertEquals(room.getTotalRoomRent(),room2.getTotalRoomRent());
        
        //delete from the database
        roomDao.deleteRoomById(room.getRoomId());
        
        //check to be sure it was removed
        room2 = roomDao.getRoomBYId(room.getRoomId());
        
        assertNull(room2);
        
        
    }
    
    @Test
    public void getAllTest(){
        
        Room[] rooms = roomDao.getAllRoomsFromBuilding(1);
        
        assertEquals(2,rooms.length);
    
    }
           
}
