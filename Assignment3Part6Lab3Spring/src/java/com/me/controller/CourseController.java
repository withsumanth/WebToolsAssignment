/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.java.Bean.Course;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sumanth
 */
public class CourseController extends AbstractController {

    List<Course> courseList;

    public CourseController() {
        courseList = new ArrayList<>();
        Course c1 = new Course();
        c1.setCourseDescription("java programming");
        c1.setCrn("36099");
        c1.setInstructor("Khaled M. Bugrara");
        c1.setName("AED");

        Course c2 = new Course();
        c2.setCourseDescription("Course fro learning web technologies used in frint end");
        c2.setCrn("37913");
        c2.setInstructor("YusufOzbek");
        c2.setName("Web Dsign and user exp");

        Course c3 = new Course();
        c3.setCourseDescription("course for learning algorithms");
        c3.setCrn("34267");
        c3.setInstructor("Khaled M. Bugrara");
        c3.setName("Program Structure and Algorithms");

        Course c4 = new Course();
        c4.setCourseDescription("course for learning java EE");
        c4.setCrn("31606");
        c4.setInstructor("YusufOzbek");
        c4.setName("Web Tools");

        courseList.add(c1);
        courseList.add(c2);
        courseList.add(c3);
        courseList.add(c4);
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        //this session will only be created when the user logs in. Otherwise do not create it.
        HttpSession session = request.getSession(false);
        Set<Course> myCourseSet;
        if (null != session.getAttribute("myCourseSet")) {
            myCourseSet = (Set<Course>) session.getAttribute("myCourseSet");
        } else {
            myCourseSet = new HashSet();
        }
        if (action.equals("add")) {
            String[] crn = request.getParameterValues("crn");
            if (crn != null) {
                for (String ccrn : crn) {
                    for (Course course : courseList) {
                        if (course.getCrn().equals(ccrn)) {
                            myCourseSet.add(course);
                        }
                    }
                }
            }
            session.setAttribute("myCourseSet", myCourseSet);
            return new ModelAndView("mycourses");
        } else if (action.equals("search")) {
            String searchType = request.getParameter("searchType");
            String searchQuery = request.getParameter("query");

            ArrayList<Course> searchResults = new ArrayList<Course>();
            if (searchType.equals("crn")) {
                for (Course course : courseList) {
                    if (course.getCrn().equals(searchQuery)) {
                        searchResults.add(course);
                    }
                }
            } else if (searchType.equals("title")) {
                for (Course course : courseList) {
                    if (course.getCourseDescription().contains(searchQuery) || course.getInstructor().contains(searchQuery) || course.getName().contains(searchQuery)) {
                        searchResults.add(course);
                    }
                }
            }
            request.setAttribute("searchResults", searchResults);
            return new ModelAndView("courseview");
        } else if (action.equals("remove")) {
            String[] val = request.getParameterValues("crn");
            for (String v : val) {
                for (Course c : myCourseSet) {
                    if (c.getCrn().equals(v)) {
                        myCourseSet.remove(c);
                        break;
                    }
                }
            }
            session.setAttribute("myCourseSet", myCourseSet);
            return new ModelAndView("mycourses");
        }else{
            return new ModelAndView("searchCourse");
        }
    }

}
