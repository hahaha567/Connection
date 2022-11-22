package org.example;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

public class Util {

    public boolean isConnection(String username, String password){
        try {
            URL testurl = new URL("https://www.baidu.com/");
            testurl.openConnection().connect();
            System.out.println(new Date()+" -> 网络连接正常");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            // 未连接网络,访问https://lgn.bjut.edu.cn/
            System.out.println(new Date()+" -> 网络连接异常，进行重新连接");
            WebClient webClient = new WebClient();
            try {
                HtmlPage htmlPage = webClient.getPage("https://lgn.bjut.edu.cn/");
                HtmlForm htmlForm = htmlPage.getFormByName("form1");
                // 输入用户名
                HtmlTextInput usernameInput = htmlForm.getInputByName("DDDDD");
                usernameInput.setValueAttribute(username);
                // 输入密码
                HtmlPasswordInput passwordInput = htmlForm.getInputByName("upass");
                passwordInput.setValueAttribute(password);
                // 点击登录
                HtmlSubmitInput htmlSubmitInput = htmlForm.getInputByName("0MKKey");
                htmlSubmitInput.click();
                System.out.println("网络连接成功");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }catch (ElementNotFoundException elementNotFoundException){
                // 可能已经自动登录成功，再次访问会找不到标签元素
                elementNotFoundException.printStackTrace();
            }
        }

        return true;
    }

}
