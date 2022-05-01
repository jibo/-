package com.company;

public class LoginUserDao {
    private static final String FileName = "d:\\LocalUserMessage\\UserMessage.txt";
    private static final String FileName1 = "d:\\LocalUserMessage\\UserMessage1.txt";
    public static User read(User user) {
        String content = FileTool.read(FileName);
        String[] items = content.split(",");
        String name = items[0];
        String s = items[1];
        int passWord = Integer.parseInt(s);
        return new User(name,passWord);
    }
    public static void write(User user) {

        FileTool.write(FileName1, "用户名为：" + user.getUserName() +
                "," + "密码为：" + user.getPassWord() + "\n",true);
        System.out.println("用户已保存！");
    }

}
