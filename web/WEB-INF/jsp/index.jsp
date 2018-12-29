<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>mynotes</title>
    <jsp:include page="part/header.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <jsp:include page="part/top.jsp"></jsp:include>
</div>

<div class="container">
    <ul class="list-group">
        <li class="list-group-item">
        <c:forEach var="article" items="${articles}">
            <li class="list-group-item">
                <div class="row">
                    <div class="col-md-2 col-sm-4 col-xs-4 col-lg-2">
                        <a href="${article.url}" class="thumbnail">
                            <img class="img-fluid" src="${article.imgUrl}" alt="dog">
                        </a>
                    </div>
                    <a class="plain" href="${article.url}">
                        <div class="col-md-10 col-sm-8 col-xs-8 col-lg-10">
                            <h4>${article.title}</h4>
                            <p>${article.intro}</p>
                            <div class="bottom-right">${article.date}</div>
                        </div>
                    </a>
                </div>
            </li>
        </c:forEach>
    </ul>
</div>
</body>
</html>
