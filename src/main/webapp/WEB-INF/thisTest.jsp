<%@ page import="se.zust.xxq160.model.Problem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>在线测试</title>
    <link href="../css/thisTest.css" rel="stylesheet">
    <%@include file="top2.jsp"%>
    <script type="text/javascript">
        function CountDown() {
            if(maxtime>=0){
                minutes=Math.floor(maxtime/60);
                seconds=Math.floor(maxtime%60);
                msq="距离考试结束还有"+minutes+"分" +seconds+"秒";
                document.all["timer"].innerHTML=msq;
                if(maxtime==5*60) alert("还剩五分钟");
                --maxtime;
            } else {
                clearInterval(timer);
                alert("时间到，结束")
            }
        }
        timer=setInterval("CountDown()",1000);
    </script>
</head>
<body>
<span id="tim" hidden>${time}</span>
<script>
    var n = document.getElementById("tim").innerHTML;
    var maxtime=60*n;
</script>
<div class="st clearf">
    <div style="margin: 10px 0px 10px 20px"><a href="testOnline" style="color: black; text-decoration: none">返回</a></div>
    <div class="content clearf">
        <div class="fr"><h3>${info}</h3></div>
        <div id="timer" style="color: red;margin-left: 500px"></div>
        <form action="thisTest?stuid=${stuid}&testid=${testid}" method="post">
            <%
            List<Problem> problems = (List<Problem>) request.getAttribute("problems");
            if(problems != null)
                for(Problem p: problems) {
        %>
            <div class="problem">
                        <div class="tg"><%= p.getOrder()%>、<%= p.getProblem()%></div>
        <%
                    if(p.getPtype() == 0) {
                        int i = 0;
                        for(String op: p.getOps()) {
        %>
                            <div class="xx">
                                <label><input type="radio" name="<%= p.getOrder()%>" value="<%= (char)('A'+i)%>"><%= (char)('A'+ (i++))%>、<%= op%></label>
                            </div>
        <%
                        }
                    }
                    else if(p.getPtype() == 1) {
                        int i = 0;
                        for(String op: p.getOps()) {
        %>
                            <div class="xx">
                                <label><input type="checkbox" name="<%= p.getOrder()%>" value="<%= (char)('A'+i)%>"><%= (char)('A'+ (i++))%>、<%= op%></label>
                            </div>
        <%
                        }
                    }
                    else if(p.getPtype() == 2) {
        %>
                        <div class="xx">
                            <textarea name="<%= p.getOrder()%>"></textarea>
                        </div>
        <%
                    }
        %>
            </div>
        <%
           }
        %>
            <div class="sub fr" style="margin: 30px;">
                <input type="submit" value="提交">
            </div>
        </form>
    </div>
</div>
</body>
</html>

