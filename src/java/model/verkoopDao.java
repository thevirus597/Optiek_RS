/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import model.Verkoop;
import controller.database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author viresh
 */
public class verkoopDao {
      public static List<Verkoop> queryVerkoop(Connection conn) throws SQLException {
        String sql = "Select * From aankopen INNER JOIN klanten ON aankopen.klant_id = klanten.id INNER JOIN producten ON aankopen.product_id = producten.id";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Verkoop> list = new ArrayList<Verkoop>();
         while (rs.next()) {
                Verkoop verkoop = new Verkoop();
                verkoop.setId(rs.getInt("id"));
                verkoop.setKlant_id(rs.getInt("klant_id"));
                verkoop.setProduct_id(rs.getInt("product_id"));
                verkoop.setDatum(rs.getString("datum"));
                verkoop.setVoornaam(rs.getString("voornaam"));
                verkoop.setAchternaam(rs.getString("achternaam"));
                verkoop.setProductNaam(rs.getString("naam"));
                
                                
               list.add(verkoop);
         }
        return list;
    }    public static List<Verkoop> queryKlantVerkoop(Connection conn,String code) throws SQLException {
        String sql = "Select * From aankopen INNER JOIN klanten ON aankopen.klant_id = klanten.id INNER JOIN producten ON aankopen.product_id = producten.id where klant_id=? ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
        List<Verkoop> list = new ArrayList<Verkoop>();
         while (rs.next()) {
                Verkoop verkoop = new Verkoop();
                verkoop.setId(rs.getInt("id"));
                verkoop.setKlant_id(rs.getInt("klant_id"));
                verkoop.setProduct_id(rs.getInt("product_id"));
                verkoop.setDatum(rs.getString("datum"));
                verkoop.setVoornaam(rs.getString("voornaam"));
                verkoop.setAchternaam(rs.getString("achternaam"));
                verkoop.setProductNaam(rs.getString("naam"));
                
                
               list.add(verkoop);
         }
        return list;
          
                
    }
    public static void insertVerkoop(com.mysql.jdbc.Connection conn, Verkoop verkoop) throws SQLException {
        String sql = "Insert into aankopen(klant_id, product_id, datum) values (?,?,?)";
 
        com.mysql.jdbc.PreparedStatement pstm = (com.mysql.jdbc.PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setInt(1, verkoop.getKlant_id());
        pstm.setInt(2, verkoop.getProduct_id());
        pstm.setString(3,  verkoop.getDatum());

        pstm.executeUpdate();
    }

    
}