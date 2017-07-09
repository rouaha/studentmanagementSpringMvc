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
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapcss"/>
<link  href="${bootstrapcss}" rel="stylesheet"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapjs"/>
<script src="${bootstrapjs}"></script>

<div class="container">

    <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

            <button class="btn btn-lg btn-primary btn-block" type="submit">Log In</button>
            <h4 class="text-center"><a href="/registration">Create an account</a></h4>
        </div>

    </form>

</div>
<spring:url value="/resources/core/js/userregi.js" var="userregi"/>

</body>
</html>
