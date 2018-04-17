package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.pojo.Book;

public class BookDAO extends DAO {
	public Book create(Book book) {
		try {
			begin();
			getSession().save(book);
			commit();
			return book;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create advert", e);
			return null;
		}
	}
	
}
