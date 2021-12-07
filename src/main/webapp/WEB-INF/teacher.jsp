<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>教师界面</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
</head>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <%@include file="t_leftbar.jsp"%>
    <div class="right-content fl">
        <%@include file="t_inf.jsp"%>
        <div class="creatClass">
            <h6>创建新班级</h6>
            <form action="creatClass">
                <input type="text" name="cName">
                <input type="submit" value="确定">
            </form>
            ${info_addC}
        </div>
        <div class="list-title">班级列表</div>
        <c:forEach items="${classes}" varStatus="i" var="cla">
            <div class="list">
                <div class="top1">
                    <div class="fl bd" >
                        <div class="fl" style="padding-top: 15px;"><a href="watchStu?cid=${cla.id}">${cla.name}</a></div>
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
