package com.swcguild.commliving.controller;

import com.swcguild.commliving.dao.BuildingDao;
import com.swcguild.commliving.dao.UserCostDao;
import com.swcguild.commliving.dao.UserDao;
import com.swcguild.commliving.model.Building;
import java.security.Principal;
import java.util.Map;
import javax.inject.Inject;
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

    @Inject
    public BuildingController(UserDao userDao, BuildingDao buildingDao, UserCostDao userCostDao) {

        this.userDao = userDao;
        this.buildingDao = buildingDao;
        this.userCostDao = userCostDao;

    }

    //displays the home page with the users building and what they specifically owe
    @RequestMapping(value = "displayTotalBuilding", method = RequestMethod.GET)
    public String displayUserHome(Map<String, Object> model,
            Principal prince,
            HttpSession session) {

        //grab the user from the database
        String buildingName = session.getAttribute("userBuildingName").toString();
        //UserCost userCost = userCostDao.getUserCostUsingUserName(prince.getName());
        //String[] buildingNames = buildingDao.getBuildingList();

        //String buildingName = "Cutlas Co";
        model.put("buildingName", buildingName);
        //model.put("userCost", userCost);
        //model.put("buildingNames", buildingNames);

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


}
