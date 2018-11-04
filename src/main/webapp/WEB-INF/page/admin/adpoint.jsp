<%--
  Created by IntelliJ IDEA.
  User: 小鸣ds
  Date: 2018/10/16
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ page import="java.util.*" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
%>
<html  lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>首页</title>
    <link rel="stylesheet" href="<%=basePath%>/css/bootstrap.min.css">
    <!--  -->
    <style>
        body {
            padding-top: 80px;
            padding-left: 50px;
            font-size: 20px;
        }
        .container { margin:10px ; min-width:10px;}
    </style>
</head>

<body>

<div class="navbar navbar-fixed-top navbar-inverse" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand"  style="font-size: 25px">C语言在线考试系统</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav"> <!-- 下列class="active"  为那个高亮 -->
                <li  ><a href="<%=basePath%>/user/findpoint1.do"><span class="glyphicon glyphicon-home"></span> 知识点 </a></li>
                <li  ><a href="<%=basePath%>/user/ListTk.do"><span class="glyphicon glyphicon-home"></span> 题目 </a></li>
                <li><a href=""><span class="glyphicon glyphicon-briefcase"></span> 考试 </a></li>
                <li><a href="<%=basePath%>/user/ListTeacher.do"><span class="glyphicon glyphicon-envelope"></span> 教师 </a></li>
                <li><a href=""><span class="glyphicon glyphicon-envelope"></span> 公共信息 </a></li>
                <li><a href=""><span class="glyphicon glyphicon-cog"></span> 基础设置 </a></li>
            </ul>
            <div   style="margin: 10px ; text-align:right"  class="info">
                <span style="color: gray">欢迎您：</span>
                <em>|</em>
                <a  href="../登录界面.html">退出</a>
            </div>
        </div>
    </div><!-- /.container -->
</div>  <!-- 抬头 -->
<br/>
<br/>
<script src="<%=basePath%>/js/jquery-3.3.1.min.js"></script>
<script src="<%=basePath%>/js/bootstrap.min.js"></script>
<script src="<%=basePath%>/js/index.js"></script>

<link href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=basePath%>/css/style.css" media="screen" type="text/css" />

<div class="container">
    <div class="row">
        <div class="col-sm-4">

        </div>
        <div class="col-sm-5">

            <h3 >知识点管理：</h3>
            <div style="text-align:center;clear:both">
            </div>
            <!--二级联动-->
            <ul id="accordion" class="accordion">
                <c:forEach items="${requestScope.point1}" var="ts">
                    <li>
                    <div class="link"><i class="fa fa-paint-brush"></i>${ts.pointname}
                        <i class="fa fa-chevron-down"></i></div>
                        <ul class="submenu">
                            <c:forEach items="${ts.point2}" var="t">
                            <li><a href="#">${t.pname}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </c:forEach>
            </ul>

    </div>
</div>
</div>
</body>

</html>