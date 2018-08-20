var StudentService = angular.module('pessoaService', [])
StudentService.factory('pessoaDataOp', ['$http', function ($http) {

    var urlBase = 'http://localhost:8080/stefa';
    var pessoaDataOp = {};

    pessoaDataOp.getPersons= function () {
        return $http.get(urlBase+'/pessoa');
    };

    pessoaDataOp.addPersons = function (person) {
        return $http.post(urlBase + '/pessoa', person);
    };

    return pessoaDataOp;

}]);