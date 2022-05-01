package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
public class FileTool {
    public static String read(String fileName) {
        StringBuilder content = new StringBuilder();
        try (FileInputStream fileInput = new
                FileInputStream(fileName);
             InputStreamReader inputStreamReader = new
                     InputStreamReader(fileInput);) {
            while (inputStreamReader.ready()) {
                content.append((char) inputStreamReader.read());
            }
        } catch (IOException ex) {
        }
        return content.toString();
    }
    public static boolean write(String fileName, String content,boolean append) //追加文件
    {
        try (FileOutputStream fileOutput = new
                FileOutputStream(fileName,append);) {
            byte[] contentBytes = content.getBytes();
            fileOutput.write(contentBytes);
        } catch (IOException ex) {
            return false;
        }
        return true;
    }
}