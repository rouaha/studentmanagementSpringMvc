<%--
  Created by IntelliJ IDEA.
  User: BS190
  Date: 7/4/2017
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/> --%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <meta name="description" content="">
    <meta name="author" content="">

    <title>Create an account</title>

    <%-- <link href="${contextPath}/resources/core/css/bootstrap.min.css" rel="stylesheet">--%>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>

    <script
            src="http://code.jquery.com/jquery-1.12.4.min.js"
            integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
            crossorigin="anonymous"></script>
    <script type="text/javascript" src="http://code.angularjs.org/snapshot/angular.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>

    <script src="${contextPath}/resources/core/js/userregi.js" type="text/javascript"></script>
    <script src="${contextPath}/resources/core/js/userCustomValidation.js" type="text/javascript"></script>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapjs"/>
    <script src="${bootstrapjs}"></script>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<%--<spring:url value="/webapp/resorces/core/css/bootstrap.min.css" var="bootstrapcss"/>
<link  href="${bootstrapcss}" rel="stylesheet"/>--%>


<div class="container" ng-app="myApp" ng-controller="formCtrl">

    <form class="well form-horizontal" name="userForm" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>
                <center><h2><b>Registration Form</b></h2></center>
            </legend>
            <br>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">First Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="first_name" placeholder="First Name" class="form-control" type="text"
                               ng-model="userReg.firstName">

                    </div>
                    <%-- <div ng-messages="userForm.first_name.$error" >
                         <p ng-message="required">First name is required</p>
                     </div>--%>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Last Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="last_name" placeholder="Last Name" class="form-control" type="text"
                               ng-model="userReg.lastName">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class="col-md-4 control-label">Department / Office</label>
                <div class="col-md-4 selectContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                        <select name="department" class="form-control selectpicker" ng-model="userReg.dept">
                            <option disabled selected value>Select your Department/Office</option>
                            <option>Department of Engineering</option>
                            <option>Department of Agriculture</option>
                            <option>Department of Science</option>
                            <option>Department of Accounting</option>
                            <option>Accounting Office</option>
                            <option>Tresurer's Office</option>
                            <option>MPDC</option>
                            <option>MCTC</option>
                            <option>MCR</option>
                            <option>Mayor's Office</option>
                            <option>Tourism Office</option>
                        </select>
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Username</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group"
                         ng-class="{'has-error':userForm.user_name.$invalid && userForm.user_name.$touched}">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input name="user_name" placeholder="Username" class="form-control" type="text"
                               ng-model="userReg.userName">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Password</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group"
                         ng-class="{'has-error':userForm.user_password.$invalid && userForm.user_password.$touched}">
                        <span class="input-group-addon"><i class=" glyphicon glyphicon-lock"></i></span>
                        <input name="user_password" placeholder="Password" class="form-control" type="password"
                               ng-model="userReg.pass">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Confirm Password</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group"
                         ng-class="{'has-error':userForm.confirm_password.$invalid && userForm.confirm_password.$touched}">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input name="confirm_password" placeholder="Confirm Password" class="form-control"
                               type="password" ng-model="userReg.conPass">
                    </div>
                </div>
            </div>

            <!-- Text input-->
            <div class="form-group">
                <label class="col-md-4 control-label">E-Mail</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group"
                         ng-class="{'has-error':userForm.email.$invalid && userForm.email.$touched}">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                        <input name="email" placeholder="E-Mail Address" class="form-control" type="text"
                               ng-model="userReg.email">
                    </div>
                </div>
            </div>


            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Contact No.</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group"
                         ng-class="{'has-error':userForm.contact_no.$invalid && userForm.contact_no.$touched}">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                        <input name="contact_no" placeholder="(+008)" class="form-control" type="text"
                               ng-model="userReg.contactNo">
                    </div>
                </div>
            </div>

            <!-- Select Basic -->

            <!-- Success message -->
            <div class="alert alert-success" role="alert" id="success_message" ng-show="successDialog">Success <i
                    class="glyphicon glyphicon-thumbs-up"></i> Success!.<a href="/login">Signin</a></div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4"><br>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <button type="submit" class="btn btn-warning" ng-click="createNewUser(userReg)">
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspSUBMIT <span class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    </button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
<!-- /.container -->

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>


</body>
</html>
