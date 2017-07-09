<%--
  Created by IntelliJ IDEA.
  User: BS190
  Date: 7/5/2017
  Time: 2:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <spring:url value="/resources/core/css/studentTable.css" var="studentTable"></spring:url>
    <link href="${studentTable}" rel="stylesheet">
    <spring:url value="/resources/core/css/studentForm.css" var="studentForm"></spring:url>
    <link href="${studentForm}" rel="stylesheet">
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.4/angular.js"></script>

    <spring:url value="/resources/core/js/addStudent.js" var="addStudent"></spring:url>
    <script src="${addStudent}"></script>


    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <script   src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript"  src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
    <title>Student Management</title>


</head>
<body>


<div ng-app="myApp" ng-controller="formCtrl">
    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#frommodal" style="text-align: right;width: 90px;float: inherit; " ng-click="addStudent()" >Add Student</button>
    <button type="button" class="btn btn-primary" style="text-align: right;width: 180px;float: inherit " ng-click="removeSelectedItem()" >Remove Selected Student</button>
    <table class="reset" >

        <thead>
        <tr>
            <th>Select</th>
            <th>Serial No</th>
            <th>Student Id</th>
            <th>User name</th>
            <th>Email address</th>
            <th>Date Of birth</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <tr ng-repeat="data in patientdata" >
            <td><input type="checkbox" ng-model="tableSelection[$index]"/></td> <td>{{data.serialNo}}</td><td>{{data.studentId}}</td><td>{{data.userName}}</td>
            <td>{{data.email}}</td><td>{{data.db}}</td><td>{{data.age}}</td>
            <td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#myModal" ng-click="editpatient(data)">Update</button>
                <button type="button" class="btn btn-link"  ng-click="deletepatient(data)" >Delete</button></td>
        </tr>

        </tbody>
    </table>

    <div class="modal fade" id="myModal" role="dialog">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" style="text-align: right;margin-right: 20px;margin-top: 10px" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Update Student Information</h4>
                </div>
                <div class="modal-body">
                    <form >
                        User Name:<input type="text" ng-model="updatePatient.userName"/><br/>
                        Email Address:<input type="text" ng-model="updatePatient.email"/><br/>
                        Date of Birth:
                        <div class="input-group date" data-provide="datepicker">
                            <input type="text" class="form-control" id="date" name="date" ng-blur="calculateAge()" ng-model="parent.checkOut"/>
                            <span class="input-group-addon">
                               <span class="glyphicon glyphicon-calendar">
                                </span>
                           </span>
                        </div><br/>

                        Age:<input type="text" readonly="readonly" ng-model="calculatedage"/><br/>

                        <div class="modal-footer">
                            <input type="submit" value="Update" ng-click="updatePatientInformation()"/>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>

</div>
<script type="javascript">
    $('#date').datepicker({
        format: 'dd-mm-yyyy'
    });
</script>
</body>
</html>