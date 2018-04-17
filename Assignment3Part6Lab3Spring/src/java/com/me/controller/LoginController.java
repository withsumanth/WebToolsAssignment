/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sumanth
 */
public class LoginController extends AbstractController {
    
    public LoginController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession(true);
        String action = request.getParameter("action");
        
        if(action.equals("login")) {
        	Cookie ck[]=request.getCookies();
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String remember = request.getParameter("rememberMe");
            //Normally, we will need to connect to the DB to validate username/password
            //DB Connection will be discussed later
            //For now, we assume, username: admin, password: secret
            if (username.equals("admin") && password.equals("admin")) {
            	if(remember!=null && remember.equals("remember")) {
            		Cookie cookie=new Cookie("user","admin");
                        cookie.setMaxAge(360);
            		response.addCookie(cookie);
            	}
                //username/password correct, go to search page
                //add username to the session
                session.setAttribute("username", username);
                return new ModelAndView("searchCourse");
            } else {
                return new ModelAndView("index");
                //username/password not correct, send user to error-page or login page
            }
        } else if (action.equals("logout")) {
            //invalidate() removes all the objects from the session
            Cookie[] cookies = request.getCookies();
            for(Cookie c:cookies) {
            	if(c.getName().equals("user")) {
            		c.setMaxAge(0);
            		response.addCookie(c);
            	}
            }
            session.invalidate();
            return new ModelAndView("index");
        }
        return null;
    }
    
}
