package model.facade.rs;

import java.util.List;

import model.domain.Acessorio;

public interface AcessorioFacade {

	Acessorio salvar(Acessorio acessorio);

	List<Acessorio> getAcessorios();

	List<Acessorio> getAcessorios(Integer codigo);

	public void atualizar(Acessorio acessorio);

	public void deletarAcessorio(Integer codigo);

}