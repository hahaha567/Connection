# Connection
北京工业大学校园网自动连网Demo
使用步骤：
1.在Util.java文件中填入校园网登录的用户名和密码
2.运行Main.java文件或者转成jar包在命令提示行里运行
代码流程：
每一个小时检查一次网络连接，如果未连网，就会访问 https://lgn.bjut.edu.cn/ ，填入用户名和密码并进行连接
