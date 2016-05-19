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

import model.dao.MotoDao;
import model.domain.Moto;

@Path("/moto")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MotoFacadeImpl implements MotoFacade {

	@Inject
	private MotoDao motoDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#getClientes()
	 */
	@Override
	@GET
	public List<Moto> getMotos() {
		return motoDao.getMotos(new Moto());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#getClientes(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Moto> getMotos(@PathParam("codigo") Integer codigo) {
		Moto moto= new Moto();
		moto.setCodMoto(codigo);
		return motoDao.getMotos(moto);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#salvar(model.domain.Cliente)
	 */
	@Override
	@POST 
	public Moto salvar(Moto moto) { 
		moto = motoDao.salvar(moto);
	 	return moto;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#atualizar(model.domain.Cliente)
	 */
	@Override
	@PUT 
	public void atualizar(Moto moto) { 
		motoDao.atualizar(moto);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#deletarCliente(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarMoto(@PathParam("codigo") Integer codigo) {
		Moto moto = new Moto();
		moto.setCodMoto(codigo);
		motoDao.excluir(moto);
	}

}
