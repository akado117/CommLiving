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
import org.springframework.jdbc.core.JdbcTemplate;

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
        
        userDao =(UserDao) ctx.getBean("UserDao");
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
           
           userDao.addUserFromLogin(user);//works
           
           //tests the get functionality
           User fdbuser=userDao.getUserById(user.getUserId());
           
           assertEquals(user.getUserId(),fdbuser.getUserId());
           assertEquals(user.getUsername(),fdbuser.getUsername());
           assertEquals(user.getEnabled(),fdbuser.getEnabled());
           assertNull(fdbuser.getFirstName());
           assertNull(fdbuser.getLastName());
           assertNull(fdbuser.getBio());
           assertEquals(0.0, fdbuser.getAmmountOwed(),.01);
           assertEquals(0.0,fdbuser.getExpectMonthlyRate(),.01);
           assertNull(fdbuser.getHobbies());
           assertNull(fdbuser.getSkills());
           assertNull(fdbuser.getSkills());
           assertNull(fdbuser.getItems());
           assertNull(fdbuser.getPermanetAddress());
           assertEquals(0,fdbuser.getRoomId());
           
            //tests the get functionality of the username
           fdbuser=userDao.getUserByUsername(user.getUsername());
           
           assertEquals(user.getUserId(),fdbuser.getUserId());
           assertEquals(user.getUsername(),fdbuser.getUsername());
           assertEquals(user.getEnabled(),fdbuser.getEnabled());
           assertNull(fdbuser.getFirstName());
           assertNull(fdbuser.getLastName());
           assertNull(fdbuser.getBio());
           assertEquals(0.0, fdbuser.getAmmountOwed(),.01);
           assertEquals(0.0,fdbuser.getExpectMonthlyRate(),.01);
           assertNull(fdbuser.getHobbies());
           assertNull(fdbuser.getSkills());
           assertNull(fdbuser.getSkills());
           assertNull(fdbuser.getItems());
           assertNull(fdbuser.getPermanetAddress());
           assertEquals(0,fdbuser.getRoomId());
        
        //delete the user that was added
           userDao.deleteUser(user);
     
    }

    
    
}
