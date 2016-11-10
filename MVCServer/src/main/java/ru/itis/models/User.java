package ru.itis.models;

import com.google.common.base.MoreObjects;

public class User {
    private int userId;
    private String userName;
    private String userLogin;
    private int userPassword;
    private String userToken;

    public User(int userId, String userName, String userLogin, int userPassword, String userToken) {
        this.userId = userId;
        this.userName = userName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.userToken = userToken;
    }

    public User(String userName, String userLogin, int userPassword) {
        this.userName = userName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserLogin() {
        return userLogin;
    }

    public int getUserPassword() {
        return userPassword;
    }

    public String getUserToken() {
        return userToken;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("ID", this.getUserId())
                .add("Name", this.getUserName())
                .toString();
    }
}
