/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.tags;

import com.me.pojo.Sales;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Sumanth
 */
public class SalesTagHandler extends SimpleTagSupport {

    private String fileName;

    /**
     * Called by the container to invoke this tag. The implementation of this
     * method is provided by the tag library developer, and handles all tag
     * processing, body iteration, etc.
     */
    @Override
    public void doTag() throws JspException {
        JspWriter out = getJspContext().getOut();

        try {
            JspFragment f = getJspBody();
            if (f != null) {
                f.invoke(out);
            }
            ArrayList<Sales> data = new ArrayList();
            Statement stmt = null;
            Connection conn = null;
            int count = 0;
            try {
                Class.forName("org.relique.jdbc.csv.CsvDriver");
                conn = DriverManager.getConnection("jdbc:relique:csv:E:\\NEUSemester2\\Web Tools");
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM " + fileName);
                while (rs.next()) {
                    count++;
                    Sales s = new Sales();
                    s.setSalesOrderID(rs.getInt("SalesOrderID"));
                    s.setRevisionNumber(rs.getInt("RevisionNumber"));
                    s.setOrderDate(new Date(rs.getString("OrderDate")));
                    s.setDueDate(new Date(rs.getString("DueDate")));
                    s.setShipDate(new Date(rs.getString("ShipDate")));
                    s.setStatus(rs.getInt("Status"));
                    s.setOnlineOrderFlag(rs.getInt("OnlineOrderFlag"));
                    s.setSalesOrderNumber(rs.getString("SalesOrderNumber"));
                    s.setPurchaseOrderNumber(rs.getString("PurchaseOrderNumber"));
                    s.setAccountNumber(rs.getString("AccountNumber"));
                    s.setCustomerID(rs.getInt("CustomerID"));
                    s.setSalesPersonID(rs.getInt("SalesPersonID"));
                    s.setBillToAddressID(rs.getInt("BillToAddressID"));
                    s.setShipToAddressID(rs.getInt("ShipToAddressID"));
                    s.setShipMethodID(rs.getInt("ShipMethodID"));
                    s.setCreditCardID(rs.getInt("CreditCardID"));
                    s.setCreditCardApprovalCode(rs.getInt("CreditCardApprovalCode"));
                    s.setCurrencyRateID(rs.getInt("CurrencyRateID"));
                    s.setSubTotal(rs.getFloat("SubTotal"));
                    s.setTaxAmt(rs.getFloat("TaxAmt"));
                    s.setFreight(rs.getFloat("Freight"));
                    s.setTotalDue(rs.getFloat("TotalDue"));
                    s.setComment(rs.getString("Comment"));
                    s.setModifiedDate(new Date(rs.getString("ModifiedDate")));
                    data.add(s);
                }
            } catch (SQLException ex) {
                System.out.println("SqlException: " + ex.getMessage());
            } catch (ClassNotFoundException ex) {
                System.out.println("Class Not Found Exception: " + ex.getMessage());
            } finally {
                try {
                    if (conn != null) {
                        conn.close();
                    }
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException ex) {
                    System.out.println("SqlException: " + ex.getMessage());
                }
            }
            out.println("<form action='readcsv.htm' method='post'>");
            out.println("<table border='1px solid'>");
            out.println("<tr>");
            out.println("<th>SalesOrderID</th>");
            out.println("<th>RevisionNumber</th>");
            out.println("<th>OrderDate</th>");
            out.println("<th>DueDate</th>");
            out.println("<th>ShipDate</th>");
            out.println("<th>Status</th>");
            out.println("<th>OnlineOrderFlag</th>");
            out.println("<th>SalesOrderNumber</th>");
            out.println("<th>PurchaseOrderNumber</th>");
            out.println("<th>AccountNumber</th>");
            out.println("<th>CustomerID</th>");
            out.println("<th>SalesPersonID</th>");
            out.println("<th>TerritoryID</th>");
            out.println("<th>BillToAddressID</th>");
            out.println("<th>ShipToAddressID</th>");
            out.println("<th>ShipMethodID</th>");
            out.println("<th>CreditCardID</th>");
            out.println("<th>CreditCardApprovalCode</th>");
            out.println("<th>CurrencyRateID</th>");
            out.println("<th>SubTotal</th>");
            out.println("<th>TaxAmt</th>");
            out.println("<th>Freight</th>");
            out.println("<th>TotalDue</th>");
            out.println("<th>Comment</th>");
            out.println("<th>ModifiedDate</th>");
            out.println("</tr>");
            for (int i = 0; i < data.size(); i++) {
                out.println("<tr>");
                out.println("<td><input name='salesOrderID" + (i+1) + "' type='number' value='" + data.get(i).getSalesOrderID() + "' required='true'></td>");
                out.println("<td><input name='revisionNumber" + (i+1) + "' type='number' value='" + data.get(i).getRevisionNumber() + "' required='true'></td>");
                out.println("<td><input name='orderDate" + (i+1) + "' type='date' value='" + new SimpleDateFormat("yyyy-MM-dd").format(data.get(i).getOrderDate()) + "' required='true'></td>");
                out.println("<td><input name='dueDate" + (i+1) + "' type='date' value='" + new SimpleDateFormat("yyyy-MM-dd").format(data.get(i).getOrderDate()) + "' required='true'></td>");
                out.println("<td><input name='shipDate" + (i+1) + "' type='date' value='" + new SimpleDateFormat("yyyy-MM-dd").format(data.get(i).getShipDate()) + "' required='true'></td>");
                out.println("<td><input name='status" + (i+1) + "' type='number' value='" + data.get(i).getStatus() + "' required='true'></td>");
                out.println("<td><input name='onlineOrderFlag" + (i+1) + "' type='number' value='" + data.get(i).getOnlineOrderFlag() + "' required='true'></td>");
                out.println("<td><input name='salesOrderNumber" + (i+1) + "' type='text' value='" + data.get(i).getSalesOrderNumber() + "' required='true'></td>");
                out.println("<td><input name='purchaseOrderNumber" + (i+1)+ "' type='text' value='" + data.get(i).getPurchaseOrderNumber() + "' required='true'></td>");
                out.println("<td><input name='accountNumber" +(i+1) + "' type='text' value='" + data.get(i).getAccountNumber() + "' required='true'></td>");
                out.println("<td><input name='customerID" + (i+1) + "' type='number' value='" + data.get(i).getCustomerID() + "' required='true'></td>");
                out.println("<td><input name='salesPersonID" + (i+1) + "' type='number' value='" + data.get(i).getSalesPersonID() + "' required='true'></td>");
                out.println("<td><input name='territoryID" + (i+1) + "' type='number' value='" + data.get(i).getTerritoryID() + "' required='true'></td>");
                out.println("<td><input name='billToAddressID" + (i+1) + "' type='number' value='" + data.get(i).getBillToAddressID() + "' required='true'></td>");
                out.println("<td><input name='shipToAddressID" + (i+1) + "' type='number' value='" + data.get(i).getShipToAddressID() + "' required='true'></td>");
                out.println("<td><input name='shipMethodID" + (i+1) + "' type='number' value='" + data.get(i).getShipMethodID() + "' required='true'></td>");
                out.println("<td><input name='creditCardID" + (i+1) + "' type='number' value='" + data.get(i).getCreditCardID() + "' required='true'></td>");
                out.println("<td><input name='creditCardApprovalCode" + (i+1) + "' type='number' value='" + data.get(i).getCreditCardApprovalCode() + "' required='true'></td>");
                out.println("<td><input name='currencyRateID" + (i+1) + "' type='number' value='" + data.get(i).getCurrencyRateID() + "'></td>");
                out.println("<td><input name='subTotal" + (i+1) + "' type='number' value='" + data.get(i).getSubTotal() + "' step='0.0001' min='1' required='true'></td>");
                out.println("<td><input name='taxAmt" + (i+1) + "' type='number' value='" + data.get(i).getTaxAmt() + "' step='0.0001' min='1' required='true'></td>");
                out.println("<td><input name='freight" + (i+1) + "' type='number' value='" + data.get(i).getFreight() + "' step='0.0001' min='1' required='true'></td>");
                out.println("<td><input name='totalDue" + (i+1) + "' type='number' value='" + data.get(i).getTotalDue() + "' step='0.0001' min='1' required='true'></td>");
                out.println("<td><input name='comment" + (i+1) + "' type='text' value='" + data.get(i).getComment() + "'></td>");
                out.println("<td><input name='modifiedDate" + (i+1) + "' type='date' value='" + new SimpleDateFormat("yyyy-MM-dd").format(data.get(i).getModifiedDate()) + "' required='true'></td>");
                out.println("</tr>");
                }
                out.println("</table>");
                out.println("<input  type='hidden' name='hiddenField' value='"+data.size()+"'>");
                out.println("<input type='submit' value='Submit'>");
                out.println("</form>");
        } catch (java.io.IOException ex) {
            throw new JspException("Error in SalesTagHandler tag", ex);
        }
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
