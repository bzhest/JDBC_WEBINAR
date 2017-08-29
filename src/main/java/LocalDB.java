import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by Andrey on 28.08.2017.
 */
public class LocalDB {
    public static void main(String[] args) throws  Exception {
        Connection connection = DriverManager.getConnection("jdbc:sqlite:testdb");
        Statement statement = connection.createStatement();
        ArrayList <User> user = new ArrayList<>();
        //statement.execute("CREATE TABLE users(id INTEGER PRIMARY KEY, email TEXT, passwd TEXT)");  - in first run creates a Table

        /*for (int i = 0; i< 10; i++){
            String email = "text" + System.currentTimeMillis() + "@gmail.com";
            statement.execute("INSERT INTO users(email, passwd) VALUES('" + email + "', 'password');");
        }*/

        ResultSet rs = statement.executeQuery("SELECT * FROM users;");
        while(rs.next()){
            //make mapping on User class
            user.add(new User(rs.getString("id"),
                              rs.getString("email"),
                              rs.getString("passwd")));
        }
        //System.out.println(user);
        statement.executeQuery("DELETE FROM users WHERE email = '"wewef"'")
        connection.close();
    }
}
