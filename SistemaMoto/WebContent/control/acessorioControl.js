var app = angular.module('acessorioModule',[]);
app.controller('acessorioControl',function($scope,$http) {

	var url = 'http://localhost:8180/SistemaMoto/rs/acessorio';

		
	$scope.pesquisar = function(){
		
		$http.get(url).success(function(acessoriosRetorno){
			$scope.acessorios = acessoriosRetorno;
		}).error(function(mensagemErro){
			
			alert(mensagemErro);	
		});
		
	}
	
	$scope.pesquisar();
	
	
	
	
	$scope.novo = function(){
		$scope.acessorio = "";
	}
	
	$scope.salvar = function(){
		$http.post(url).success(function(acessoriosRetorno){
			$scope.acessorios.push(acessoriosRetorno);
			$scope.novo();
		}).error(function(mensagemErro){
			alert(mensagemErro);	
		});
		
		
	}
	$scope.seleciona = function(acessorioTabela){
		$scope.acessorio=acessorioTabela;
	}
	
	$scope.excluir = function(){
		$scope.acessorios.splice($scope.acessorio.indexOf($scope.acessorio),1);
		$scope.novo();
	}
	
	$scope.pesquisar = function(){
		
	}
	
});