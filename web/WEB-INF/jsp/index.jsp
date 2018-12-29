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
            <c:forEach var="article" items="${articles}">
        <li class="list-group-item">
            <div class="row">
                <div class="col-md-2 col-sm-4 col-xs-4 col-lg-2">
                    <a href="${article.url}" class="thumbnail">
                        <img class="img-fluid" src="${article.imgUrl}" alt="dog">
                    </a>
                </div>
                <div class="col-md-10 col-sm-8 col-xs-8 col-lg-10">
                    <a class="text-dark" href="${article.url}">
                        <h4>${article.title}</h4>
                        <p>${article.intro}</p>
                        <div class="bottom-right">${article.date}</div>
                    </a>
                </div>

            </div>
        </li>
        </c:forEach>
    </ul>

    <div class="mx-5 mt-5">
        <nav aria-label="Page navigation">
            <ul class="pagination pagination-lg">
                <li class="page-item">
                    <a href="#" class="page-link" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">4</a></li>
                <li class="page-item"><a class="page-link" href="#">5</a></li>
                <li class="page-item">
                    <a href="#" class="page-link" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
            </ul>
        </nav>
    </div>

    <jsp:include page="part/footer.jsp"></jsp:include>
</div>
</body>
</html>
