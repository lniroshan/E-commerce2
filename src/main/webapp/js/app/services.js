'use strict';

angular.module('storeService', ['ngResource']).
        factory('Article', function ($resource) {
            return $resource('rest/store', {}, {
                'query': { method: 'GET', isArray: true}
            });
        });
        angular.module('panierService', ['ngResource']).factory('Panier', function ($resource) {
            return $resource('rest/panier', {}, {
                'POST': { method: 'POST'}
            });
        }).factory('PanierVirtuel', function () {
            var mycart =  new shoppingCart("AngularStore");
            
            return {
            	cart: mycart 
            }
        });
        
