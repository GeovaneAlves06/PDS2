package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.BindingType;
import model.dao.AcessorioDao;
import model.domain.Acessorio;

@WebService(serviceName="ws/acessorio")
@SOAPBinding(style = SOAPBinding.Style.RPC)
@BindingType(value= javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING)
public class AcessorioFacadeImpl implements AcessorioFacade {
	
	@Inject
	private AcessorioDao acessorioDao;
	
	/* (non-Javadoc)
	 * @see model.facade.ws.AcessorioFacade#getAcessorios()
	 */
	
	@WebMethod
	public List<Acessorio> getAcessorios() {
		return acessorioDao.getAcessorios(new Acessorio());
	}
	
	/* (non-Javadoc)
	 * @see model.facade.ws.AcessorioFacade#getAcessorios(model.domain.Acessorio)
	 */
	
	@WebMethod(operationName="getAcessorioCodigo")
	public List<Acessorio> getAcessorios(@WebParam(name="codigoAcessorio")Integer codigo) {
		Acessorio acessorio =  new Acessorio();
		acessorio.setCodAcessorio(codigo);
		return acessorioDao.getAcessorios(acessorio);
	}
	
	
	@WebMethod
	public Acessorio salvar(@WebParam(name="acessorio")Acessorio acessorio) {
		acessorio = acessorioDao.salvar(acessorio);
		return acessorio;
	}
	
	
	@WebMethod
	public void atualizar(@WebParam(name="acessorio")Acessorio acessorio) {
		acessorioDao.atualizar(acessorio);
	}
	
	
	
	@WebMethod
	public void deletarAcessorio(@WebParam(name="codigoAcessorio")Integer codigo) {
		
		Acessorio acessorio =  new Acessorio();
		acessorio.setCodAcessorio(codigo);
	    acessorioDao.excluir(acessorio);
	
}

	
}
