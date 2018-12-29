<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: warmfrog
  Date: 2018/12/29
  Time: 17:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文章管理</title>
    <jsp:include page="../part/header.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <jsp:include page="../part/top.jsp"></jsp:include>
</div>
<div class="container">
    <ul class="list-group">
            <c:forEach var="article" items="${articles}">
        <li class="list-group-item">
            <div class="row">
                <div class="col-md-2 col-sm-4 col-xs-4 col-lg-2">
                    <a href="${article.url}" class="thumbnail">
                        <img class="img-fluid" src="${article.imgUrl}" alt="dog">
                    </a>
                </div>
                <div class="col-md-9 col-sm-7 col-xs-7 col-lg-9">
                    <a class="text-dark" href="${article.url}">
                        <h4>${article.title}</h4>
                        <p>${article.intro}</p>
                        <span class="d-none">${article.id}</span>
                        <div class="bottom-right">${article.date}</div>
                    </a>
                </div>
                <div class="col-md-1 col-sm-1 col-xs-1 col-lg-1 my-auto mx-auto">
                    <button class="btn btn-danger deleteArticle" >删除</button>
                </div>
            </div>
        </li>
        </c:forEach>
    </ul>
</div>

<jsp:include page="../part/footer.jsp"></jsp:include>
</body>
</html>
