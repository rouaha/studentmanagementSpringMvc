<%--
  Created by IntelliJ IDEA.
  User: BS190
  Date: 7/5/2017
  Time: 1:12 PM
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html >
<head>
    <title>Create Student</title>

    <spring:url value="/webapp/core/css/studentForm.css" var="studentForm"/>
    <link href="${studentForm}" rel="stylesheet">

    <script type="text/javascript" src="http://code.angularjs.org/snapshot/angular.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
   <!-- <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>-->


    <script type="text/javascript"  src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript"  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
    <spring:url value="/webapp/core/js/home.js" var="addStudent"></spring:url>
    <script src="${addStudent}"></script>
</head>
<body>
<h1>Create New Student</h1>

<div ng-app="myApp" ng-controller="formCtrl" >


    <form >
         Name:<input type="text" ng-model="Userregi.userName" required=true/><br/>
        Email Address:<input type="email" ng-blur="emailcheck()" ng-model="Userregi.email" required="true"/><br/>
        Password :<input type="password"  ng-model="Userregi.password" required="true"/><br/>

        Date of Birth:
        <div class="input-group date" data-provide="datepicker">
            <input type="text" class="form-control" id="date" name="date" ng-blur="calculateAge()" ng-model="parent.checkOut" required="true"/>
            <span class="input-group-addon">
                <span class="glyphicon glyphicon-calendar">
                </span>
            </span>
        </div><br/>

        Age:<input type="text" readonly="readonly" ng-model="studentage"/><br/>

        ​​ ​​ <input type="checkbox" class="status" ng-model="checkboxModel.value1"/>View List Page <br/>
        <input type="checkbox" class="status" ng-model="checkboxModel.value2"/>Back Add Page​

        <div class="modal-footer">
            <input type="submit" value="Create New Student" ng-click="createNewStudent()"/>
           <div> <input type="submit" value="Cancel" ng-click="cancelcreateNewStudent()"/></div>
        </div>

    </form>
    <script type="javascript">

        $('#date').datepicker({
            format: 'dd-mm-yyyy'
        });

    </script>
</div>
</body>
</html>
