package db;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by DWork on 30.08.2017.
 */
public class DataBaseConnector {

    private static DataBaseConnector instance;

    private DataBaseConnector() {
        Connection connection = DriverManager.getConnection("", "", "");
    }

    public static DataBaseConnector getInstanse() {
        if (instance == null){
            instance = new DataBaseConnector();
        }
        return  instance;
    }
}
