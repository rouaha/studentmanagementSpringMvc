/**
 * Created by BS190 on 7/30/2017.
 */
angular.module("MyResetApp", [])
    .controller("resetCtrl", function ($scope, $http) {
        $scope.successDialog = false;
        $scope.resetForgetPass = function (resetData) {
            var userTempData = {
                'id': '',
                'userId': "",
                'userEmail': '',
                'userTempPass': resetData.userTempPass,
                'userNewpass': resetData.userNewPass


            };
            $http({
                method: "POST",
                url: "http://localhost:8081/resetForgetPass",
                headers: {'Content-Type': 'application/json'},
                data: userTempData

            }).then(function success(response) {
                $scope.successDialog = !$scope.successDialog;

            }, function error(response) {

            })

        }
    });

