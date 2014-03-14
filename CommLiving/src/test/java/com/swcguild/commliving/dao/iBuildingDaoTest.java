/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.commliving.dao;

import com.swcguild.commliving.model.Building;
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
public class iBuildingDaoTest {

    BuildingDao buildingDao;

    public iBuildingDaoTest() {
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

        buildingDao = (BuildingDao) ctx.getBean("BuildingDao");
    }

    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void AddGetUpdateDeleteTest() {
        Building building = new Building();
        building.setBuildingId(0);
        building.setBuildingName("Chico's LTD");
        building.setInternet(10);
        building.setWater(20);
        building.setTrash(30);
        building.setElectric(40);
        building.setGas(50);
        building.setTotalUtil(60);
        building.setTotalSqFt(70);
        building.setTotalBaseRent(80);
        building.setRenterInsurance(90);

        //add the building to the database
        buildingDao.newBuildingName(building);
        //test to see if the get funcationality works
        Building building2 = buildingDao.getBuildingFromDatabase(building.getBuildingName());

        assertEquals(building.getBuildingName(), building2.getBuildingName());
        assertEquals(building.getInternet(), building2.getInternet());
        assertEquals(building.getWater(), building2.getWater());
        assertEquals(building.getTrash(), building2.getTrash());
        assertEquals(building.getElectric(), building2.getElectric());
        assertEquals(building.getGas(), building2.getGas());
        assertEquals(building.getTotalUtil(), building2.getTotalUtil());
        assertEquals(building.getTotalSqFt(), building2.getTotalSqFt());
        assertEquals(building.getTotalBaseRent(), building2.getTotalBaseRent());
        assertEquals(building.getRenterInsurance(), building2.getRenterInsurance());

        //test the update functionality
        building = new Building();
        building.setBuildingId(0);
        building.setBuildingName("Chico's LTD");
        building.setInternet(20);
        building.setWater(30);
        building.setTrash(40);
        building.setElectric(50);
        building.setGas(60);
        building.setTotalUtil(70);
        building.setTotalSqFt(80);
        building.setTotalBaseRent(90);
        building.setRenterInsurance(100);
        buildingDao.updateBuilding(building);

        building2 = buildingDao.getBuildingFromDatabase(building.getBuildingName());

        assertEquals(building.getBuildingName(), building2.getBuildingName());
        assertEquals(building.getInternet(), building2.getInternet());
        assertEquals(building.getWater(), building2.getWater());
        assertEquals(building.getTrash(), building2.getTrash());
        assertEquals(building.getElectric(), building2.getElectric());
        assertEquals(building.getGas(), building2.getGas());
        assertEquals(building.getTotalUtil(), building2.getTotalUtil());
        assertEquals(building.getTotalSqFt(), building2.getTotalSqFt());
        assertEquals(building.getTotalBaseRent(), building2.getTotalBaseRent());
        assertEquals(building.getRenterInsurance(), building2.getRenterInsurance());

        //test the delete function
        buildingDao.deleteBuildingByName(building.getBuildingName());

        building = buildingDao.getBuildingFromDatabase(building.getBuildingName());

        assertNull(building);

    }

    @Test
    public void getAllBuildingsTest() {
        //test to make sure there is still only one entry in the building table
        assertEquals(buildingDao.getAllBuildings().length,1);
    }
}
