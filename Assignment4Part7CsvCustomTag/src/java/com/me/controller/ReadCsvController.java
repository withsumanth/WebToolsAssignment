/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.controller;

import com.me.dao.SalesDAO;
import com.me.pojo.Sales;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

/**
 *
 * @author Sumanth
 */
public class ReadCsvController extends AbstractController {

    public ReadCsvController() {
    }

    protected ModelAndView handleRequestInternal(
            HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        int noOfRows = Integer.parseInt(request.getParameter("hiddenField"));
        ModelAndView mv = null;
        SalesDAO salesDao = (SalesDAO) this.getApplicationContext().getBean("salesDao");
        Map<String, Object> map = new HashMap();
        for (int i = 0; i < noOfRows; i++) {
            Sales s = new Sales();
            s.setSalesOrderID(Integer.parseInt(request.getParameter("salesOrderID" + (i + 1))));
            s.setRevisionNumber(Integer.parseInt(request.getParameter("revisionNumber" + (i + 1))));
            s.setOrderDate(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("orderDate" + (i + 1))));
            s.setDueDate(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("dueDate" + (i + 1))));
            s.setShipDate(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("shipDate" + (i + 1))));
            s.setStatus(Integer.parseInt(request.getParameter("status" + (i + 1))));
            s.setOnlineOrderFlag(Integer.parseInt(request.getParameter("onlineOrderFlag" + (i + 1))));
            s.setSalesOrderNumber(request.getParameter("salesOrderNumber" + (i + 1)));
            s.setPurchaseOrderNumber(request.getParameter("purchaseOrderNumber" + (i + 1)));
            s.setAccountNumber(request.getParameter("accountNumber" + (i + 1)));
            s.setCustomerID(Integer.parseInt(request.getParameter("customerID" + (i + 1))));
            s.setSalesPersonID(Integer.parseInt(request.getParameter("salesPersonID" + (i + 1))));
            s.setBillToAddressID(Integer.parseInt(request.getParameter("billToAddressID" + (i + 1))));
            s.setShipToAddressID(Integer.parseInt(request.getParameter("shipToAddressID" + (i + 1))));
            s.setShipMethodID(Integer.parseInt(request.getParameter("shipMethodID" + (i + 1))));
            s.setCreditCardID(Integer.parseInt(request.getParameter("creditCardID" + (i + 1))));
            s.setCreditCardApprovalCode(Integer.parseInt(request.getParameter("creditCardApprovalCode" + (i + 1))));
            s.setCurrencyRateID(Integer.parseInt(request.getParameter("currencyRateID" + (i + 1))));
            s.setSubTotal(Float.parseFloat(request.getParameter("subTotal" + (i + 1))));
            s.setTaxAmt(Float.parseFloat(request.getParameter("taxAmt" + (i + 1))));
            s.setFreight(Float.parseFloat(request.getParameter("freight" + (i + 1))));
            s.setTotalDue(Float.parseFloat(request.getParameter("totalDue" + (i + 1))));
            s.setComment(request.getParameter("comment" + (i + 1)));
            s.setModifiedDate(new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("modifiedDate" + (i + 1))));
            salesDao.addSales(s);
        }
        map.put("readData", "finalPage");
        HttpSession session = request.getSession();
        session.setAttribute("noOfRows", noOfRows);
        mv = new ModelAndView("readcsv", "map", map);
        return mv;
    }

}
