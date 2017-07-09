/**
 * Created by BS190 on 7/5/2017.
 */
angular.module('myApp',[]).
controller('formCtrl', function($scope,$http,$window) {
    $scope.tableSelection = {};

    var pserialNo=0;

    $scope.updatePatient={
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
        url: 'http://localhost:8081/studentInfo',

        headers: {
            'Content-Type': 'application/json'
        }

    }).then(function mySuccess(response) {
        $scope.patientdata=response.data;
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
        $scope.patientSerialNo=response.data;
        pserialNo = $scope.patientSerialNo.serialNo
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

    $scope.editpatient = function (data){
        $scope.parent = {'checkOut':data.db};
        $scope.calculatedage=data.age;
        $scope.updatePatient={
            "userName":data.userName,
            "email":data.email,
            "password":data.password,
            "studentId":data.healthId,
            "db":$scope.parent.checkOut,
            "age":$scope.calculatedage,
            "serialNo":data.serialNo,


        };


    };
    $scope.updatePatientInformation=function(){
        $scope.editedPatient={
            "userName": $scope.updatePatient.userName,
            "email": $scope.updatePatient.email,
            "password": $scope.updatePatient.password,
            "studentId": $scope.updatePatient.healthId,
            "db":$scope.parent.checkOut,
            "age":$scope.calculatedage,
            "serialNo": $scope.updatePatient.serialNo,


        };

        $http({
            method: 'POST',
            url: 'http://localhost:8081/add/createStudent',
            data:$scope.editedPatient,
            headers: {
                'Content-Type': 'application/json'
            }

        }).then(function mySuccess(response) {




        }, function myError(response) {
            $scope.myWelcome = response.statusText;
        })
        $window.location.reload();


    };

    $scope.removeSelectedItem=function(){
        for(var i=$scope.patientdata.length-1;i>=0;i--){
            if($scope.tableSelection[i]){
                console.log($scope.patientdata[i].serialNo);
                //$scope.patientdata.slice(i,1)

                delete $scope.tableSelection[i];
                if($scope.patientdata[i].serialNo!=pserialNo){
                    $http({
                        method: 'DELETE',
                        url: 'http://localhost:8081/deleteStudent/'+$scope.patientdata[i].serialNo

                    }).then(function mySuccess(response) {


                        $window.location.reload();

                    }, function myError(response) {
                        $scope.myWelcome = response.statusText;
                    })

                }else{
                    window.alert('You can not remove your own account!')}




            }
        }
    };
    $scope.deletepatient=function(fordeleteData){
        console.log("delete"+fordeleteData.serialNo);
        var DeleteserialNo=fordeleteData.serialNo
        if(DeleteserialNo != pserialNo){
            $http({
                method:'DELETE',
                url:'http://localhost:8081/deleteStudent/'+DeleteserialNo
            }).then(function mySuccess(resonse){
                $window.location.reload();

            },function myError(resonse){

            });

        }else{window.alert('You can not remove your own account!');}



    }




    $scope.addStudent=function(){
        $window.location.href = 'http://localhost:8081/createStudent';
    }

});
