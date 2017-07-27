<%--
  Created by IntelliJ IDEA.
  User: BS190
  Date: 7/4/2017
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<spring:url value="/webapp/core/css/bootstrap.min.css" var="bootstrapcss"/>
<link  href="${bootstrapcss}" rel="stylesheet"/>
<spring:url value="/webapp/core/js/bootstrap.min.js" var="bootstrapjs"/>
<script src="${bootstrapjs}"></script>

<div class="container" style="width: 250px">

    <form action="${pageContext.request.contextPath}/j_spring_security_check" method='POST' class="form-signin">
        <h2 class="form-heading">Login</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
        </div>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
        </div>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="form-group ${error != null ? 'has-error' : ''}">
            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="/registration">Create an account.</a> <h6 class="text-center"><a
                    href="/forgetPassword"> Or forget password?</a></h6></h4>

        </div>

    </form>

</div>
<spring:url value="/webapp/core/js/userregi.js" var="userregi"/>

</body>
</html>
