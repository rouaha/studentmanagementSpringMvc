/**
 * Created by BS190 on 7/5/2017.
 */
angular.module('myApp',[]).
controller('formCtrl', function($scope,$http,$window) {
    $scope.tableSelection = {};
    $scope.successDialog = false;
    $scope.warningDialog = false;
    var pserialNo=0;

    $scope.updateStudent={
        "userName":"",
        "email":"",
        "password":"",
        "studentId":"",
        "db":"",
        "age":"",
        "serialNo":"",
        "status":""
    };
    $http({
        method: 'GET',
        url: 'http://localhost:8081/secure/studentInfo',

        headers: {
            'Content-Type': 'application/json'
        }

    }).then(function mySuccess(response) {
        $scope.studentdata=response.data;
        console.log(response);


    }, function myError(response) {
        $scope.myWelcome = response.statusText;
    });

    $http({
        method: 'GET',
        url: 'http://localhost:8081/UserMain/rest/getSerialNo',

        headers: {
            'Content-Type': 'application/json'
        }

    }).then(function mySuccess(response) {
        $scope.studentSerialNo=response.data;
        pserialNo = $scope.studentSerialNo.serialNo
        //console.log('ser '+$scope.patientSerialNo.serialNo);


    }, function myError(response) {
        $scope.myWelcome = response.statusText;
    });

    $scope.calculateAge= function(){
        var db=$scope.parent.checkOut;

        var birthday = new Date(db);
        var ageDifMs = Date.now() - birthday.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        var age= Math.abs(ageDate.getUTCFullYear() - 1970);
        $scope.calculatedage=age + " Years";


    };

    $scope.editStudentOnclick = function (data){
        $scope.parent = {'checkOut':data.db};
        $scope.calculatedage=data.age;
        $scope.updateStudent={
            "userName":data.userName,
            "email":data.email,
            "password":data.password,
            "studentId":data.studentId,
            "db":$scope.parent.checkOut,
            "age":$scope.calculatedage,
            "serialNo":data.serialNo,


        };


    };
    $scope.updateStudentInformation=function(){
        $scope.editedStudent={
            "userName": $scope.updateStudent.userName,
            "email": $scope.updateStudent.email,
            "password": $scope.updateStudent.password,
            "studentId": $scope.updateStudent.studentId,
            "db":$scope.parent.checkOut,
            "age":$scope.calculatedage,
            "serialNo": $scope.updateStudent.serialNo,


        };

        $http({
            method: 'POST',
            url: 'http://localhost:8081/add/createStudent',
            data:$scope.editedStudent,
            headers: {
                'Content-Type': 'application/json'
            }

        }).then(function mySuccess(response) {




        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        });

        $window.location.reload();


    };

    $scope.removeSelectedItem = function () {
        if ($scope.tableSelection != null) {
            for (var i = $scope.studentdata.length - 1; i >= 0; i--) {
                if ($scope.tableSelection[i]) {
                console.log($scope.studentdata[i].serialNo);
                //$scope.studenttdata.slice(i,1)

                delete $scope.tableSelection[i];
                    if ($scope.studentdata[i].serialNo != pserialNo) {
                    $http({
                        method: 'DELETE',
                        url: 'http://localhost:8081/secure/deleteStudent/' + $scope.studentdata[i].serialNo

                    }).then(function mySuccess(response) {
                        $scope.successDialog = !$scope.successDialog;

                        // $window.location.reload();

                    }, function myError(response) {
                        $scope.myWelcome = response.statusText;
                        $scope.warningDialog = !$scope.warningDialog;
                    })

                    } else {
                        window.alert('You can not remove your own account!')
                    }


            }
        }
            $scope.successDialog = !$scope.successDialog;
        } else {
            $scope.warningDialog = !$scope.warningDialog;
        }
    };
    $scope.deleteStudent=function(fordeleteData){
        console.log("delete"+fordeleteData.serialNo);
        var DeleteserialNo = fordeleteData.serialNo;
        if(DeleteserialNo != pserialNo){
            $http({
                method:'DELETE',
                url:'http://localhost:8081/secure/deleteStudent/'+DeleteserialNo
            }).then(function mySuccess(resonse){
                $window.location.reload();

            },function myError(resonse){

            });

        }else{window.alert('You can not remove your own account!');}


    };




    $scope.addStudent=function(){
        $window.location.href = 'http://localhost:8081/createStudent';
    }

});
