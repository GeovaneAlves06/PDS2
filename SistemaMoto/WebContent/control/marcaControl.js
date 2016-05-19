var app = angular.module('marcaModule',[]);
app.controller('marcaControl',function($scope, $http) {
	
	
		var url = 'http://localhost:8180/SistemaMoto/rs/marca';

	
	$scope.pesquisar = function(){
		
		$http.get(url).success(function(marcasRetorno){
			$scope.marcas = marcasRetorno;
		}).error(function(mensagemErro){
			
			alert(mensagemErro);	
		});
		
	}
	
	$scope.pesquisar();
	
	
	
	
	$scope.novo = function(){
		$scope.marca = "";
	}
	
	$scope.salvar = function(){
		$http.post(url).success(function(marcasRetorno){
			$scope.marcas.push(marcasRetorno);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);	
		});
		
		
	}
	$scope.seleciona = function(marcaTabela){
		$scope.marca=marcaTabela;
	}
	
	$scope.excluir = function(){
		$scope.marcas.splice($scope.marca.indexOf($scope.marca),1);
		$scope.novo();
	}
	
	$scope.pesquisar = function(){
		
	}
	
});