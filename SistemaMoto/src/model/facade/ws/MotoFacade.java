package model.facade.ws;

import java.util.List;

import model.domain.Moto;

public interface MotoFacade {

	List<Moto> getMotos();

	Moto salvar(Moto moto);

	List<Moto> getMotos(Integer codigo);

	public void atualizar(Moto moto);

	public void deletarMoto(Integer codigo);

}