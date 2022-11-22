package org.example;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

import java.io.Console;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Util util = new Util();
        Console console = System.console();
        System.out.println("请输入用户名：");
        String username = console.readLine();
        System.out.println("请输入密码(不显示)：");
        String password = new String(console.readPassword());
        while(true){
            util.isConnection(username, password);
            try {
                // 每一小时测试一次
                Thread.sleep(3600000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
