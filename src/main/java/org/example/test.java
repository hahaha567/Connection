package org.example;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.*;

import java.io.IOException;
import java.util.Date;

public class test {
    public static void main(String[] args) {
        while(true){
            connect();
        }
    }

    public static void connect(){
        System.out.println(new Date()+" -> 网络连接异常，进行重新连接");
        WebClient webClient = new WebClient();
        try {
            HtmlPage htmlPage = webClient.getPage("https://lgn.bjut.edu.cn/");
            HtmlForm htmlForm = htmlPage.getFormByName("form1");
            //输入用户名
            HtmlTextInput usernameInput = htmlForm.getInputByName("DDDDD");
            usernameInput.setValueAttribute("S202073123");
            //输入密码
            HtmlPasswordInput passwordInput = htmlForm.getInputByName("upass");
            passwordInput.setValueAttribute("6075656-Bjut");
            //点击登录
            HtmlSubmitInput htmlSubmitInput = htmlForm.getInputByName("0MKKey");
            htmlSubmitInput.click();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        catch (ElementNotFoundException elementNotFoundException){
            elementNotFoundException.printStackTrace();
        }
    }
}
