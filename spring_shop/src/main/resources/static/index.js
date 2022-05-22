angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://127.0.0.1:8189/app';

    $scope.pages = [];
    $scope.loadProduct = function (p){
        $http({
            url: contextPath + '/api/v1/products',
            method: 'GET',
            params: {
                page: p,
                min_cost: $scope.min,
                max_cost: $scope.max,
                title: $scope.title
            }
        }).then(function (response) {
            $scope.productList = response.data.content;
            $scope.pages = [];
            for (i = 0; i < response.data.totalPages; i++) {
                $scope.pages.push(i+1)
            }
            console.log($scope.pages)
        })
    }
    $scope.loadProduct();
});