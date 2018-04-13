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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author viresh
 */
public class deleteKlantServlet extends HttpServlet {

    public deleteKlantServlet() {
    super();
    }

 
  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Connection conn;
        String code = (String) request.getParameter("code");
        String errorstring = null;
        
        try{
            conn = database.getMySQLConnection();
            KlantDao.deleteKlant((com.mysql.jdbc.Connection) conn, code);
        
       
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(deleteKlantServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(deleteKlantServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        if(errorstring!=null){
            request.setAttribute("errorString", errorstring);
            RequestDispatcher dispatcher = request.getServletContext()
                    .getRequestDispatcher("/WEB-INF/view/deleteKlantErrorView.jsp");
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect(request.getContextPath() +"/klanten");
        }
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        doGet(request,response);
       
    }

}