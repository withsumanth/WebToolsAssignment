package com.me.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.me.dao.MovieDAO;
import com.me.dao.UserDAO;
import com.me.pojo.Movie;
import com.me.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MovieController {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	@Qualifier("movieDao")
	MovieDAO movieDao;
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	@RequestMapping(value = "/user/browse", method = RequestMethod.GET)
	protected String goToBrowseMov(HttpServletRequest request) throws Exception {
		return "browse";
	}
	
	@RequestMapping(value = "/user/movie", method = RequestMethod.GET)
	protected String goToMov(HttpServletRequest request) throws Exception {
		return "movie";
	}
	
	@RequestMapping(value="/user/add", method = RequestMethod.GET)
	public ModelAndView initializeForm(HttpServletRequest request) throws Exception {		
		ModelAndView mv = new ModelAndView();
		mv.addObject("movie", new Movie());
		mv.setViewName("add");
		return mv;
	}
	
	@RequestMapping(value = "/user/addmovie", method = RequestMethod.POST)
	public ModelAndView goToAfterAddMov(@ModelAttribute("movie") Movie movie, BindingResult result) throws Exception {
		try {			
			
			User u = userDao.get(movie.getAddedBy());
			movie.setUser(u);
			movie = movieDao.create(movie);
			
            
			return new ModelAndView("movieSuccess", "movie", movie);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
	}
	
	@RequestMapping(value = "user/search", method = RequestMethod.POST)
	public ModelAndView addCategory(HttpServletRequest request) throws Exception {

		try {			
			 String listValue = request.getParameter("searchVal");
	            String keyword = request.getParameter("keyword");
	            List<Movie> movList = movieDao.getMovie(listValue,keyword);
	            Map<String, Object> map = new HashMap<String, Object>();
	            map.put("movList", movList);
	            map.put("keyword", keyword);
			return new ModelAndView("searchres", "map", map);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ModelAndView("error", "errorMessage", "error while login");
		}
		
		
	}
}
