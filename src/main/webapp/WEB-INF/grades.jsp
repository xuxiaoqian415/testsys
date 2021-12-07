<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>成绩排名</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
    <link href="../css/creat.css" rel="stylesheet">
</head>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <%@include file="s_leftbar.jsp"%>
    <div class="right-content fl">
        <%@include file="s_inf.jsp"%>
        <div class="list-title">成绩列表</div>
        <div class="table">
            <table border="2px" cellspacing="0">
                <c:forEach items="${answers}" varStatus="i" var="a">
                    <tr>
                        <th>试卷名称：${a.testname}</th>
                        <th>学生名次：${a.no}</th>
                        <th>成绩：${a.sumall}</th>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
    <div class="loginOut"><a href="logOut">登出</a></div>
</div>
</body>
</html>
