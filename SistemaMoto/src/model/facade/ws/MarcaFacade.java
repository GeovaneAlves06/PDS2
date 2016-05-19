package model.facade.ws;

import java.util.List;

import model.domain.Marca;

public interface MarcaFacade {

	List<Marca> getMarcas();

	Marca salvar(Marca marca);

	List<Marca> getMarcas(Integer codigo);

	public void atualizar(Marca marca);

	public void deletarMarca(Integer codigo);

}