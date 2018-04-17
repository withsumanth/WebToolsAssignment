package com.yusuf.spring.controller;

import com.yusuf.spring.dao.CategoryDAO;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.yusuf.spring.pojo.Category;
import com.yusuf.spring.dao.DAO;
import com.yusuf.spring.dao.UserDAO;
import com.yusuf.spring.exception.CategoryException;
import com.yusuf.spring.exception.UserException;
import com.yusuf.spring.pojo.User;


public class AddCategoryFormController extends SimpleFormController
{
    public AddCategoryFormController()
    {
        //controller properties here initialized in dispatcher-servlet.xml
        
        //setCommandClass(MyCommand.class);
        //setCommandName("MyCommandName");
        //setSuccessView("successView");
        //setFormView("formView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception
    {
        
        try {
            Category category = (Category) command;
            CategoryDAO categoryDao = new CategoryDAO();
            categoryDao.create(category.getTitle());
            DAO.close();
        } catch (CategoryException ex) {
            System.out.println("Error Creating User :"+ex.getMessage());
        }
    }
}