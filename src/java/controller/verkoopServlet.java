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
 * @author Rheo
 */
public class verkoopServlet extends HttpServlet {
    
  private verkoopDao verkoopdao;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorString = null;
        List<Verkoop> list = null;
        
        try {
            Connection conn;
            conn = database.getMySQLConnection();
            
            list = verkoopDao.queryVerkoop((com.mysql.jdbc.Connection) conn);
        } catch (ClassNotFoundException | SQLException e) {
            errorString = e.getMessage();
        }
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("verkoop", list);
        RequestDispatcher  dispatcher = request.getServletContext().getRequestDispatcher("/view/verkoop.jsp");
        dispatcher.forward(request, response);
        
        
    }

    

}
