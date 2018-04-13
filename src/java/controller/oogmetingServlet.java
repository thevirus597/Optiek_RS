  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Oogmeting;
import model.oogmetingDao;
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



 

public class oogmetingServlet extends HttpServlet {

    private oogmetingDao oogmetingDao;

    
   
    
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorString = null;
        List<Oogmeting> list = null;
        try {
            Connection conn = database.getMySQLConnection();
             
        
        list = oogmetingDao.queryOogmeting((com.mysql.jdbc.Connection) conn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(KlantenServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException e) {
            errorString = e.getMessage();
        }
        request.setAttribute("errorString", errorString);
        request.setAttribute("oogmeting", list);
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/view/oogmeting.jsp");
        dispatcher.forward(request, response);
        
    }
    }

    