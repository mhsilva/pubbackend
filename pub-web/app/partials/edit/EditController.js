angular.module('myApp.register', ['ngRoute'])
    .config(['$routeProvider', function ($routeProvider) {
        $routeProvider.when('/edit', {
            templateUrl: 'partials/edit/edit.html',
            controller: 'EditController'
        }).otherwise({redirectTo: '/index'});
    }])
    .controller('EditController', ['$scope', '$http', function ($scope, $http) {
        $scope.selected = false;
        $scope.saveButton = null;
        $scope.companyName = null;
        $scope.establishment = null;
        $scope.waiters = [];
        $scope.url = '//pubbackend.herokuapp.com/establishment';
        $scope.addWaiter = function () {
            $scope.waiters.push({'login': $scope.login})
            $scope.login = '';
        }
        $scope.removeWaiter = function (waiter) {
            var index = $scope.waiters.indexOf(waiter);
            if (index != -1) {
                $scope.waiters.splice(index, 1);
            }
        }
        $scope.getEstablishment = function (name) {
            return $http.get($scope.url, {
                params: {
                    name: name
                }
            }).then(function (response) {
                return response.data;
            });
        }
        $scope.onSelectEstablishment = function ($item, $model, $label) {
            $scope.waiters = $item.waiters;
            $scope.establishment = $item;
            $scope.selected = true;
        }
        $scope.saveForm = function () {
            $scope.establishment.waiters = $scope.waiters;
            $http.post($scope.url, $scope.establishment)
                .success(function () {
                    console.log("Success");
                })
                .error(function () {
                    console.log("Error");
                });
        };
        $scope.hasSelected = function () {
            return $scope.selected;
        };
    }]);