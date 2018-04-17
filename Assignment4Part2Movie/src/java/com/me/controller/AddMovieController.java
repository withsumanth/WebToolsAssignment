/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.MovieDao;
import com.me.pojo.Movie;
import com.me.validator.MovieValidator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Sumanth
 */
public class AddMovieController extends SimpleFormController {
    
    public AddMovieController() {
        //Initialize controller properties here or 
        //in the Web Application Context
        setCommandClass(Movie.class);
        setCommandName("addmovie");
        setSuccessView("movieSuccess");
        setFormView("add");
        setValidator(new MovieValidator());
    }
    
    /*@Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }*/

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request, 
            HttpServletResponse response, 
            Object command, 
            BindException errors) throws Exception {
        ModelAndView mv ;
        Movie movie = (Movie) command;
        System.out.println(movie);
        movie.setTitle(request.getParameter("title"));
        movie.setActor(request.getParameter("actor"));
        movie.setActress(request.getParameter("actress"));
        movie.setGenre(request.getParameter("genre"));
        movie.setYear(Integer.parseInt(request.getParameter("year")));
        MovieDao movieDao;
        movieDao = (MovieDao) this.getApplicationContext().getBean("moviedao");
        movieDao.addMovie(movie);
        mv = new ModelAndView(getSuccessView());
        return mv;
    }
     
}
