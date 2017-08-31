package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by DWork on 30.08.2017.
 */
public class DataBaseConnector {

    private static DataBaseConnector instance;
    private Connection connection;

    private DataBaseConnector() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wordpress", "root", "");
        } catch (Exception ex) {
            throw new RuntimeException("Unable to connect to DB", ex);
        }
    }

    public static DataBaseConnector getInstanse() {
        if (instance == null) {
            instance = new DataBaseConnector();
        }
        return instance;
    }

    public void execute(String sql) {
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        }catch(Exception ex){
            throw  new RuntimeException("Unable to execute query", ex);
        }
    }

    public ResultSet executeQuery(String sql) {
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        }catch(Exception ex){
            throw  new RuntimeException("Unable to execute query", ex);
        }
    }

    protected void finalize() {
        try {
            connection.close();
        } catch (Exception ex) {
            throw new RuntimeException("Connection to DB wasn't closed", ex);
        }
    }
}
