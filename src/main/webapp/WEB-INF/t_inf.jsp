<%--
  Created by IntelliJ IDEA.
  User: 10657
  Date: 2021/7/1
  Time: 21:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .inf{
            margin:10px;
            position: absolute;
            right: 0;
        }
    </style>
</head>
<body>
<div class="inf fr">
    <div class="fl">账号ID:</div><div class="p3 fl">${sessionScope.thisUser.id}</div>
    <div class="fl">老师姓名:</div><div class="p3 fl">${sessionScope.thisUser.name}</div>
</div>
</body>
</html>
