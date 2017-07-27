/**
 * Created by BS190 on 7/4/2017.
 */
angular.module('myApp', []).controller('formCtrl', function ($scope, $http) {

    $scope.successDialog = false;
    /*$scope.userReg={
     "firstName":'',
     "lastName":'',
     "dept":'',
     "userName":'',
     "pass":'',
     "conPass":'',
     "email":'',
     "contactNo":''

     };*/

    $scope.createNewUser = function (userData) {

        console.log(userData);
        var userDetails = {
            "userId": '',
            "lastName": userData.firstName + userData.lastName,
            "name": userData.userName,
            "email": userData.email,
            "password": userData.pass,
            "active": '1',
            "roles": [{
                "roleId": '',
                "role": 'ROLE_ADMIN'
            }]
        };
        console.log(userDetails);
        $http({
            method: 'POST',
            url: "http://localhost:8081/createUser",
            data: userDetails,
            headers: {
                'Content-Type': 'application/json'
            }
        }).then(function success(responseData) {

            $scope.successDialog = !$scope.successDialog;
        }, function error(response) {

        })


    }

});