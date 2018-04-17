package com.yusuf.spring.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import com.yusuf.spring.exception.UserException;
import com.yusuf.spring.pojo.User;

public class UserDAO extends DAO {

    public UserDAO() {
    }

    public User get(String username)
            throws UserException {
        try {
            begin();
            Query q = getSession().createQuery("from User where name = :username");
            q.setString("username", username);
            User user = (User) q.uniqueResult();
            
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not get user " + username, e);
        }
    }

    public User create(User user)
            throws UserException {
        try {
            begin();
            getSession().save(user);
            commit();
            return user;
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Exception while creating user: " + e.getMessage());
        }
    }

    public void delete(User user)
            throws UserException {
        try {
            begin();
            getSession().delete(user);
            commit();
        } catch (HibernateException e) {
            rollback();
            throw new UserException("Could not delete user " + user.getName(), e);
        }
    }
}