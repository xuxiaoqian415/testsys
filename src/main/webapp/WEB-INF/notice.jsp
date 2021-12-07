<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>考试通知</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
    <style>
        .bd .top2{
            margin-top: 15px;
        }
    </style>
</head>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <%@include file="s_leftbar.jsp"%>
    <div class="right-content fl">
        <%@include file="s_inf.jsp"%>
        <div class="list-title">通知列表</div>
        <c:forEach items="${alltest}" varStatus="i" var="t">
            <a href="testOnline">
                <div class="list" style="height: 80px">
                    <div class="fl bd" style="border: none;padding-right: 100px">
                        <div class="fl" style="padding: 15px 0px;border-right: 2px solid #8F8F8F;padding-right: 100px">${t.name}</div>
                        <div class="fl top2" >开始时间:</div><div class="fl top2" >${t.start}</div> <div class="fl top2">结束时间:</div><div class="fl top2">${t.end}</div>
                    </div>
                </div>
            </a>
        </c:forEach>
    </div>
    <div class="loginOut"><a href="logOut">登出</a></div>
</div>
</body>
</html>
