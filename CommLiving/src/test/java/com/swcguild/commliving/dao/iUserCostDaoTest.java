/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.UserCost;
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
public class iUserCostDaoTest {
    
    UserCostDao userCostDao;
    
    public iUserCostDaoTest() {
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
        
        userCostDao =(UserCostDao) ctx.getBean("UserCostDao");
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void AddGetDeleteTest() {
     UserCost userCost = new UserCost();
     userCost.setUsername("username");
     userCost.setRentersInsurance(10);
     userCost.setUtilities(20);
     userCost.setBaseRent(30);
     userCost.setInternet(40);
     userCost.setWater(50);
     userCost.setTrash(60);
     userCost.setElectric(70);
     userCost.setGas(80);
     
     userCostDao.addUserCost(userCost);
     
     
     //test to see if the get funcationality works
     UserCost user2= userCostDao.getUserCostUsingUserName(userCost.getUsername());
     
     assertEquals(user2.getUsername(),userCost.getUsername());
     assertEquals(user2.getRentersInsurance(),userCost.getRentersInsurance());
     assertEquals(user2.getUtilities(),userCost.getUtilities());
     assertEquals(user2.getBaseRent(),userCost.getBaseRent());
     assertEquals(user2.getInternet(),userCost.getInternet());
     assertEquals(user2.getWater(),userCost.getWater());
     assertEquals(user2.getTrash(),userCost.getTrash());
     assertEquals(user2.getElectric(),userCost.getElectric());
     assertEquals(user2.getGas(),userCost.getGas());
     
     //test the delete function
     userCostDao.deleteUserCost(userCost.getUsername());
     
     user2= userCostDao.getUserCostUsingUserName(userCost.getUsername());
     
     assertNull(user2);
     
     
     }
}
