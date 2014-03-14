package com.swcguild.commliving.controller;

import com.swcguild.commliving.dao.BuildingDao;
import com.swcguild.commliving.dao.RoomDao;
import com.swcguild.commliving.dao.UserCostDao;
import com.swcguild.commliving.dao.UserDao;
import com.swcguild.commliving.model.Building;
import com.swcguild.commliving.model.Room;
import java.security.Principal;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class BuildingController {

    UserDao userDao;
    BuildingDao buildingDao;
    UserCostDao userCostDao;
    RoomDao roomDao;
    Building currentBuilding;

    @Inject
    public BuildingController(UserDao userDao, BuildingDao buildingDao, UserCostDao userCostDao, RoomDao roomDao) {

        this.userDao = userDao;
        this.buildingDao = buildingDao;
        this.userCostDao = userCostDao;
        this.roomDao = roomDao;

    }

    //displays the home page with the users building and what they specifically owe
    @RequestMapping(value = "displayTotalBuilding", method = RequestMethod.GET)
    public String displayUserHome(Map<String, Object> model,
            Principal prince,
            HttpSession session) {

        //grab the building name from the session
        String buildingName = session.getAttribute("userBuildingName").toString();
        //grab the bulding from the datebase
        currentBuilding = buildingDao.getBuildingFromDatabase(session.getAttribute("userBuildingName").toString());
        Building[] buildings = buildingDao.getAllBuildings();
        //get all the rooms in the building
        Room[] rooms = roomDao.getAllRoomsFromBuilding(currentBuilding.getBuildingId());
        


        //message for if a user was found or not
        String userFound;
        if(session.getAttribute("userExists")==null){
            userFound="";
        }else{
            userFound=session.getAttribute("userExists").toString();
        }

        
        //String buildingName = "Cutlas Co";
        model.put("buildingName", buildingName);
        model.put("building",currentBuilding);
        model.put("buildings",buildings);
        model.put("rooms",rooms);
        model.put("message", userFound);
        

        return "totalBuildingCost";
    }

    @RequestMapping(value = "addBuilding", method = RequestMethod.POST)
    public String addABuilding(@ModelAttribute("newBuilding") Building newBuilding,
            Map<String, Object> model,
            HttpSession session) {

        Boolean alreadyExists = false;
        //checks to see if the buildingname is aleady taken
        for (String building : buildingDao.getBuildingList()) {
            if (building.equals(newBuilding.getBuildingName())) {
                alreadyExists = true;
            }
        }
        //add the building if it doesn't exist, sets message in the session if it doesn't exist
        if (!alreadyExists) {
            buildingDao.newBuildingName(newBuilding);
            session.setAttribute("buildingExists", "");
        } else {
            session.setAttribute("buildingExists", "Please add a building that doesn't already exist");
        }

        return "redirect:displayUserHome";
    }
    
     @RequestMapping(value = "editBuilding", method = RequestMethod.POST)
    public String editBuilding(@ModelAttribute("building") Building building,
            Map<String,Object> model){
        //updated the building
        buildingDao.updateBuilding(building);
        
        return "redirect:displayTotalBuilding";
    }
    
    @RequestMapping(value="addRoom",method=RequestMethod.POST)
    public String addRoom(HttpServletRequest req,
            Map<String,Object> model){
        
        Room room = new Room();
        room.setRoomNumber(req.getParameter("roomNumber"));
        room.setRoomSqFt(Integer.parseInt(req.getParameter("roomSqFt")));
        room.setBuildingId(Integer.parseInt(req.getParameter("buildingNumber")));
        
        roomDao.addNewRoom(room);
        
        
        return "redirect:displayTotalBuilding";
    }
    
    @RequestMapping(value="addUserToRoom",method=RequestMethod.POST)
    public String addRoom(HttpSession session,
            HttpServletRequest req,
            Map<String,Object> model){
        
        String username= req.getParameter("userToRoom");
        
        if(userDao.checkForUserInDatabase(username)){
        userDao.setUserToRoom(username, Integer.parseInt(req.getParameter("moveToRoom")));
        session.setAttribute("userExists", "");
        }else{
            session.setAttribute("userExists", "User does not exists, please assign a user that does");
        }
        
        
        
        return "redirect:displayTotalBuilding";
    }


}
