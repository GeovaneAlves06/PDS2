package model.facade.rs;

import java.util.List;

import model.domain.Marca;

public interface MarcaFacade {

	Marca salvar(Marca marca);

	List<Marca> getMarcas();

	List<Marca> getMarcas(Integer codigo);

	public void atualizar(Marca marca);

	public void deletarMarca(Integer codigo);

}