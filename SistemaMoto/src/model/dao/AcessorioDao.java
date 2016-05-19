package model.dao;

import java.util.List;

import model.domain.Acessorio;

public interface AcessorioDao {

	List<Acessorio> getAcessorios(Acessorio acessorio);
	
	public void excluir(Acessorio acessorio);

	Acessorio salvar(Acessorio acessorio);

	void atualizar(Acessorio acessorio);

}