/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import model.Klant;
import controller.database;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
;
/**
 *
 * @author Viresh
 */
public class KlantDao {

      public static List<Klant> queryKlant(Connection conn) throws SQLException {
        String sql = "Select * From klanten ";
 
          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Klant> list = new ArrayList<Klant>();
         while (rs.next()) {
                Klant klant = new Klant();
                klant.setId(rs.getInt("id"));
                klant.setName(rs.getString("voornaam"));
                klant.setSurname(rs.getString("achternaam"));
                klant.setId_number(rs.getString("id_nummer"));
                klant.setGender(rs.getString("geslacht"));
                klant.setBirthday(rs.getString("geboorte_datum"));
                
               list.add(klant);
         }
        return list;
    }
        public static void insertKlant(Connection conn, Klant klant) throws SQLException {
          String sql = "Insert into klanten(id_nummer, voornaam,achternaam,geboorte_datum,geslacht) values (?,?,?,?,?)";

          PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);

          pstm.setString(1, klant.getId_number());
          pstm.setString(2, klant.getName());
          pstm.setString(3,  klant.getSurname());
          pstm.setString(4,  klant.getBirthday());
          pstm.setString(5,  klant.getGender());

          pstm.executeUpdate();
      }
      
              public static void deleteKlant(Connection conn, String code) throws SQLException {
              
              String sql = "DELETE FROM klanten WHERE id = ?";
              
              PreparedStatement pstm = (PreparedStatement) conn.prepareStatement(sql);
              
              pstm.setString(1, code);
                           
              pstm.executeUpdate();
             
              }
   

   
}


//{
//            
//        }
