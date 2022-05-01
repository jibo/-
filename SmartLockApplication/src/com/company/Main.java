package com.company;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        User user = new User();
        Console console = new ConsoleA(); //父类引用指向子类
        boolean flag = true;
        while(flag) {
            Menu.show();
            Scanner sc = new Scanner(System.in);
            int num = sc.nextInt();
            switch(num) {
                case 1:
                    user = console.ExceptionInput(user);
                    console.regist(user);
                    LoginUserDao.write(user);

                    break;
                case 2:
                    console.output();
                    break;
                case 3:
                    Login login = new Login();
                    login.local();
                    break;
                case 4:
                    User user1 = LoginUserDao.read(user);
                    console.regist(user1);
                    LoginUserDao.write(user1);
                    break;
                case 5:
                    //1、创建一个本地字节输入流FileInputStream，构造方法中绑定要读取的数据源
                    FileInputStream fis = new FileInputStream("d:\\LocalUserMessage\\UserMessage1.txt");
                    //2、创建一个Socket对象，构造方法中绑定服务器的IP地址和端口号
                    Socket socket = new Socket("127.0.0.1",8888);
                    //3、使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象
                    OutputStream os = socket.getOutputStream();
                    int len = 0;
                    byte[] bytes = new byte[1024];
                    //4、使用本地字节输入流FileInputStream对象中的方法read，读取本地文件。

                    /**
                     *         无法读到结束符,客户端与服务器端无终止
                     */
                    while ((len = fis.read(bytes)) != -1){ //有效长度
                        //5、使用网络字节输出流OutputStream对象中的方法write，把读取到的文件上传到服务器
                        os.write(bytes,0,len);
                    }
                    /**
                     * 对于无法读到结束符解决方案：
                     *       上传完文件以后，给服务器写一个结束标记
                     *       void shutdownOutput()禁用套接字的输出流
                     *       对于TCP套接字，任何以前写入的数据都将被送出，并且后跟TCP的正常连接终止序列。
                     */
                    socket.shutdownOutput();
                    //6、使用Socket对象的getInputStream，获取网络字节流InputStream对象
                    InputStream is = socket.getInputStream();
                    //7、使用网络字节输入流InputStream对象中的方法read读取服务器回写的数据
                    while ((len = is.read(bytes)) != -1){
                        System.out.println(new String(bytes,0,len));
                    }
                    //8、释放资源
                    fis.close();
                    socket.close();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}
