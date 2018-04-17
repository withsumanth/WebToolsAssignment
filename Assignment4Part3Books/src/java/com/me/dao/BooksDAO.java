/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Books;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sumanth
 */
public class BooksDAO {

    public void addBooks(Books books) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/webtools", "root", "root");
            String query = "Insert into books(isbn,title,authors,price) values (?,?,?,?)";
            st = conn.prepareStatement(query);
            st.setString(1, books.getIsbn());
            st.setString(2, books.getTitle());
            st.setString(3, books.getAuthors());
            st.setFloat(4, books.getPrice());
            st.execute();
        } catch (ClassNotFoundException ex) {
            System.out.println("Class Not Found " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQL Exception " + ex.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BooksDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
