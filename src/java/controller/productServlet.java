/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
import model.Product;
import model.productDao;

/**
 *
 * @author Rheo
 */
public class productServlet extends HttpServlet {
    
    private productDao productdao;

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String errorString = null;
        List<Product> list = null;
        
        try {
            Connection conn;
            conn = database.getMySQLConnection();
            
            list = productDao.queryProduct(conn);
        } catch (ClassNotFoundException | SQLException e) {
            errorString = e.getMessage();
        }
        
        request.setAttribute("errorString", errorString);
        request.setAttribute("product", list);
        RequestDispatcher  dispatcher = request.getServletContext().getRequestDispatcher("/view/items.jsp");
        dispatcher.forward(request, response);
        
        
    }

    

}
