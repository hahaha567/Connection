package org.example;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;

public class Main {

    public static void main(String[] args) {
        Util util = new Util();
        while(true){
            util.isConnection();
            try {
                Thread.sleep(3600000); //每一小时测试一次
                //Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
