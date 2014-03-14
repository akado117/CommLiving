/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swcguild.commliving.controller;

import com.swcguild.commliving.dao.UserDao;
import com.swcguild.commliving.model.User;
import java.util.Map;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
// #1 - all requests of the form /spring/login come here
@RequestMapping("/login")
public class LoginController {
    UserDao userDao;

    @Inject
    public void LoginController(UserDao userDao) {
        this.userDao = userDao;
    }
    
    
    // #2 - respond to all GET requests for /spring/login
    @RequestMapping(method = RequestMethod.GET)
    public void showLoginForm() {
    }

   
}
