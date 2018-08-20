var myApp = angular.module('myApp', ['pessoaService']);

myApp.controller('pessoaCtrl', function ($scope, pessoaDataOp) {

    $scope.persons =  getPersons();
    $scope.person = {};
   
    function getPersons (){
        pessoaDataOp.getPersons().then(function(response){
                 $scope.persons = response.data;
           }),function(){
               console.log('ata')
           };
           
       }


    $scope.addPersons = function (){
        pessoaDataOp.addPersons($scope.person).then(function(){
            getPersons();

      }),function(){
          console.log('ata')
      };
    }

   
});
