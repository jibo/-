package com.company;

public class User {
    private String userName;
    private int passWord;
    //构造方法，由IDE自动生成
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getPassWord() {
        return passWord;
    }
    public void setPassWord(int passWord) {
        this.passWord = passWord;
    }
    public User(String userName, int passWord) {
        super();
        this.userName = userName;
        this.passWord = passWord;
    }
    public User() {
        super();
    }
}