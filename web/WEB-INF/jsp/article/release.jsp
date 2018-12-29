<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="GB18030"%>
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
            <h2 class="display-4">��������</h2>
        </div>
    </div>
</div>


<div class="container">
    <form class="form-horizontal" action="/article/add" enctype="multipart/form-data" method="post">
        <div class="form-row">
            <div class="form-group col-md-7 col-sm-12">
                <label for="title">����</label>
                <input type="text" class="form-control form-control-lg" id="title" name="title" path="title" placeholder="����">
            </div>
            <div class="form-group col-md-3 col-sm-12">
                <label for="author" class="control-label">����</label>
                <input type="text" class="form-control form-control-lg" id="author" name="author" path="author"
                       placeholder="����">
            </div>
            <div class="form-group col-md-2 col-sm-12">
                <label for="type" class="control-label">����</label>
                <select class="form-control form-control-lg" id="type" name="type" path="type">
                    <c:forEach var="type" items="${types}">
                        <option value="${type}">${type}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="form-group">
            <label for="intro" class="control-label">���</label>
            <textarea class="form-control form-control-lg" id="intro" name="intro" rows="6" path="intro"
                      placeholder="."></textarea>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6 col-sm-12">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="airticleImg" name="image" path="image">
                    <label class="custom-file-label" for="airticleImg">�ϴ�ͼ�� (.jpeg .png .jpg)</label>
                </div>
            </div>
            <div class="form-group col-md-6 col-sm-12">
                <div class="custom-file">
                    <input type="file" class="custom-file-input" id="article" name="article" path="image">
                    <label class="custom-file-label" for="article">�ϴ����� (.html )</label>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col"></div>
            <div class="col">
                <button type="button" class="btn btn-info">����</button>
            </div>
            <div class="col"></div>
            <div class="col">
                <button type="submit" class="btn btn-success">����</button>
            </div>
            <div class="col"></div>
        </div>
    </form>
</div>

<jsp:include page="../part/footer.jsp"></jsp:include>
</body>
</html>
