package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.MarcaDao;
import model.domain.Marca;

@WebService(serviceName="ws/marca")

public class MarcaFacadeImpl implements MarcaFacade {
	
	@Inject
	private MarcaDao marcaDao;
			
	@WebMethod
	public List<Marca> getMarcas() {
		return marcaDao.getMarcas(new Marca());
	}
	
	@Override
	@WebMethod(operationName="getMarcaCodigo")
	public List<Marca> getMarcas(@WebParam(name="codigoMarca") 
							Integer codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		return marcaDao.getMarcas(marca);
	}
	
	@WebMethod
	public Marca salvar(@WebParam(name="marca") Marca marca) {
		return marcaDao.salvar(marca);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="marca") Marca marca) {
		marcaDao.atualizar(marca);
	}
	
	@WebMethod
	public void deletarMarca(@WebParam(name="codigoMarca") Integer codigo) {
		Marca marca = new Marca();
		marca.setCodigo(codigo);
		marcaDao.excluir(marca);
	}


}
