<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: warmfrog
  Date: 2018/12/28
  Time: 17:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Release</title>
    <jsp:include page="../part/header.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <jsp:include page="../part/top.jsp"></jsp:include>
</div>
<div class="container">
    <div class="jumbotron jumbotron-fluid justify-content-center">
        <div class="container text-center ">
            <h2 class="display-4">发布文章</h2>
        </div>
    </div>
</div>


<div class="container">
    <form class="form-horizontal" action="/article/add" enctype="multipart/form-data" method="post">
            <div class="form-group">
                <label for="title">标题</label>
                <input type="text" class="form-control form-control-lg" id="title" name="title" path="title" placeholder="标题">
            </div>
            <div class="form-group">
                <label for="author" class="control-label">作者</label>
                <input type="text" class="form-control form-control-lg" id="author" name="author" path="author" placeholder="作者">
            </div>
            <div class="form-group">
                <label for="type" class="control-label">分类</label>
                    <select class="form-control form-control-lg" id="type" name="type" path="type">
                        <c:forEach var="type" items="${types}">
                            <option value="${type}">${type}</option></c:forEach>
                    </select>
            </div>
            <div class="form-group">
                <label for="type" class="control-label">简介</label>
                <textarea class="form-control form-control-lg" id="intro" name="intro" rows="6" path="intro" placeholder="."></textarea>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="airticleImg" name="image" path="image">
                    <label class="custom-file-label" for="airticleImg" >上传图像 (.jpeg .png .jpg)</label>
                </div>
            </div>
            <div class="form-group">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="article" name="article" path="image">
                    <label class="custom-file-label" for="article">上传文章 (.html )</label>
                </div>
            </div>


            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <button type="button" class="btn btn-info">保存</button>
                </div>
                <div class="col"></div>
                <div class="col">
                    <button type="submit" class="btn btn-success">发布</button>
                </div>
                <div class="col"></div>
            </div>
    </form>
</div>

</body>
</html>
