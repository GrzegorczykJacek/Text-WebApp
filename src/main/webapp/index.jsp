<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="articleService"
             scope="request"
             class="com.jg.twitter.service.ArticleService"
/>
<!doctype html>
<html lang="en">

<jsp:include page="include/meta.jsp"/>

<body>
<jsp:include page="include/header.jsp"/>

<main role="main" ng-app="articleApp">
    <%--    <%--%>
    <%--        final List<TbArticle> articles = articleService.getArticles();--%>
    <%--        pageContext.setAttribute("articles", articles);--%>
    <%--    %>--%>

    <div class="container">
        <div ng-controller="articleController" ng-init="init()">
            <div ng-repeat="article in articles">
                <div class="row d-flex justify-content-center">
                    <div class="col-5">
                        <h2>Heading</h2>
                        <p>
                            {{article.content}}
                        </p>
                        <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>
                    </div>
                </div>
                <hr>
            </div>
        </div>


        <%--        <c:forEach items="${articles}" var="article">--%>
        <%--            <div class="row d-flex justify-content-center">--%>
        <%--                <div class="col-5">--%>
        <%--                    <h2>Heading</h2>--%>
        <%--                    <p>--%>
        <%--                            ${article.content}--%>
        <%--                    </p>--%>
        <%--                    <p><a class="btn btn-secondary" href="#" role="button">View details &raquo;</a></p>--%>
        <%--                </div>--%>
        <%--            </div>--%>
        <%--            <hr>--%>
        <%--        </c:forEach>--%>

    </div> <!-- /container -->

</main>

<jsp:include page="include/footer.jsp"/>
<script src="js/angular.js"></script>
<script src="js/controller.js"></script>
</body>
</html>
