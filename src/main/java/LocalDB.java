import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Created by Andrey on 28.08.2017.
 */
public class LocalDB {
    public static void main(String[] args) throws  Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:testdb");
        Statement statement = connection.createStatement();
        //statement.execute("CREATE TABLE users(id INTEGER PRIMARY KEY, email TEXT, passwd TEXT)");  - in first run creates a Table

        for (int i = 0; i< 10; i++){
            //String email = "text" + System.currentTimeMillis() + "@gmail.com"; - it's an alternative
            String email = "text" + i + "@gmail.com";
            statement.execute("INSERT INTO users");
        }
        connection.close();
    }
}
