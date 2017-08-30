package db;

import db.models.UserDao;

import java.util.List;

/**
 * Created by Andrey on 30.08.2017.
 */
public class UsersController {
    public List<UserDao> getAll(){
        return null;
    }

    public void create(){
String sql = "INSERT INTO wp_git users(email, passwd) VALUES('" + email + "', 'password');"
    }

    public  void delete(){

    }
}
