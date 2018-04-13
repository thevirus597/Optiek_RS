/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Oogmeting;
import model.oogmetingDao;
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
@WebServlet(name = "InsertOogmeting", urlPatterns = {"/InsertOogmeting"})
public class insertOogmetingServlet extends HttpServlet {

 
  
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
        String breekkracht = (String) request.getParameter("breekkracht");
        String brekingshoek = (String) request.getParameter("brekingshoek");
        String sterkte = (String) request.getParameter("sterkte");
        
        try {
            conn = database.getMySQLConnection();
            
            String errorString = null;
        Oogmeting oogmeting;
        oogmeting = new Oogmeting(klant,breekkracht,brekingshoek,sterkte);
         if (errorString == null) {
             oogmetingDao.insertOogmeting((com.mysql.jdbc.Connection) conn, oogmeting);
             
             if (errorString == null) {
            response.sendRedirect(request.getContextPath() + "/oogmeting");
            request.setAttribute("errorString", errorString);
        request.setAttribute("oogmeting", oogmeting);
        }
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertOogmetingServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertOogmetingServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

        
        
         
          
        
 
        // Store infomation to request attribute, before forward to views.
        
       
    }

}