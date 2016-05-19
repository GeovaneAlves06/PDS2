package model.dao;

import java.util.List;

import model.domain.Marca;

public interface MarcaDao {

	List<Marca> getMarcas(Marca marca);
	
	public void excluir(Marca marca);

	Marca salvar(Marca marca);

	void atualizar(Marca marca);

}