/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.User;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author apprentice
 */
public class iUserDaoTest {

    UserDao userDao;

    public iUserDaoTest() {
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

        userDao = (UserDao) ctx.getBean("UserDao");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of addUserFromLogin method, of class iUserDao.
     */
    @Test
    public void testAddGetUserFromLogin() {
        System.out.println("addUserFromLogin");
        User user = new User();
        user.setUsername("username");
        user.setPassword("Password");
        user.setFirstName("first_name");
        user.setLastName("last_name");
        user.setBio("bio");
        user.setAmmountOwed(2.22);
        user.setExpectMonthlyRate(3.33);
        user.setHobbies("hobbies");
        user.setSkills("skills");
        user.setItems("items");
        user.setPermanetAddress("permanent_address");
        user.setRoomId(1);

        userDao.addUserFromLogin(user);//works

        //tests the get functionality
        User fdbuser = userDao.getUserById(user.getUserId());

        assertEquals(user.getUserId(), fdbuser.getUserId());
        assertEquals(user.getUsername(), fdbuser.getUsername());
        assertEquals(user.getEnabled(), fdbuser.getEnabled());
        assertNull(fdbuser.getFirstName());
        assertNull(fdbuser.getLastName());
        assertNull(fdbuser.getBio());
        assertEquals(0.0, fdbuser.getAmmountOwed(), .01);
        assertEquals(0.0, fdbuser.getExpectMonthlyRate(), .01);
        assertNull(fdbuser.getHobbies());
        assertNull(fdbuser.getSkills());
        assertNull(fdbuser.getSkills());
        assertNull(fdbuser.getItems());
        assertNull(fdbuser.getPermanetAddress());
        assertEquals(0, fdbuser.getRoomId());

        //tests the get functionality of the username
        fdbuser = userDao.getUserByUsername(user.getUsername());

        assertEquals(user.getUserId(), fdbuser.getUserId());
        assertEquals(user.getUsername(), fdbuser.getUsername());
        assertEquals(user.getEnabled(), fdbuser.getEnabled());
        assertNull(fdbuser.getFirstName());
        assertNull(fdbuser.getLastName());
        assertNull(fdbuser.getBio());
        assertEquals(0.0, fdbuser.getAmmountOwed(), .01);
        assertEquals(0.0, fdbuser.getExpectMonthlyRate(), .01);
        assertNull(fdbuser.getHobbies());
        assertNull(fdbuser.getSkills());
        assertNull(fdbuser.getSkills());
        assertNull(fdbuser.getItems());
        assertNull(fdbuser.getPermanetAddress());
        assertEquals(0, fdbuser.getRoomId());

        //delete the user that was added
        userDao.deleteUser(user);

    }

    @Test
    public void testAddUserToRoom() {
        User user = new User();
        user.setUsername("username");
        user.setPassword("Password");
        user.setFirstName("first_name");
        user.setLastName("last_name");
        user.setBio("bio");
        user.setAmmountOwed(2.22);
        user.setExpectMonthlyRate(3.33);
        user.setHobbies("hobbies");
        user.setSkills("skills");
        user.setItems("items");
        user.setPermanetAddress("permanent_address");
        user.setRoomId(1);
        //add user to database
        userDao.addUserFromLogin(user);
        //add a user to a room
        userDao.setUserToRoom(user.getUsername(), 2);
        //get the user from the database
        User user2 = userDao.getUserByUsername(user.getUsername());

        assertEquals(user2.getRoomId(), 2);
        //change the room
        userDao.setUserToRoom(user.getUsername(), 3);
        //get the user back out
        user2 = userDao.getUserByUsername(user.getUsername());
        //test again
        assertEquals(user2.getRoomId(), 3);

        //delete the user that was added
        userDao.deleteUser(user);

    }

    @Test
    public void doesUserExistTest() {
        String username = "test";
        String username2 = "asfdsdfsdk";

        assertTrue(userDao.checkForUserInDatabase(username));
        assertFalse(userDao.checkForUserInDatabase(username2));

    }

}
