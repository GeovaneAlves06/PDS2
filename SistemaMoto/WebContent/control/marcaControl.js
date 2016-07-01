var marcaModule = angular.module('marcaModule', []);

marcaModule.controller("marcaControl", 
		function($scope,$http) {
	url = 'http://localhost:8180/SistemaMoto'+
			'/rs/moto';
	
	urlMoto = 'http://localhost:8180/SistemaMoto'+
	'/rs/moto';
	
	$scope.pesquisarMotos = function() {
		$http.get(urlMoto).success(function (motos) {
			$scope.motos = motos;
		}).error(function (erro) {
			alert(erro);
		});
	};
		
	$scope.pesquisar = function() {
		$http.get(url).success(function (marcas) {
			$scope.marcas = marcas;
		}).error(function (erro) {
			alert(erro);
		});
	};	
	
	$scope.novo = function() {
		$scope.marca = "";	
		$scope.motoMarcaSelecionado = "";
		$scope.marcaMoto = [];
		$scope.desabilitaSalvar = false;
	};
	
	$scope.seleciona = function(marca) {
		$scope.marca = marca;
		$scope.desabilitaSalvar = true;
		$scope.telefones = [];
		$scope.telefones.push($scope.sms.telefone);
		for (posicao in $scope.motos) {
			moto = $scope.motos[posicao];
			for (posicao1 in moto.marcas) {
				marca = moto.marcas[posicao1];
				if (marca.numero == $scope.marca.marca.numero) {
					$scope.motoSelecionado = moto;
				}				
			}			
		}		
	};
	
	$scope.alteramarcasRetorno = function() {
		$scope.marcaMoto = $scope.motoMarcaSelecionado.marcas;		
	};
		
	$scope.salvar = function() {    	
    	if ($scope.marca.codigo == undefined || $scope.marca.codigo == '') {    		
			$http.post(url,$scope.marca).success(function(motoRetornado) {
				$scope.marcas.push(motoRetornado);
				$scope.novo();
				$scope.mensagens.push('Marca salva com sucesso');
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
		if ($scope.marca.codigo == '') {
			alert('Selecione uma marca');
		} else {
			urlExcluir = url+'/'+$scope.marca.codigo;
			$http.delete(urlExcluir).success(function () {
				$scope.pesquisar();
				$scope.novo();
				$scope.mensagens.push('Marca excluída com sucesso');
			}).error(function (erro) {
				$scope.mensagens.push('Erro ao excluir Marca: '+erro);
			});
		}
	}
	
	$scope.pesquisar();
	$scope.pesquisarMotos();
	
	
		
	});