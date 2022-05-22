angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://127.0.0.1:8189/app';

    $scope.loadProduct = function () {
        $http.get(contextPath + '/products')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };
    $scope.loadProduct();

    $scope.filterProduct = function (){
        $http({
            url: contextPath + '/products/cost',
            method: 'GET',
            params: {
                min: $scope.min,
                max: $scope.max
            }
        }).then(function (response) {
            $scope.productList = response.data;
        })
    }
});