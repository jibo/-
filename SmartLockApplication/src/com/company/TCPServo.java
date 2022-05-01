package com.company;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServo {
    public static void main(String[] args) throws IOException {
        //1、创建ServerSocket对象，和系统要指定的端口号
        ServerSocket server = new ServerSocket(8888);
        //2、使用ServerSocket对象中的accept方法来获取请求的客户端Socket对象
        Socket socket = server.accept();
        //3、使用Socket中的方法getInputStream，获取网络字节输入流InputStream对象
        InputStream is = socket.getInputStream();
        //4、判断D:\\upload文件夹是否存在，不存在创建
        File file = new File("d:\\ServerUserMessage");
        if (!file.exists()){
            file.mkdir();
        }
        //5、创建本地字节输出流FileOutputStream对象，构造方法中绑定要输出的目的地
        FileOutputStream fos = new FileOutputStream(file + "\\ServerUserMessages.txt");
        int len = 0;
        byte[] bytes = new byte[1024];
        //6、使用网络字节输入流InputStream对象中的方法read读取客户端上传的文件
        while ((len = is.read(bytes)) != -1) {
            //7、使用本地字节输出流对象OutputStream对象的write方法，把读取的方法保存到服务器硬盘上
            fos.write(bytes,0,len);
        }
        //8、使用Socket中的方法getOutputStream，获取网络字节输出流OutputStream对象
        //9、使用OutputStream对象的write方法给客户端回写数据
        socket.getOutputStream().write("上传成功".getBytes());
        //10、释放资源（FileOutputStream,Socket,ServerSocket）
        fos.close();
        socket.close();
        server.close();
    }
}
