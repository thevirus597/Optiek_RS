/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Verkoop;
import model.verkoopDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author viresh
 */
public class KlantVerkoopServlet extends HttpServlet {
    
  private verkoopDao verkoopdao;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       Connection conn;
String code = (String) request.getParameter("code");
         String errorString = null;
        List<Verkoop> list = null;
        try {
             conn = database.getMySQLConnection();
             
        
        list = verkoopdao.queryKlantVerkoop((com.mysql.jdbc.Connection) conn, code);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlantenServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
             e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("verkoop", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/verkoop.jsp");
        dispatcher.forward(request, response);
        
        
    }

    

}
