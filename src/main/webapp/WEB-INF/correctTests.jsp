<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>批改试卷</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
</head>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <%@include file="t_leftbar.jsp"%>
    <div class="right-content fl">
        <%@include file="t_inf.jsp"%>
        <div class="list-title">已提交试卷列表</div>
        <c:forEach items="${answers}" varStatus="i" var="a">
            <div class="list">
                <div class="top1">
                    <div class="fl bd" style="padding-right: 500px" >
                        <div class="fl" style="padding-top: 15px;">学号：${a.stuid}</div>
                    </div>
                    <div class=" fr pad">
                        <div class="p3 fr"style="padding-top: 30px;" >${a.stuname}</div> <div class="fr" style="padding-top: 30px;">学生姓名:</div>
                    </div>
                </div>
                <div class="bottom1 p2">
                    <div class="fl" style="color: black;margin-left: 8px">客观题分数</div><div class="fl">${a.sum1}/${a.objAllScore}</div>
                    <div class="fl" style="color: black;margin-left: 100px">主观题分数</div><div class="fl">${a.sum2}/${a.subjAllScore}</div>
                    <div class="fr cc" style="color: black;font-size: 20px;margin-right: 50px"><a href="subjective?stuid=${a.stuid}&testid=${a.testid}" style="color: black; text-decoration: none">去批改主观题</a></div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="loginOut"><a href="logOut">登出</a></div>
</div>
</body>
</html>
