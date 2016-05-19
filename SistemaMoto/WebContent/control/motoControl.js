var app = angular.module('motoModule',[]);

app.controller('motoControl',function($scope,$http){
	
	var url = 'http://localhost:8180/SistemaMoto/rs/moto';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (motosRetorno) {
			$scope.motos = motosRetorno;
		}).error(function(mensagemErro) {
			alert(mensagemErro);
		});   
	}
	
	$scope.pesquisar();
	
	$scope.novo = function(){
		$scope.moto = {};
	}

    $scope.salvar = function() {
		if ($scope.moto.codigo == '') {
			$http.post(url,$scope.moto).success(function(moto) {
				$scope.motos.push($scope.moto);
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		} else {
			$http.put(url,$scope.moto).success(function(moto) {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.moto.codigo == '') {
			alert('Selecione um cliente');
		} else {
			urlExcluir = url+'/'+$scope.moto.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
			}).error(function (erro) {
				alert(erro);
			});
		}
	}
	
	$scope.seleciona = function(motoTabela) {
		$scope.moto = motoTabela;
	}
});