package com.yusuf.spring.dao;

import org.hibernate.HibernateException;

import com.yusuf.spring.exception.AdvertException;
import com.yusuf.spring.pojo.Advert;
import com.yusuf.spring.pojo.User;

public class AdvertDAO extends DAO {

    public Advert create(String title, String message, User user)
            throws AdvertException {
        try {
            begin();
            Advert advert = new Advert(title, message, user);
            getSession().save(advert);
            commit();
            return advert;
        } catch (HibernateException e) {
            rollback();
            //throw new AdvertException("Could not create advert", e);
            throw new AdvertException("Exception while creating advert: " + e.getMessage());
        }
    }

    public void delete(Advert advert)
            throws AdvertException {
        try {
            begin();
            getSession().delete(advert);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new AdvertException("Could not delete advert", e);
        }
    }
}