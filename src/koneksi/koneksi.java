/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author albin
 */
public class koneksi {
    Connection connect;
    Statement sttmnt;
    ResultSet rslt;
    private static Connection koneksi;  
    public static Connection getKoneksi(){
        try{
            String url = "jdbc:mysql://localhost:3306/db_sidoma";
            String user = "root";
            String password = "";
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            koneksi = DriverManager.getConnection(url,user,password);
            System.out.println("Koneksi Database sukses ");
            
        }catch(SQLException e){
            System.out.println("Koneksi Database Gagal");
        }
return koneksi;
    
    }
 
    
   
//TUTUP CLASS KONEKSI
    
}
