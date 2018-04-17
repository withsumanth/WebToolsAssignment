/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.BooksDAO;
import com.me.pojo.Books;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sumanth
 */
public class BooksController extends AbstractController {
    
    public BooksController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mv = null;
        HttpSession session = request.getSession();
        if(request.getRequestURI().endsWith("books.htm")){
            String noOfBooks1 = request.getParameter("noOfBooks");
            int noOfBooks = Integer.parseInt(noOfBooks1);
            session.setAttribute("noOfBooks", noOfBooks);
            return new ModelAndView("addbook","noOfBooks",noOfBooks);
        }else if(request.getRequestURI().endsWith("addsuccess.htm")){
            int noOfBooks = (int) session.getAttribute("noOfBooks");
            BooksDAO booksDao;
            booksDao = (BooksDAO) this.getApplicationContext().getBean("booksdao");
            for(int i=0;i<noOfBooks;i++){
                Books books = new Books();
                books.setIsbn(request.getParameter("isbn"+(i+1)));
                books.setTitle(request.getParameter("title"+(i+1)));
                books.setAuthors(request.getParameter("authors"+(i+1)));
                books.setPrice(Float.parseFloat(request.getParameter("price"+(i+1))));
                booksDao.addBooks(books);
            }
            return new ModelAndView("addsuccess","noOfBooks",noOfBooks);
        }
        return mv;
    }
    
}
