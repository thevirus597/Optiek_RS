/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Verkoop;
import model.verkoopDao;
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
@WebServlet(name = "InsertVerkoop", urlPatterns = {"/InsertVerkoop"})
public class insertVerkoopServlet extends HttpServlet {

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        
        String strklant = (String) request.getParameter("klant");
        int klant = Integer.parseInt(strklant);
        String strproduct = (String) request.getParameter("product");
        int product = Integer.parseInt(strproduct);
        String datum = (String) request.getParameter("datum");
       
        
        try {
            conn = database.getMySQLConnection();
            
            String errorString = null;
        Verkoop verkoop;
        verkoop = new Verkoop(klant,product,datum);
         if (errorString == null) {
             verkoopDao.insertVerkoop((com.mysql.jdbc.Connection) conn, verkoop);
             
             if (errorString == null) {
            response.sendRedirect(request.getContextPath() + "/verkoop");
            request.setAttribute("errorString", errorString);
        request.setAttribute("verkoop", verkoop);
        }
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertVerkoopServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertVerkoopServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

        
        
         
          
        
 
        // Store infomation to request attribute, before forward to views.
        
       
    }

}