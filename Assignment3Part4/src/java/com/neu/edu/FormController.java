/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neu.edu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Sumanth
 */
public class FormController extends HttpServlet{
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String val1 = request.getParameter("val1");
        String val2 = request.getParameter("val2");
        String val3 = request.getParameter("val3");
        String val4 = request.getParameter("val4");
        ArrayList<String> values = new ArrayList<String>();
        values.add(val1);
        values.add(val2);
        values.add(val3);
        values.add(val4);
        request.setAttribute("values", values);
        request.setAttribute("date",new Date());
        RequestDispatcher rd  = request.getRequestDispatcher("/values.jsp");
        rd.forward(request, response);
    }
}
