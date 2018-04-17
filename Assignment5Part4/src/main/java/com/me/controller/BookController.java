package com.me.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.me.dao.BookDAO;
import com.me.dao.UserDAO;
import com.me.pojo.Book;
import com.me.pojo.User;

/**
 * Handles requests for the application home page.
 */
@Controller
public class BookController {
	
	@Autowired
	@Qualifier("booksDao")
	BookDAO booksDao;
	
	@Autowired
	@Qualifier("userDao")
	UserDAO userDao;
	
	private static final Logger logger = LoggerFactory.getLogger(BookController.class);
	
	@RequestMapping(value = "/user/book", method = RequestMethod.GET)
	protected String goToMov(HttpServletRequest request) throws Exception {
		return "book";
	}
	
	@RequestMapping(value = "/user/books", method = RequestMethod.POST)
	protected ModelAndView goToBook(HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        String noOfBooks1 = request.getParameter("noOfBooks");
        int noOfBooks = Integer.parseInt(noOfBooks1);
        session.setAttribute("noOfBooks", noOfBooks);
        return new ModelAndView("addbook","noOfBooks",noOfBooks);
	}
	
	@RequestMapping(value = "/user/addsuccess", method = RequestMethod.POST)
	protected ModelAndView goToAddBook(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession();
		int noOfBooks = (Integer) session.getAttribute("noOfBooks");
		String addedBy = request.getParameter("addedBy");
		int addby = Integer.parseInt(addedBy);
        for(int i=0;i<noOfBooks;i++){
            Book books = new Book();
            User u = userDao.get(addby);
			books.setUser(u);
            books.setIsbn(request.getParameter("isbn"+(i+1)));
            books.setTitle(request.getParameter("title"+(i+1)));
            books.setAuthors(request.getParameter("authors"+(i+1)));
            books.setPrice(Float.parseFloat(request.getParameter("price"+(i+1))));
            booksDao.create(books);
        }
        return new ModelAndView("addsuccess","noOfBooks",noOfBooks);
	}
	
}
