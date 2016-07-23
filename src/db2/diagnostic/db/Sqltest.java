/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db2.diagnostic.db;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Rasit
 */
public class Sqltest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        MysqlConnect x = MysqlConnect.getDbCon();
        ResultSet result = x.query("select * from systems");
        
       
        while (result.next())
      {
        int id = result.getInt("id");
        String sid = result.getString("sid");
        String customer = result.getString("customer");
        
        
        // print the results
        System.out.println(id +' '+ sid +' '+ customer);
      }
      
    }
    
}
