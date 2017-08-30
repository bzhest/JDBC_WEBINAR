package db.models;

/**
 * Created by Andrey on 30.08.2017.
 */
public class UserDao {
    private String id;
    private  String login;
    private String pass;
    private  String email;

    public UserDao(String id, String login, String pass, String email) {
        this.id = id;
        this.login = login;
        this.pass = pass;
        this.email = email;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
