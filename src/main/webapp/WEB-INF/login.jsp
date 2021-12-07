<%--
  Created by IntelliJ IDEA.
  User: 10657
  Date: 2021/6/30
  Time: 19:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.bootcss.com/twitter-bootstrap/4.4.1/css/bootstrap.css" rel="stylesheet">
    <style>
        .main {
            width: 100%;
            height: 100%;
            position: fixed;
        }
        .login{
            margin-top: 10%;
            background: rgba(255,255,255,0.9);
            width: 25%;
            position: absolute;
            margin-left: 37%;
            padding: 20px;
        }
        .form-group2{
            width: 200px;
            margin-left: 250px;
        }
        .sub{
            font-weight: bold;
            size: 100px ;
        }
    </style>
    <title>登录</title>
</head>
<body>
<%@ include file="top1.jsp" %>
<div class="main">
    <div style="position:absolute;width:100%;height:100%;top:0px;left:0px;z-index:-1"><img src="images/login.jpg" width=100% height=100%></div>
    <div class="login">
        <form class="container" action="login" method="post">
            <h1 align="center" style="font-weight: bold">用户登录</h1>
            <div class="form-group">
                <label>用户名</label>
                <input name="username" class="form-control" type="text" placeholder="请输入用户名" required>
            </div>
            <div class="form-group">
                <label>密码</label>
                <input name="psw" class="form-control" type="password" placeholder="请输入密码" required>
            </div>
            <div class="form-group">
                <label>类型&nbsp&nbsp&nbsp</label>
                <label><input type="radio" name="type" value="0">学生&nbsp&nbsp&nbsp</label>
                <label><input type="radio" name="type" value="1">教师&nbsp&nbsp&nbsp</label>
            </div>
            <div class="form-group2" >
                <input type="submit" class="sub" value="&nbsp&nbsp&nbsp登录&nbsp&nbsp&nbsp&nbsp"  >
            </div>
        </form>
        <h5 align="center">${info_log}</h5>
        <h6>还没有账户？去<a href="register">注册-></a></h6>
    </div>
</div>
</body>
</html>
