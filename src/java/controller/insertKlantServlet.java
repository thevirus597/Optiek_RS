/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Klant;
import model.KlantDao;
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
@WebServlet(name = "InsertKlant", urlPatterns = {"/InsertKlant"})
public class insertKlantServlet extends HttpServlet {

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        
        String id_number = (String) request.getParameter("id");
        String name = (String) request.getParameter("name");
        String surname = (String) request.getParameter("surname");
        String birthday = (String) request.getParameter("birthday");
        String gender = (String) request.getParameter("gender");
        
        try {
            conn = database.getMySQLConnection();
            
            String errorString = null;
        Klant klant;
        klant = new Klant(id_number,name,surname,birthday,gender);
         if (errorString == null) {
             KlantDao.insertKlant((com.mysql.jdbc.Connection) conn, klant);
             
             if (errorString == null) {
            response.sendRedirect(request.getContextPath() + "/klanten");
            request.setAttribute("errorString", errorString);
        request.setAttribute("klant", klant);
        }
        }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(insertKlantServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(insertKlantServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    

        
        
         
          
        
 
        // Store infomation to request attribute, before forward to views.
        
       
    }

}