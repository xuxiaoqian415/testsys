<%--
  Created by IntelliJ IDEA.
  User: 10657
  Date: 2021/6/30
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        body {
            background: #eeeeee;
            margin: 0;
        }
        a {
            text-decoration: none;
            color: black;
        }
        .container {/* container：容器 */
            display: block;
            max-width: 1080px;
            margin: 0 auto;/* 上下外边距为 0，左右居中 */
        }
        .fr {
            float: right;
        }
        .clearf:after,
        .clearf:before {/* 用于去除父元素的浮动 */
            content: " ";
            display: block;
            clear: both;
        }
        .back {
            margin-top: 25px;
        }
        .register {
            margin-top: 30px;
            background: rgba(255,255,255,0.9);
            padding: 20px;
            height: 580px;
            -webkit-box-shadow: 0 0 2px 2px rgba(0,0,0,.2);
            box-shadow: 0 0 2px 2px rgba(0,0,0,.2);
            border-radius: 1%;/* radius：半径 */
            width: 70%;
            margin-left: 15%;
        }
        form {
            width: 50%;
            margin-left: 240px;
            margin-top: 50px;
        }
        form .a {
            margin-bottom: 20px;
            margin-left: 30px;
        }
        form .b {
            margin-top: 20px;
            margin-left: 210px;
        }
        label{
            color: crimson;
        }
    </style>
    <title>注册</title>
</head>
<body>
<%@ include file="top1.jsp" %>
<div class="main clearf">
    <div style="position:absolute;width:100%;height:100%;top:0px;left:0px;z-index:-1"><img src="images/login.jpg" width=100% height=100%></div>
    <div class="container clearf">
        <div class="register">
            <div class="back fr"><a href="login"><-返回首页</a></div>
            <h1 class="clearf" align="center">注册</h1>
            <form action="register" method="post">
                <div class="a">
                    <label>*</label>所在院校：<input type="text" name="school" maxlength="10" pattern="^[^0-9]*$" title="请输入正确的院校信息" required placeholder="请输入您的院校信息">
                </div>
                <div class="a">
                    <label>*</label>真实姓名：<input type="text" name="name" maxlength="10"  required placeholder="请输入您的真实姓名">
                </div>
                <div class="a">
                    <label>*</label>身份证号：<input type="text" name="idCard" maxlength="18" pattern="^([1-6][1-9]|50)\d{4}(18|19|20)\d{2}((0[1-9])|10|11|12)(([0-2][1-9])|10|20|30|31)\d{3}[0-9Xx]$" title="请输入正确的身份证信息" required placeholder="请输入正确的身份证信息">
                </div>
                <div class="a">
                    <label>*</label>用户名：&nbsp&nbsp&nbsp<input type="text" name="username" maxlength="10" placeholder="请输入您的用户名信息">
                </div>
                <div class="a">
                    <label>*</label>密码：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="password" name="password" maxlength="20"  pattern="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$" title="密码至少包含6-20位的数字和英文字符" required placeholder="请输入您的密码">
                </div>
                <div class="a">
                    <label>*</label>手机号：&nbsp&nbsp&nbsp<input type="text" name="phone" maxlength="20" pattern="^1[^012][0-9]([0-9]{8})" title="请输入正确的11位号码！" placeholder="请输入您的手机号码">
                </div>
                <div class="a">
                    <label>*</label>邮箱：&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name="email" maxlength="30" pattern="^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$" title="请输入正确的电子邮箱" required placeholder="请输入您的电子邮箱" >
                </div>
                <div class="a">
                    <label>*</label>身份：&nbsp&nbsp&nbsp&nbsp&nbsp<label style="color: black"><input type="radio" name="userType" value="0">学生</label>
                    <label style="color: black"><input type="radio" name="userType" value="1">教师</label>
                </div>
                <div class="b">
                    <input type="submit" value="&nbsp&nbsp&nbsp注册&nbsp&nbsp&nbsp">
                </div>
            </form>
            ${info_reg}
        </div>
    </div>
</div>
</body>
</html>
