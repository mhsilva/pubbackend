'use strict';

// Declare app level module which depends on partials, and components
angular.module('myApp', [
    'ngRoute',
    'ui.bootstrap',
    'myApp.register'
]).config(['$routeProvider',function ($routeProvider) {
    $routeProvider.otherwise({redirectTo: '/index'});
}]);