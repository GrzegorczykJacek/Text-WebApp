<%@ page contentType="text/html;charset=UTF-8" %>

<!doctype html>
<html lang="en">

<jsp:include page="include/meta.jsp"/>

<body>
<main role="main" class="container pb-3 mb-3">

    <jsp:include page="include/header.jsp"/>

    <div class="row text-center">
        <div class="container">
            <div class="col-md-4 m-auto">

                <form action="login" method="post">
                    <input type="hidden" name="currentURIfromLoginJSP" value="${currentURI}">
                    <img class="mb-4" src="https://getbootstrap.com/docs/4.0/assets/brand/bootstrap-solid.svg" alt=""
                         width="72"
                         height="72">
                    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
                    <label for="inputLogin" class="sr-only">Login</label>
                    <input name="username" type="text" id="inputLogin" class="form-control" placeholder="Login" required
                           autofocus>
                    <label for="inputPassword" class="sr-only">Password</label>
                    <input name="password" type="password" id="inputPassword" class="form-control"
                           placeholder="Password" required>
                    <div class="checkbox mb-3">
                        <label>
                            <input type="checkbox" value="remember-me"> Remember me
                        </label>
                    </div>
                    <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                </form>
            </div>
        </div>
    </div>

</main>

<jsp:include page="include/footer.jsp"/>

<script src="js/bootstrap.js"></script>
</body>
</html>
