'use strict';

function storeListController($scope,$rootScope, $location,$http, Article, Panier ,PanierVirtuel) {
	$scope.cart  = PanierVirtuel.cart;
	$scope.articles = Article.query();

    $scope.goPanier = function() {
    	$location.path("/store/panier");
    } ;

    $scope.goToMainPage = function(){
    	$location.path("/store/list");
    };
    
    
  
    
    
    // le client arrive sur la page d'accueil  
    
    $scope.ajoutClientPrecommande = function(){
    	
    	$location.path("/store/ajoutClientPrecommande");
    };
    
    $scope.modifClient = function(){
    	$location.path("/store/modificationClient");
    };
    
    $scope.modifierClientCommande = function(client){
    	$http.post("rest/updateClient",client);
    	$location.path("/store/list");
    };
    
    $scope.connection = function(){
    	$location.path("/store/connectionCommanderPreCommande");
    };
    
    $scope.enregistrerClientPreCommande = function(client){
    	$rootScope.client = client;
    	$http.post("rest/addClient",client);
    	$location.path("/store/list");
    	$scope.connected = true;
    };
    
   $scope.authentificationClientPreCommander= function(client){
	   if((client.mail.localeCompare("admin")==0) && (client.motDePasse.localeCompare("admin")==0) ){
				$scope.Commandes = $http.get("rest/getAllCommande");
				 $location.path("/store/gestionAdmin");
	   }
	   else {
	   $http.post("rest/authentification",client).success(function(reponse){
	    	  $rootScope.client=reponse;
			  $scope.cart  = client.panier;
			  $location.path("/store/list");
			  $scope.connected = true;
	   }).error(function(error){
		   $scope.erreur = true;
			  $location.path("/store/connectionCommanderPreCommande");
	   });
	
	   }
	 
   };
    
	  function refresh(){
		  $rootScope.client =null;
		  $rootScope.client.panier = null;
		  $rootScope.panier = null;
		  $scope.cart = null;
	  }
	  
	  
    
    // client a fini sa commande il s'apprete a payer
   
   $scope.addUser = function(){
   	$location.path("/store/ajoutClient");
   };
   
    $scope.commander = function(panier){
    	$rootScope.panier=panier;
    	if ($rootScope.client == null ){
    		$location.path("/store/connectionCommander");
    	}else{
    		$rootScope.client.panier = panier;
    		  $http.post("rest/payerClient",$rootScope.client);
    		  $location.path("store/remerciement");
    		  refresh();
    	}
    };
    
    $scope.enregistrerClientCommande = function(client){
    	client.panier= $rootScope.panier;
    	$http.post("rest/payerClient",client);
    	$location.path("/store/remerciement");
    	 refresh();
    };
    
   $scope.authentificationClientCommander= function(client){
	    $http.post("rest/authentification",client).success(function(reponse){
		  $rootScope.client=reponse;
		  $rootScope.client.panier = $rootScope.panier ;
		  $http.post("rest/payerClient",$rootScope.client);
		  $location.path("store/remerciement");
		  refresh();
   }).error(function(error){
	   $scope.erreur = true;
		  $location.path("/store/connectionCommander");
   });
   };
   
   
   // gestion administrateur 
   
   $scope.PageAjouterArticle = function(){
   	
   	$location.path("/store/PageAjouterArticle");
   };
   
   $scope.ajouterArticle = function(article){
	   	
	   $http.post("rest/ajoutArticle",article);
	   };
   
	   
	   $scope.PageSupprimerArticle = function(){
			$location.path("/store/PageSupprimerArticle");
			   $scope.commandes = $http.get("rest/getAllCommande");

	   };  
	   $scope.commandes = $http.get("rest/getAllCommande");

	   
	   $scope.supprimerArticle = function(article){
		   $http.post("rest/supprimerArticle",article); 
		   $scope.articles.splice(article, 1);
	   };
   
	   $scope.supprimerCommande = function(commande){
		   $http.post("rest/supprimerCommande",commande); 
		   $scope.commandes.data.splice(commande, 1);
	   };
   
}


