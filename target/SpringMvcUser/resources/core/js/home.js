
 angular.module('myApp', []).
 controller('formCtrl', function($scope,$http,$window) {
    var baseurl="http://localhost:8081/";
    $scope.parent = {'checkOut':''};
    $scope.studentage=0;
    $scope.UserlogDetails=[];
    $scope.chekedmail='';
    var mail=false;
    $scope.calculateAge= function(){
        var db=$scope.parent.checkOut;
        console.log("test db"+db);
        var birthday = new Date(db);
        var ageDifMs = Date.now() - birthday.getTime();
        var ageDate = new Date(ageDifMs); // miliseconds from epoch
        var chage=ageDate.getUTCFullYear() - 1970;
        var age= Math.abs(ageDate.getUTCFullYear() - 1970);
        $scope.studentage=age + " Years";
        console.log('Test focus age...'+chage);

    };

    $scope.regi=function(){


        var userDetails={
            "userName":$scope.Userregi.userName,
            "email":$scope.Userregi.email,
            "password":$scope.Userregi.password,
            "studentId":"",
            "db":$scope.parent.checkOut,
            "age":$scope.studentage,
            "serialNo":'',
        };

        console.log(userDetails);
        if(studentdata.data.email!=$scope.Userregi.email){
            $http({
                method: 'POST',
                url: 'http://localhost:8081/add/createStudent',
                data:userDetails,
                headers: {
                    'Content-Type': 'application/json'
                }

            }).then(function mySuccess(response) {

                console.log(userDetails);
                // $window.location.href = 'http://localhost:8080/login'

            }, function myError(response) {
                $scope.myWelcome = response.statusText;
            })

        }else{
            window.alert("Email is already extis!")
        }

    };
    $scope.model = {
        isDisabled: false
    };
    $scope.emailcheck=function () {
        console.log($scope.Userregi.email);
        var emailDetails={
            "userName":'',
            "email":$scope.Userregi.email,
            "password":''
        }
        $http({
            method: 'POST',
            url: 'http://localhost:8081/checkEmail',
            data:emailDetails,

            headers: {
                'Content-Type': 'application/json'
            }

        }).then(function mySuccess(response) {
            var studentdata=response;
            $scope.chekedmail=studentdata.data.email;
            if( $scope.Userregi.email==studentdata.data.email){
                window.alert("Email is already extis!")
                mail=true;
                console.log('true');
                $scope.model = {
                    isDisabled: true
                };

            };



        })
    };
        $scope.createNewStudent=function(){

            var locUrl='';
            var userDetails={
                "userName":$scope.Userregi.userName,
                "email":$scope.Userregi.email,
                "password":$scope.Userregi.password,
                "studentId":'',
                "db":$scope.parent.checkOut,
                "age":$scope.studentage,
                "serialNo":'',
            };

            if($scope.checkboxModel.value1){
                locUrl='http://localhost:8081/secure/manageStudent';}
            else{  locUrl='http://localhost:8081/createStudent';
            }
            if(!mail){
                $http({
                    method:'POST',
                    url: 'http://localhost:8081/add/createStudent',
                    data:userDetails,
                    headers: {
                        'Content-Type': 'application/json'
                    }

                }).then(function mySuccess(response) {

                    console.log(userDetails);
                    $window.location.href = locUrl;

                }, function myError(response) {
                    $scope.myWelcome = response.statusText;
                })


          }else{
                window.alert("Email is already extis!")
            }

        };
        $scope.cancelcreateNewStudent=function(){
            $window.location.href = baseurl;
        };



});
