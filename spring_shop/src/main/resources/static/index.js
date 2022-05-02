angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://127.0.0.1:8189/app';

    $scope.loadProduct = function () {
        $http.get(contextPath + '/product/all')
            .then(function (response) {
                $scope.productList = response.data;
            });
    };

    $scope.loadBuyer = function () {
        $http.get(contextPath + '/buyer/all')
            .then(function (response) {
                $scope.buyerList = response.data;
            });
    };
    $scope.loadBuyer();

    $scope.changeCost = function (productId, delta) {
        $http({
            url: contextPath + '/product/change_cost',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function () {
            $scope.loadProduct();
        });
    };

    // $scope.remove = function (productId) {
    //     $http({
    //         url: contextPath + '/product/remove',
    //         method: 'GET',
    //         params: {
    //             productId: productId
    //         }
    //     }).then(function () {
    //         $scope.loadProduct();
    //     })
    // }

    $scope.loadProduct();
});