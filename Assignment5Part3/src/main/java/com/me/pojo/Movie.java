/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Sumanth
 */
@Entity
@Table(name="movie_table")
public class Movie {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="movieID", unique = true, nullable = false)
	private long movieid;
	
	@Column(name="title")
    private String title;
	
	@Column(name="actor")
    private String actor;
	
	@Column(name="actress")
    private String actress;
	
	@Column(name="genre")
    private String genre;
	
	@Column(name="year")
    private int year;
	
	@ManyToOne
	private User user;
	
	@Transient
	int addedBy;

	public Movie(String title, String actor,String actress,String genre,int year, User user) {
        this.title = title;
        this.actor = actor;
        this.actress = actress;
        this.genre = genre;
        this.year = year;
        this.user = user;      
    }
	
	public Movie() {
		
	}
	
    public long getMovieid() {
		return movieid;
	}

	public void setMovieid(long movieid) {
		this.movieid = movieid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(int addedBy) {
		this.addedBy = addedBy;
	}

	public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getActress() {
        return actress;
    }

    public void setActress(String actress) {
        this.actress = actress;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
