package com.company;

public class ConsoleA extends Console{
    public User ExceptionInput(User users){
        do {
            try{
                users = inputA();
                break;
            } catch(Exception e){
//            e.printStackTrace();
            }
            System.out.println("输入密码格式不对！重新输入试一试！");
        }while (true);
        return users;
    }

    public User inputA() throws Exception {     //重写父类方法
            String name = super.input("请输入用户姓名");
            int password = (int)super.inputI("请输入用户密码");
            if (password < 0){
                throw new Exception("密码不应为负数！");
            }else {
               User user = new User(name,password);
               return user;
            }
        }
}
