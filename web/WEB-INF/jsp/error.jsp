<%--
  Created by IntelliJ IDEA.
  User: warmfrog
  Date: 2018/12/29
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>非法操作</title>
    <jsp:include page="part/header.jsp"></jsp:include>
</head>
<body>
<div class="container">
    <jsp:include page="part/top.jsp"></jsp:include>

    <div class="container text-center">
        <div class="card">
            <div class="card-body">
                <h2 class="card-title">不支持的操作</h2>
                <p class="card-text">${message}</p>
            </div>
        </div>
    </div>

    <div class="container">
        <div class="jumbotron jumbotron-fluid text-center">
            <p>10秒后将返回主页</p>
            <a href="/index.jsp" class="btn btn-primary">   返回主页</a>
        </div>
    </div>

    </div>

</div>

<%
    response.setHeader("refresh", "10;URL=/index.jsp");
%>

<jsp:include page="part/footer.jsp"></jsp:include>
</body>
</html>
