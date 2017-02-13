/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Road;

/**
 *
 * @author Raffan
 */
public class SqliteSession {
    private Connection connection;

    public SqliteSession(Connection connection) {
        this.connection = connection;
    }
    
    public List executeQuery(String query){
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            statement = connection.createStatement();            
            resultSet = statement.executeQuery(query);
            ResultSetMetaData meta = resultSet.getMetaData();
            int columnCount = meta.getColumnCount();
            ArrayList<Object[]> ret = new ArrayList<>();
            while(resultSet.next()){
                Object[] row = new Object[columnCount];
                for(int i=0; i<columnCount; i++){
                    row[i] = resultSet.getObject(i+1);
                }
                ret.add(row);
            }
            
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        } finally {
            try {
                resultSet.close();
                statement.close();
                closeConnection();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public List<Road> getRoads(String query){
        List<Object[]> res = executeQuery(query);
        List<Road> roads = new ArrayList<>();
        for(Object[] row: res){
            try{
                Integer id = (Integer) row[0];
                String lineArId = (String) row[1];
                String fullName = (String) row[2];
                String rtType = (String) row[3];
                String mtfCc = (String) row[4];
                byte[] geometry = (byte[]) row[5];
                String asText = (String) row[6];
                Road road = new Road(id, lineArId, fullName, rtType, mtfCc, geometry, asText);
                roads.add(road);
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        return roads;
    }
    
    public void closeConnection(){
        if(connection!=null){
            try{
                connection.close();
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}
