/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import model.Oogmeting;
import controller.database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class oogmetingDao {
    
      public static List<Oogmeting> queryOogmeting(Connection conn) throws SQLException {
        String sql = "Select * From oogmeting INNER JOIN klanten ON oogmeting.klant_id = klanten.id";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Oogmeting> list = new ArrayList<Oogmeting>();
         while (rs.next()) {
                Oogmeting oogmeting = new Oogmeting();
                oogmeting.setId(rs.getInt("id"));
                oogmeting.setVoornaam(rs.getString("voornaam"));
                oogmeting.setAchternaam(rs.getString("achternaam"));
                oogmeting.setBreekkracht(rs.getString("breekkracht"));
                oogmeting.setBrekingshoek(rs.getString("brekingshoek"));
                oogmeting.setSterkte(rs.getString("sterkte"));
                
               list.add(oogmeting);
         }
        return list;
    }
      
      public static List<Oogmeting> queryKlantOogmeting(Connection conn,String code) throws SQLException {
        String sql = "Select * From oogmeting INNER JOIN klanten ON oogmeting.klant_id = klanten.id where klant_id=? ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setString(1, code);
 
        ResultSet rs = pstm.executeQuery();
        List<Oogmeting> list = new ArrayList<Oogmeting>();
         while (rs.next()) {
                Oogmeting oogmeting = new Oogmeting();
                oogmeting.setId(rs.getInt("id"));
                oogmeting.setVoornaam(rs.getString("voornaam"));
                oogmeting.setAchternaam(rs.getString("achternaam"));
                oogmeting.setBreekkracht(rs.getString("breekkracht"));
                oogmeting.setBrekingshoek(rs.getString("brekingshoek"));
                oogmeting.setSterkte(rs.getString("sterkte"));
                
                
               list.add(oogmeting);
         }
        return list;
          
                
    }
      
      public static void insertOogmeting(Connection conn, Oogmeting oogmeting) throws SQLException {
        String sql = "Insert into oogmeting(klant_id, breekkracht,brekingshoek,sterkte) values (?,?,?,?)";
 
        PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        pstm.setInt(1, oogmeting.getKlant_id());
        pstm.setString(2, oogmeting.getBreekkracht());
        pstm.setString(3,  oogmeting.getBrekingshoek());
        pstm.setString(4,  oogmeting.getSterkte());

        pstm.executeUpdate();
    }


    
}