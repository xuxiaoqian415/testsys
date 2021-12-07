<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>已发布考试</title>
</head>
<body>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>已发布考试</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
</head>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <%@include file="t_leftbar.jsp"%>
    <div class="right-content fl">
        <%@include file="t_inf.jsp"%>
        <div class="list-title">已发布考试列表</div>
        <c:forEach items="${tests}" varStatus="i" var="t">
            <div class="list">
                <div class="top1">
                    <div class="fl bd" >
                        <div class="fl" style="padding-top: 15px;">${t.name}</div>
                    </div>
                    <div class="fr pad">
                        <div class="p3 fr" style="margin-top: 30px">${t.sub}/${t.suball}</div> <div class="fr"  style="margin-top: 30px">答卷人数:</div>
                    </div>
                </div>
                <div class="bottom1 p2"style="padding-left: 30px;">
                    <div class="fl">开始时间:</div><div class="fl">${t.start}</div> <div class="fl">结束时间:</div><div class="fl">${t.end}</div>
                </div>
            </div>
        </c:forEach>
    </div>
    <div class="loginOut"><a href="logOut">登出</a></div>
</div>
</body>
</html>

</body>
</html>
