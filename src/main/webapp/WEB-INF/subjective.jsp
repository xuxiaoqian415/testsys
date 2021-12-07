<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>批改主观题</title>
    <link href="../css/TeachHome.css" rel="stylesheet">
</head>
<style>
    .sub{
        padding: 20px;
        background-color: #8F8F8F;
        opacity: 0.5;
    }
    .sum2{
        position: fixed;
        right: 200px;
        top: 80px;
    }
</style>
<script>
    function showSum(){
        var info=document.getElementById("sum2").innerHTML;
        alert(info);
    }
</script>
<body>
<%@include file="top2.jsp"%>
<div class="main clearf">
    <div style="margin: 10px 0px 10px 20px"><a href="correctTests" style="color: black; text-decoration: none">返回</a></div>
    <div class="sum2"><h3>${info}</h3></div>
    <form action="subjective?stuid=${stuid}&testid=${testid}" method="post">
        <center>
            <c:forEach items="${answers}" varStatus="i" var="a">
                <div class="checkmain">
                    <div class="qsttop">
                        <div class="qstl fl">题号:</div>
                        <div class="no fl">${i.count}</div>
                        <div class="grade fr"><input type="text" value="" size="1px" name="${i.count}">/${a.get("score")}</div>
                        <div class="qstr fr">分数:</div>
                    </div>
                    <div class="answer">
                        ${a.get("content")}
                    </div>
                </div>
            </c:forEach>
        </center>
        <div class="sub"><input type="submit" value="提 交" style="position: absolute;
                top: 100px;right: 80px;  -webkit-box-shadow: 3px 3px 2px 2px rgba(0,0,0,.3);
                border: none; font-size: 18px;font-weight: bold;
                 box-shadow:  3px 3px 2px 2px rgba(0,0,0,.3);" ></div>
    </form>

</div>
</body>
</html>
