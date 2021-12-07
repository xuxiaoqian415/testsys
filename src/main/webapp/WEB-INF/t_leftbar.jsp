<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <style>
        .left-bar {
            margin-right: 20px;
            margin-top: 20px;
            width: 250px;
            -webkit-box-shadow: 3px 3px 2px 2px rgba(0,0,0,.3);
            box-shadow:  3px 3px 2px 2px rgba(0,0,0,.3);
        }
        .item1 {
            text-align: center;
            padding: 10px;
            background-color: #151f58;
            opacity: 0.5;
            margin: 50px 10px;
            font-size: 20px;
            font-weight: bold;
            color: white;
            width: 180px;
        }
        .item1 a {
            color: white;
            text-decoration: none;
        }
        .item{
            margin: 50px 10px;
            font-size: 20px;
            font-weight: bold;
            width: 200px;
            border-bottom: 2px solid #8F8F8F;
            padding: 10px 0;
            background-color: #f6f1f1;
        }
        .item:hover
        {
            background-color:darkgray;
            color: white;
        }
        .item a{
            color: black;
            text-decoration: none;
        }
        .item2{
            background-color: white;
            margin: 50px 10px;
            width: 200px;
        }
    </style>
</head>
<body>
<div class="left-bar fl">
    <div class="item1"><a href="creatTest">+创建试卷</a></div>
    <div class="item" ><a href="tClasses"><img src="images/bj1.png" height="20px" width="20px"> 查看班级</a></div>
    <div class="item"><a href="uploadedTests"><img src="images/sj.png" height="20px" width="20px"> 已发布考试</a></div>
    <div class="item"><a href="correctTests"><img src="images/pg.png" height="20px" width="20px"> 批改试卷</a></div>
    <div class="item2"><p class="p1">温馨提示:诚信考试</p><p class="p2">不得向学生泄题,如有发现将立即吊销教师资格，并处以通报批评</p></div>
</div>
</body>
</html>
