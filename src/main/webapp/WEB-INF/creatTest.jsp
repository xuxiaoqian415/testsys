<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>创建试卷</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
    <link href="../css/creat.css" rel="stylesheet">
</head>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <%@include file="t_leftbar.jsp"%>
    <div class="right-content fl">
        <%@include file="t_inf.jsp"%>
    </div>
    <div class="form fl">
        <div class="but fl"><a href="html/testMessage.html" target="mainiframe" class="href" style="color: white;font-size: larger">+添加考试信息</a></div>
        <div class="but fl"><a href="html/form1.html" target="mainiframe" class="href" style="color: white;font-size: larger">+创建客观题</a></div>
        <div class="but fl"><a href="html/form2.html" target="mainiframe" class="href" style="color: white;font-size: larger">+创建主观题</a></div>
    </div>
    <iframe src="html/testMessage.html" name="mainiframe" >
    </iframe>
    <div class="loginOut"><a href="logOut">登出</a></div>
</div>
</body>
</html>
