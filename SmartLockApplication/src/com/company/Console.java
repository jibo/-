package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {
    //创建一个集合，定义为公有的
    static ArrayList<User> users=new ArrayList<User>();
    public User ExceptionInput(User users){
        return users;
    }
    public User inputA()throws Exception{
        String name = input("请输入用户姓名：");
        int password = inputI("请输入用户密码：");
        User user = new User(name,password);
        return user;
    }
    public void regist(User user) {
        // TODO Auto-generated method stub
        users.add(user);

    }
    public String input(String tent) {
        System.out.println(tent);
        Scanner scanner = new Scanner(System.in);
        String user = scanner.next();
        return user;
    }
    public int inputI(String tent){
        System.out.println(tent);
        Scanner scanner = new Scanner(System.in);
        int user = scanner.nextInt();
        return user;
    }
    public void output() {
        for (User user : users) {
            System.out.println("用户名列表如下=========================》");
            System.out.println("用户名为：" + user.getUserName());
            System.out.println("当前用户密码为：" + user.getPassWord());
        }
    }
}
