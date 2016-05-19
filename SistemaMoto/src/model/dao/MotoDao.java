package model.dao;

import java.util.List;

import model.domain.Moto;

public interface MotoDao {

	List<Moto> getMotos(Moto moto);
	
	public void excluir(Moto moto);

	Moto salvar(Moto moto);

	void atualizar(Moto moto);

}