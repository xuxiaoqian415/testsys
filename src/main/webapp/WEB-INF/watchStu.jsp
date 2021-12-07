<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生信息</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
    <link href="../css/creat.css" rel="stylesheet">
</head>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <%@include file="t_leftbar.jsp"%>
    <div class="right-content fl">
        <%@include file="t_inf.jsp"%>
        <div style="margin: 10px 0px 10px 20px"><a href="tClasses" style="color: black; text-decoration: none">返回</a></div>
        <div class="list-title">学生列表</div>
        <div class="table">
            <table border="2px" cellspacing="0">
                <tr><th>学号</th><th>姓名</th><th>手机号</th><th>邮箱</th></tr>
                <c:forEach items="${users}" varStatus="i" var="u">
                <tr  width="50">
                    <td>${u.id}</td>
                    <td>${u.name}</td>
                    <td>${u.phone}</td>
                    <td>${u.email}</td>
                </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    </div>
    <div class="loginOut"><a href="logOut">登出</a></div>
</div>
</body>
</html>
