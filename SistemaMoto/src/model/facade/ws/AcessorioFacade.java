package model.facade.ws;

import java.util.List;

import model.domain.Acessorio;

public interface AcessorioFacade {

	List<Acessorio> getAcessorios();

	Acessorio salvar(Acessorio acessorio);

	List<Acessorio> getAcessorios(Integer codigo);

	public void atualizar(Acessorio acessorio);

	public void deletarAcessorio(Integer codigo);

}