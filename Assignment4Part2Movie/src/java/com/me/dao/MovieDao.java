/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Movie;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sumanth
 */
public class MovieDao {

    public boolean addMovie(Movie movie) {
        PreparedStatement st = null;
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtools", "root", "root");
            String sql = "Insert into movie(title,actor,actress,genre,year) values (?,?,?,?,?)";
            st = conn.prepareStatement(sql);
            st.setString(1, movie.getTitle());
            st.setString(2, movie.getActor());
            st.setString(3, movie.getActress());
            st.setString(4, movie.getGenre());
            st.setInt(5, movie.getYear());
            st.execute();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found Exception " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger("Connection Exception " + ex.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return false;
    }

    public ArrayList<Movie> getMovie(String listValue, String keyword) {
        Statement st = null;
        Connection conn = null;
        ArrayList<Movie> movies = new ArrayList<Movie>();
        try {
            String col = null;
            if (listValue.equals("Search By Title")) {
                col = "title";
            } else if (listValue.equals("Search By Actor")) {
                col = "actor";
            } else {
                col = "actress";
            }
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtools", "root", "root");
            String sql = "Select title,actor,actress,genre,year from movie where " + col + " = '" + keyword+"'";
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Movie m = new Movie();
                m.setTitle(rs.getString("title"));
                m.setActor(rs.getString("actor"));
                m.setActress(rs.getString("actress"));
                m.setGenre(rs.getString("genre"));
                m.setYear(rs.getInt("year"));
                movies.add(m);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Class not found Exception " + ex.getMessage());
        } catch (SQLException ex) {
            Logger.getLogger("Connection Exception " + ex.getMessage());
        } finally {
            try {
                if (st != null) {
                    st.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(MovieDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return movies;
    }
}
