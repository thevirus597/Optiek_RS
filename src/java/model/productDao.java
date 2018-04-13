/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viresh
 */
public class productDao {
    public static List<Product> queryProduct(Connection conn) throws SQLException {
    String sql = "Select * From producten ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Product> list = new ArrayList<Product>();
         while (rs.next()) {
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setMerk(rs.getString("merk"));
                product.setType(rs.getString("type"));
                product.setNaam(rs.getString("naam"));
                product.setQty(rs.getInt("qty"));
                
               list.add(product);
         }
        return list;
}
    public static void insertProduct(com.mysql.jdbc.Connection conn, Product product) throws SQLException {
        String sql = "Insert into producten(type, merk,qty,naam) values (?,?,?,?)";
 
        com.mysql.jdbc.PreparedStatement pstm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setString(1, product.getType());
        pstm.setString(2, product.getMerk());
        pstm.setInt(3,  product.getQty());
        pstm.setString(4,  product.getNaam());

        pstm.executeUpdate();
    }

    
}