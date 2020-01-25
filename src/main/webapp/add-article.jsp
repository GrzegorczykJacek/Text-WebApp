<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="en">

<jsp:include page="include/meta.jsp"/>

<body>


<main role="main">
    <jsp:include page="include/header.jsp"/>
    <div class="container">
        <div class="row text-center">
            <div class="col-md-8 m-auto text-left">
                <form name="addArticleForm" class="needs-validation" action="addArticle" method="post">
                    <div class="mb-3">
                        <div class="form-group">
                            <h3>Add new Article</h3>
                            <label>Content
                                <textarea class="form-control" name="content" rows="3"></textarea>
                            </label>
                        </div>
                    </div>
                    <hr class="mb-4">
                    <button class="btn-primary btn-lg" type="submit">Add article</button>
                </form>
            </div>
        </div>
    </div> <!-- /container -->

</main>

<jsp:include page="include/footer.jsp"/>

<script src="js/bootstrap.js"></script>
</body>
</html>
