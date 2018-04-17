/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.MovieDao;
import com.me.pojo.Movie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sumanth
 */
public class MovieController extends AbstractController {
    
    public MovieController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        if (request.getRequestURI().endsWith("search.htm")) {
            String listValue = request.getParameter("searchVal");
            String keyword = request.getParameter("keyword");
            MovieDao mdao = (MovieDao) this.getApplicationContext().getBean("moviedao");
            ArrayList<Movie> movList = mdao.getMovie(listValue,keyword);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("movList", movList);
            map.put("keyword", keyword);
             return new ModelAndView("searchres","map",map);
        }else  if (request.getRequestURI().endsWith("browse.htm")) {
            return new ModelAndView("browse");
        }
         return null;
    }
    
}
