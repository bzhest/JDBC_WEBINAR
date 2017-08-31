package db;

import db.models.UserDao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Andrey on 30.08.2017.
 */
public class UsersController {
    public List<UserDao> getAll() {
        return null;
    }

    public String create() {
        String login = "Andrey" + System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = sdf.format(new Date());
        String sql = "INSERT INTO wp_users(user_login, user_pass, user_email, user_status, user_registered) VALUES('" + login + "', '$P$BD/h.67.vC6QCXHc8yHEkNFK3deb3i.', '"+ login + "@gmail.com" + "', '0', '" + date +"');";
        DataBaseConnector.getInstanse().execute(sql);

        return login + "@gmail.com";
    }


    public void delete(String email) {
        String sql = "DELETE FROM wp_users WHERE wp_users.user_email = '"+ email + "';";
        DataBaseConnector.getInstanse().execute(sql);

    }
}
