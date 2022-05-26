package com.pravinsingh.foodie1.Modules;

public class User {

    String profilepic;
    String username;
    String email;
    String password;
    String mnumber;
    String userId;

    public User(String profilepic, String username, String email, String password, String mnumber, String userId) {
        this.profilepic = profilepic;
        this.username = username;
        this.email = email;
        this.password = password;
        this.mnumber = mnumber;
        this.userId = userId;
    }

    public User(String s, String toString, String string){};

    // signup constructor
    public User(String username, String email, String mnumber, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.mnumber = mnumber;
    }

    public User() {

    }


    public String getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(String profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMnumber() {
        return mnumber;
    }

    public void setMnumber(String mnumber) {
        this.mnumber = mnumber;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
