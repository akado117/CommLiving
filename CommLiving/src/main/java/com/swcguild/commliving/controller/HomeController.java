package com.swcguild.commliving.controller;

import com.swcguild.commliving.dao.BuildingDao;
import com.swcguild.commliving.dao.UserCostDao;
import com.swcguild.commliving.dao.UserDao;
import com.swcguild.commliving.model.Building;
import com.swcguild.commliving.model.User;
import com.swcguild.commliving.model.UserCost;
import java.security.Principal;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class HomeController {

    UserDao userDao;
    BuildingDao buildingDao;
    UserCostDao userCostDao;

    @Inject
    public HomeController(UserDao userDao, BuildingDao buildingDao, UserCostDao userCostDao) {

        this.userDao = userDao;
        this.buildingDao = buildingDao;
        this.userCostDao = userCostDao;

    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String addUser(HttpServletRequest req,
            HttpServletResponse res,
            Map<String, Object> model) {

        User user = new User();
        user.setUsername(req.getParameter("addName"));
        user.setPassword(req.getParameter("addPassword"));

        if (userDao.getUserByUsername(user.getUsername()) != null) {
            userDao.addUserFromLogin(user);
        } else {
            model.put("message", "The username already exists");
        }

        return "login";
    }
    //displays the home page with the users building and what they specifically owe
    @RequestMapping(value = "displayUserHome", method = RequestMethod.GET)
    public String displayUserHome(Map<String, Object> model,
            Principal prince,
            HttpSession session) {

        //grab the user from the database
        
        String buildingName = buildingDao.getBuildingNameByUsername(prince.getName());
        UserCost userCost = userCostDao.getUserCostUsingUserName(prince.getName());
        String[] buildingNames = buildingDao.getBuildingList();
        Building building =new Building();
        String buildingMessage;
        
        //if the session attribute doesn't exist assign an empty string to it.
        if(session.getAttribute("buildingExists")==null){
            buildingMessage= "";
        }else {
            buildingMessage= session.getAttribute("buildingExists").toString();
        }
        
       
        
        model.put("buildingName", buildingName);
        model.put("userCost", userCost);
        model.put("buildingNames", buildingNames);
        model.put("newBuilding", building);
        model.put("addBuildingMessage",buildingMessage);

        return "home";
    }
    
    @RequestMapping(value="BuildingPage",method=RequestMethod.POST)
    public String addThenMoveToBuildingPage(HttpSession session,
            HttpServletRequest req,
            HttpServletResponse res,
            Map<String,Object> model){
        
        String bName = req.getParameter("buildingName");
        
        if(bName == null){
            bName="";
        }else{
        session.setAttribute("userBuildingName",bName);
        }
        
        model.put("bName", bName);
        
        return "redirect:displayTotalBuilding";
    }

}
