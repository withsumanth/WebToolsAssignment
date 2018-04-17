package com.me.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.exception.UserException;
import com.me.pojo.Email;
import com.me.pojo.User;

public class UserDAO extends DAO {

	public UserDAO() {
	}

	public User get(String username, String password) throws UserException {
		try {
			begin();
			username = mysqlRealScapeString(username);
			password = mysqlRealScapeString(password);
			Query q = getSession().createQuery("from User where username = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);			
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + username, e);
		}
	}
	
	public User get(int userId) throws UserException {
		try {
			begin();
			Query q = getSession().createQuery("from User where personID= :personID");
			q.setInteger("personID", userId);		
			User user = (User) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not get user " + userId, e);
		}
	}

	public User register(User u)
			throws UserException {
		try {
			begin();
			System.out.println("inside DAO");

			Email email = new Email(u.getEmail().getEmailAddress());
			User user = new User(u.getUsername(), u.getPassword());
			user.setFirstName(u.getFirstName());
			user.setLastName(u.getLastName());
			user.setEmail(email);
			email.setUser(user);
			getSession().save(user);
			commit();
			return user;

		} catch (HibernateException e) {
			rollback();
			throw new UserException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(User user) throws UserException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new UserException("Could not delete user " + user.getUsername(), e);
		}
	}
	
	public String mysqlRealScapeString(String str){
		  String data = null;
		  if (str != null && str.length() > 0) {
		    str = str.replace("\\", "\\\\");
		    str = str.replace("'", "\\'");
		    str = str.replace("\0", "\\0");
		    str = str.replace("\n", "\\n");
		    str = str.replace("\r", "\\r");
		    str = str.replace("\"", "\\\"");
		    str = str.replace("\\x1a", "\\Z");
		    data = str;
		  }
		return data;
	}
}