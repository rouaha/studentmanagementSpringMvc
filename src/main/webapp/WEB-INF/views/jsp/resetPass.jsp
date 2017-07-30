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
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/jquery.bootstrapvalidator/0.5.0/css/bootstrapValidator.min.css"/>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css"/>

    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
    <script type="text/javascript" src="http:////maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://code.angularjs.org/snapshot/angular.js"></script>
    <script type="text/javascript"
            src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-validator/0.5.3/js/bootstrapValidator.js"></script>

    <script src="${contextPath}/resources/core/js/resetForgetPass.js" type="text/javascript"></script>
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


<div class="container" ng-app="MyResetApp" ng-controller="resetCtrl">

    <form class="well form-horizontal" id="contact_form">
        <fieldset>

            <!-- Form Name -->
            <legend>
                <center><h2><b>Reset password</b></h2></center>
            </legend>
            <br>

            <!-- Text input-->

            <%--<div class="form-group">
                <label class="col-md-4 control-label">First Name</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                        <input  name="first_name" placeholder="First Name" class="form-control"  type="text">
                    </div>
                </div>
            </div>
--%>
            <!-- Text input-->

            <%--  <div class="form-group">
                  <label class="col-md-4 control-label" >Last Name</label>
                  <div class="col-md-4 inputGroupContainer">
                      <div class="input-group">
                          <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                          <input name="last_name" placeholder="Last Name" class="form-control"  type="text">
                      </div>
                  </div>
              </div>--%>

            <%--   <div class="form-group">
                   <label class="col-md-4 control-label">Department / Office</label>
                   <div class="col-md-4 selectContainer">
                       <div class="input-group">
                           <span class="input-group-addon"><i class="glyphicon glyphicon-list"></i></span>
                           <select name="department" class="form-control selectpicker">
                               <option value="">Select your Department/Office</option>
                               <option>Department of Engineering</option>
                               <option>Department of Agriculture</option>
                               <option >Accounting Office</option>
                               <option >Tresurer's Office</option>
                               <option >MPDC</option>
                               <option >MCTC</option>
                               <option >MCR</option>
                               <option >Mayor's Office</option>
                               <option >Tourism Office</option>
                           </select>
                       </div>
                   </div>
               </div>--%>

            <!-- Text input-->

            <%-- <div class="form-group">
                 <label class="col-md-4 control-label">Username</label>
                 <div class="col-md-4 inputGroupContainer">
                     <div class="input-group">
                         <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>
                         <input  name="user_name" placeholder="Username" class="form-control"  type="text">
                     </div>
                 </div>
             </div>--%>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Temp Password</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input name="user_current_password" placeholder=" Current Password" class="form-control"
                               type="password" ng-model="TempPassData.userTempPass">
                    </div>
                </div>
            </div>
            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">New Password</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input name="user_new_password" placeholder="New Password" class="form-control" type="password">
                    </div>
                </div>
            </div>

            <!-- Text input-->

            <div class="form-group">
                <label class="col-md-4 control-label">Confirm Password</label>
                <div class="col-md-4 inputGroupContainer">
                    <div class="input-group">
                        <span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
                        <input name="confirm_password" placeholder="Confirm Password" class="form-control"
                               type="password" ng-model="TempPassData.userNewPass">
                    </div>
                </div>
            </div>

            <!-- Text input-->
            <%--     <div class="form-group">
                     <label class="col-md-4 control-label">E-Mail</label>
                     <div class="col-md-4 inputGroupContainer">
                         <div class="input-group">
                             <span class="input-group-addon"><i class="glyphicon glyphicon-envelope"></i></span>
                             <input name="email" placeholder="E-Mail Address" class="form-control"  type="text">
                         </div>
                     </div>
                 </div>--%>


            <!-- Text input-->
            <%--
                            <div class="form-group">
                                <label class="col-md-4 control-label">Contact No.</label>
                                <div class="col-md-4 inputGroupContainer">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="glyphicon glyphicon-earphone"></i></span>
                                        <input name="contact_no" placeholder="(639)" class="form-control" type="text">
                                    </div>
                                </div>
                            </div>--%>

            <!-- Select Basic -->

            <!-- Success message -->
            <div class="alert alert-success" role="alert" id="success_message" ng-show="successDialog">Success <i
                    class="glyphicon glyphicon-thumbs-up"></i> Successfully reset your password!. click here for <a
                    href="/login">Signin</a></div>

            <!-- Button -->
            <div class="form-group">
                <label class="col-md-4 control-label"></label>
                <div class="col-md-4"><br>
                    &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    <button type="submit" class="btn btn-warning" ng-click="resetForgetPass(TempPassData)">
                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbspRESET <span class="glyphicon glyphicon-send"></span>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                    </button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</div><!-- /.container -->


<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>

</body>
</html>
