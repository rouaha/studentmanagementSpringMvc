/**
 * Created by BS190 on 7/26/2017.
 */
angular.module('Myapp', [])
    .controller('ForgetPassContrl', function ($scope, $http) {
        $scope.successDialog = false;
        $scope.forgetPass = function (user) {
            var userDetails = {
                "userId": '',
                "name": user.username,
                "email": user.email,
                "lastName": user.firstName + user.lastName,
                "password": '',
                "active": '',
                "roles": [{
                    "roleId": '',
                    "role": ''

                }]
            };


            console.log(userDetails);
            $http({
                method: 'POST',
                url: "http://localhost:8081/forgetPassword",
                headers: {
                    'Content-Type': 'application/json'
                },
                data: userDetails
            }).then(function success(responseData) {
                $scope.TempPass = responseData.data;
                $scope.successDialog = !$scope.successDialog
            }, function error(responseData) {

            })

        }

    });