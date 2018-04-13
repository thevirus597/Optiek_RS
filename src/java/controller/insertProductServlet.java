/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Product;
import model.productDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viresh
 */
@WebServlet(name = "InsertProduct", urlPatterns = {"/InsertProduct"})
public class insertProductServlet extends HttpServlet {

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        
        String type = (String) request.getParameter("type");
        String merk = (String) request.getParameter("merk");
        String strqty = (String) request.getParameter("qty");
        int qty = Integer.parseInt(strqty);        
        String naam = (String) request.getParameter("naam");
        
        try {
            conn = database.getMySQLConnection();
            
            String errorString = null;
        Product product;
        product = new Product(type,merk,qty,naam);
         if (errorString == null) {
             productDao.insertProduct((com.mysql.jdbc.Connection) conn, product);
             
             if (errorString == null) {
            response.sendRedirect(request.getContextPath() + "/product");
            request.setAttribute("errorString", errorString);
        request.setAttribute("product", product);
        }
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

        
        
         
          
        
 
        // Store infomation to request attribute, before forward to views.
        
       
    }

}