<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>学生界面</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
</head>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <%@include file="s_leftbar.jsp"%>
    <div class="right-content fl">
        <%@include file="s_inf.jsp"%>
        <div class="joinClass">
            <h6>加入新班级</h6>
            <form action="joinClass">
                <input type="text" name="cid">
                <input type="submit" value="确定">
            </form>
            ${info_joinC}
        </div>
        <div class="list-title">班级列表</div>
        <c:forEach items="${classes}" varStatus="i" var="cla">
            <div class="list">
                <div class="top1">
                    <div class="fl bd" >
                        <div class="fl" style="padding-top: 15px;">${cla.name}</div>
                    </div>
                    <div class="fr pad">
                        <div class="p3 fr" style="margin-top: 30px">${cla.t_name}</div> <div class="fr"  style="margin-top: 30px">老师姓名:</div>
                    </div>
                </div>
                <div class="bottom1 p2"style="padding-left: 30px;">${cla.id}</div>
            </div>
        </c:forEach>
    </div>
    <div class="loginOut"><a href="logOut">登出</a></div>
</div>
</body>
</html>
