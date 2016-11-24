package models;

public class User {
    private int userId;
    private String userName;
    private String login;
    private int password;

    public User(){
    }

    public User(int userId, String userName, String login, int password) {
        this.userId = userId;
        this.userName = userName;
        this.login = login;
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
        this.password = password;
    }
}
