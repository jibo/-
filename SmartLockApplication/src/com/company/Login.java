package com.company;

public class Login extends Console{
        public void local() {
        String name = input("请输入用户姓名：");
        int password = inputI("请输入用户密码：");
        for (User user : users) {
            if(name.equals(user.getUserName())&&password == user.getPassWord()){
                System.out.println("登陆成功！");
                return;
            }
        }
        System.out.println("登陆失败，不存在此用户！");
    }
}
