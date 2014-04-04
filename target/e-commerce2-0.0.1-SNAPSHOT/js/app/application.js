'use strict';



angular.module('ecommerce', ['storeService','panierService']).
config(['$routeProvider', function ($routeProvider) {
$routeProvider.
    when('/store/list', {templateUrl:'views/store-list.html', controller:storeListController}).
    when('/store/panier', {templateUrl:'views/shoppingCart.htm', controller:storeListController}).
    otherwise({redirectTo:'/store/list'});
}]);