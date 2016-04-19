'use strict';



angular.module('ecommerce', ['storeService','panierService']).
config(['$routeProvider', function ($routeProvider) {
$routeProvider.
    when('/store/list', {templateUrl:'views/store-list.html', controller:storeListController}).
    when('/store/panier', {templateUrl:'views/shoppingCart.htm', controller:storeListController}).
    when('/store/ajoutClient', {templateUrl:'views/addUser.html', controller:storeListController}).
    when('/store/connectionCommander', {templateUrl:'views/login.html', controller:storeListController}).
    when('/store/remerciement', {templateUrl:'views/thanks.html', controller:storeListController}).
    when('/store/ajoutClientPrecommande', {templateUrl:'views/addUserPreCommande.html', controller:storeListController}).
    when('/store/connectionCommanderPreCommande', {templateUrl:'views/loginPreCommande.html', controller:storeListController}).
    when('/store/modificationClient', {templateUrl:'views/updateUser.html', controller:storeListController}).
    when('/store/gestionAdmin', {templateUrl:'views/gestionAdmin.html', controller:storeListController}).
    when('/store/PageAjouterArticle', {templateUrl:'views/addArticle.html', controller:storeListController}).
    when('/store/PageSupprimerArticle', {templateUrl:'views/deleteArticle.html', controller:storeListController}).
    when('/store/supprimerArticle', {templateUrl:'views/deleteArticle.html', controller:storeListController}).
    when('/store/DetailsCommande', {templateUrl:'views/DetailsCommande.html', controller:storeListController}).
    when('/maps', {templateUrl:'views/maps.html', controller:storeListController}).
    otherwise({redirectTo:'/store/list'});
}]);