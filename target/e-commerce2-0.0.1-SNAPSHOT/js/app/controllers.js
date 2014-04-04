'use strict';

function storeListController($scope, $location,$http, Article, Panier ,PanierVirtuel) {
	$scope.cart  = PanierVirtuel.cart;
	$scope.articles = Article.query();
    $scope.addPanier = function(article){
    	alert(article.nom);
    	$scope.panier =	Panier.query(article);
    	
    };
    $scope.goPanier = function() {
    	$location.path("/store/panier");
    } ;

    $scope.goToMainPage = function(){
    	$location.path("/store/list");
    };
    
    $scope.commander = function(panier){
    	$http.post("rest/panier",panier);
    };
}


