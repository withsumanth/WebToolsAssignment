/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import java.util.HashSet;
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
public class SavingCartController extends AbstractController {
    
    public SavingCartController() {
    }
    
    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        HttpSession session = request.getSession();
        String action = request.getParameter("action");
        HashSet<String> cart;
        if(action==null){
            if (request.getParameter("add").equals("add")) {
			if (null != session.getAttribute("cartValues")) {
				cart = (HashSet<String>) session.getAttribute("cartValues");
			} else {
				cart = new HashSet();
			}
			String[] val = request.getParameterValues("cartVal");
			if(val!=null) {
				for (String v : val) {
					cart.add(v);
				}
				session.setAttribute("cartValues", cart);
			}
                        return new ModelAndView("index");
		} else if (request.getParameter("add").equals("remove")) {
			HashSet<String> cartRemove = new HashSet();
			cartRemove = (HashSet) session.getAttribute("cartValues");
			String[] val = request.getParameterValues("removedCart");
			if(val!=null) {
				for (String v : val) {
					for (String cart1 : cartRemove) {
						if (cart1.equals(v)) {
							cartRemove.remove(cart1);
							break;
						}
					}
				}
				session.setAttribute("cartValues", cartRemove);
			}
                        return new ModelAndView("index");
		}
        }else if(action.equals("cart")){
            if (null != session.getAttribute("cartValues")) {
				cart = (HashSet<String>) session.getAttribute("cartValues");
			} else {
				cart = new HashSet();
			}
            return new ModelAndView("cart");
        }else if(action.equals("books")){
            if (null != session.getAttribute("cartValues")) {
				cart = (HashSet<String>) session.getAttribute("cartValues");
			} else {
				cart = new HashSet();
			}
            return new ModelAndView("books");
        }else if(action.equals("computers")){
            if (null != session.getAttribute("cartValues")) {
				cart = (HashSet<String>) session.getAttribute("cartValues");
			} else {
				cart = new HashSet();
			}
            return new ModelAndView("computer");
        }else if(action.equals("music")){
            if (null != session.getAttribute("cartValues")) {
				cart = (HashSet<String>) session.getAttribute("cartValues");
			} else {
				cart = new HashSet();
			}
            return new ModelAndView("music");
        }else if(action.equals("home")){
            if (null != session.getAttribute("cartValues")) {
				cart = (HashSet<String>) session.getAttribute("cartValues");
			} else {
				cart = new HashSet();
			}
            return new ModelAndView("index");
        }
		
                return null;
    }
    
}
