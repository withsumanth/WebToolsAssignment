package com.yusuf.spring.controller;

import com.yusuf.spring.dao.AdvertDAO;
import com.yusuf.spring.dao.CategoryDAO;
import org.springframework.web.servlet.mvc.SimpleFormController;

import com.yusuf.spring.dao.DAO;
import com.yusuf.spring.dao.UserDAO;

import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.Category;
import com.yusuf.spring.pojo.User;

import com.yusuf.spring.exception.AdvertException;

public class AddAdvertFormController extends SimpleFormController {

    public AddAdvertFormController() {
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        Advert advertObj = (Advert) command;
        String username = advertObj.getPostedBy();
        String categoryTitle = advertObj.getCategory();
        String title = advertObj.getTitle();
        String message = advertObj.getMessage();

        AdvertDAO advertDao = new AdvertDAO();
        CategoryDAO categoryDao = new CategoryDAO();
        UserDAO userDao = new UserDAO();
        try {
            User user = userDao.get(username);
            Category category = categoryDao.get(categoryTitle);
            Advert advert = advertDao.create(title, message, user);
            category.addAdvert(advert);
        } catch (Exception ex) {
            
        }
    }
}
