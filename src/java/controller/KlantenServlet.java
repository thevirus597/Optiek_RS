  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Klant;
import model.KlantDao;
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



 

public class KlantenServlet extends HttpServlet {

    private KlantDao klantdao;

    
   
    
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorString = null;
        List<Klant> list = null;
        try {
            Connection conn = database.getMySQLConnection();
             
        
        list = KlantDao.queryKlant((com.mysql.jdbc.Connection) conn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlantenServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
             e.printStackTrace();
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("klanten", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/klanten.jsp");
        dispatcher.forward(request, response);
        
    }
    }

    