var app = angular.module('motoModule',[]);

app.controller('motoControl',function($scope,$http){
	var url = 'http://localhost:8180/SistemaMoto/rs/moto';
	
	$scope.pesquisar = function(){
		$http.get(url).success(function (motosRetorno) {
			$scope.motos = motosRetorno;
		}).error(function(mensagemErro) {
			$scope.mensagens.push('Erro ao pesquisar motos '+mensagemErro);
		});   
	}
	
	
	$scope.novo = function(){
		$scope.moto = {};
		$scope.mensagens = [];
	}
	
	$scope.montaMensagemErro = function(listaErro) {
		$scope.mensagens = [];
		$scope.mensagens.push('Falha de validação retornada do servidor');
		angular.forEach(listaErro, function(value, key){
			 $scope.mensagens.push(value.message);
		});
	}

    $scope.salvar = function() {    	
    	if ($scope.moto.codigo == undefined || $scope.moto.codigo == '') {    		
			$http.post(url,$scope.moto).success(function(motoRetornado) {
				$scope.motos.push(motoRetornado);
				$scope.novo();
				$scope.mensagens.push('Moto salva com sucesso');
			}).error(function (erro) {
				//$scope.mensagens.push('Erro ao salvar Moto: '+JSON.stringify(erro));
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		} else {
			$http.put(url,$scope.moto).success(function(moto) {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Moto atualizada com sucesso');
			}).error(function (erro) {
				$scope.montaMensagemErro(erro.parameterViolations);
			});
		}		
	}
	
	$scope.excluir = function() {
		if ($scope.moto.codigo == '') {
			alert('Selecione uma Moto');
		} else {
			urlExcluir = url+'/'+$scope.moto.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Moto excluída com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir Moto: '+erro);
			});
		}
	}
	
	$scope.seleciona = function(motoTabela) {
		$scope.moto = motoTabela;
	}
	
	$scope.pesquisar();
	$scope.novo();
});