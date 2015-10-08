(function () {

  var app = angular.module('cloudApp', [
    'ngRoute',
    'cloudApp.controllers',
    'cloudApp.services'
  ]);
  
  app.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
      .when('/', {
          controller: 'PostController'
      })
      

  }]);

  
})();