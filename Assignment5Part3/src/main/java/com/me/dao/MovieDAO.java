package com.me.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.me.pojo.Movie;

public class MovieDAO extends DAO {
	public Movie create(Movie movie) {
		try {
			begin();
			getSession().save(movie);
			commit();
			return movie;
		} catch (HibernateException e) {
			rollback();
			// throw new AdException("Could not create advert", e);
			return null;
		}
	}
	
	public List<Movie> getMovie(String listValue, String keyword) {
		try {
            begin();
            keyword = mysqlRealScapeString(keyword);
            String col = null;
            if (listValue.equals("Search By Title")) {
                col = "title";
            } else if (listValue.equals("Search By Actor")) {
                col = "actor";
            } else {
                col = "actress";
            }
            Query q = getSession().createQuery("from Movie where "+col+" = :search");
            q.setParameter("search", keyword);
            List<Movie> movies = q.list();
            commit();
            return movies;
        } catch (HibernateException e) {
            rollback();
            return null;
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
