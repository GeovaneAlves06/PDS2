package model.facade.rs;

import java.util.List;

import model.domain.Moto;

public interface MotoFacade {

	Moto salvar(Moto moto);

	List<Moto> getMotos();

	List<Moto> getMotos(Integer codigo);

	public void atualizar(Moto moto);

	public void deletarMoto(Integer codigo);

}