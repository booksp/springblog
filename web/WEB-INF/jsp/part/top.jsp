<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="GB18030" %>
<!-- ¶¥²¿À¸-->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark" role="navigation">
    <a class="navbar-brand" href="/index.jsp">mynotes</a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbar"
                    aria-expanded="false" aria-controls="navbar" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

        <div id="navbar" class="navbar-collapse collapse">
            <ul class="navbar-nav mr-auto">
                <c:forEach var="type" items="${types}">
                    <li class="nav-item"><a class="nav-link" href="#">${type}</a></li>
                </c:forEach>
                <li class="nav-item"><a class="nav-link" id="release" >·¢²¼</a></li>
                <li class="nav-item"><a class="nav-link" id="showuser">${user}</a></li>
            </ul>

            <script>
                $(function () {
                    $("#release").click(function () {
                            var user = $("#showuser").text();
                            if(user == null || user == ""){
                                $("#loginModal").modal();
                            }else {
                                window.location.href="/article/release";
                            }
                    });
                });
            </script>



            </form>
        </div><!--/.navbar-collapse -->
    </div>
</nav>

<jsp:include page="/WEB-INF/jsp/user/login.jsp"/>




