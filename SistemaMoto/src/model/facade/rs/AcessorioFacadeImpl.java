package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.AcessorioDao;
import model.domain.Acessorio;

@Path("/acessorio")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AcessorioFacadeImpl implements AcessorioFacade {

	@Inject
	private AcessorioDao acessorioDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#getClientes()
	 */
	@Override
	@GET
	public List<Acessorio> getAcessorios() {
		return acessorioDao.getAcessorios(new Acessorio());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#getClientes(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Acessorio> getAcessorios(@PathParam("codigo") Integer codigo) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodAcessorio(codigo);
		return acessorioDao.getAcessorios(acessorio);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#salvar(model.domain.Cliente)
	 */
	@Override
	@POST 
	public Acessorio salvar(Acessorio acessorio) { 
		acessorio = acessorioDao.salvar(acessorio);
	 	return acessorio;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#atualizar(model.domain.Cliente)
	 */
	@Override
	@PUT 
	public void atualizar(Acessorio acessorio) { 
		acessorioDao.atualizar(acessorio);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#deletarCliente(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarAcessorio(@PathParam("codigo") Integer codigo) {
		Acessorio acessorio = new Acessorio();
		acessorio.setCodAcessorio(codigo);
		acessorioDao.excluir(acessorio);
	}

}
