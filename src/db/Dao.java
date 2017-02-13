/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.sqlite.SQLiteConfig;

/**
 *
 * @author Raffan
 */
public class Dao {
    
    public static SqliteSession getSession(String filename)
    {
        try{
            //String filename = "tiger.sqlite";
            SQLiteConfig config = new SQLiteConfig();
            config.enableLoadExtension(true);
            String connUrl = "jdbc:sqlite:"+filename;
            System.out.println("Connection url: "+connUrl);
            Connection connection = DriverManager.getConnection(connUrl, config.toProperties());
            System.out.println("Connection created");
            
            Statement statement = connection.createStatement();            
            statement.execute("SELECT load_extension('mod_spatialite')");
            
            return new SqliteSession(connection);
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public static void close(SqliteSession session){
        if(session!=null){
            session.closeConnection();
        }
    }
}
