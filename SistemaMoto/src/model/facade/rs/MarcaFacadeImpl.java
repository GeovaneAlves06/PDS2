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

import model.dao.MarcaDao;
import model.domain.Marca;

@Path("/marca")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MarcaFacadeImpl implements MarcaFacade {

	@Inject
	private MarcaDao marcaDao;
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#getClientes()
	 */
	@Override
	@GET
	public List<Marca> getMarcas() {
		return marcaDao.getMarcas(new Marca());
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#getClientes(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public List<Marca> getMarcas(@PathParam("codigo") Integer codigo) {
		Marca marca= new Marca();
		marca.setCodigo(codigo);
		return marcaDao.getMarcas(marca);
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#salvar(model.domain.Cliente)
	 */
	@Override
	@POST 
	public Marca salvar(Marca marca) { 
		marca = marcaDao.salvar(marca);
	 	return marca;
	}
	
	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#atualizar(model.domain.Cliente)
	 */
	@Override
	@PUT 
	public void atualizar(Marca marca) { 
		marcaDao.atualizar(marca);
	}

	/* (non-Javadoc)
	 * @see model.facade.rs.ClienteFacade#deletarCliente(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void deletarMarca(@PathParam("codigo") Integer codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marcaDao.excluir(marca);
	}

}
