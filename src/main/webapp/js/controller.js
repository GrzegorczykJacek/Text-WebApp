let articleApp = angular.module('articleApp', []);

articleApp.controller('articleController', function ($scope, $http) {
    $scope.init = function () {
        $http({
            method: 'GET',
            url: 'api/articles',
            params: {}
        }).then(
            function (response) {
                $scope.articles = response.data
            }
        );
    };

});