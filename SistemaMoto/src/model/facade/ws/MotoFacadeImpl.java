package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import model.dao.MotoDao;
import model.domain.Moto;

@WebService(serviceName="ws/moto")
public class MotoFacadeImpl implements MotoFacade {
	
	@Inject
	private MotoDao motoDao;
			
	@WebMethod
	public List<Moto> getMotos() {
		return motoDao.getMotos(new Moto());
	}
	
	@Override
	@WebMethod(operationName="getMotoCodigo")
	public List<Moto> getMotos(@WebParam(name="codigoMoto") 
							Integer codigo) {
		Moto moto = new Moto();
		moto.setCodigo(codigo);
		return motoDao.getMotos(moto);
	}
	
	@WebMethod
	public Moto salvar(@WebParam(name="moto") Moto moto) {
		return motoDao.salvar(moto);
	}
	
	@WebMethod
	public void atualizar(@WebParam(name="moto") Moto moto) {
		motoDao.atualizar(moto);
	}
	
	@WebMethod
	public void deletarMoto(@WebParam(name="codigoMoto") Integer codigo) {
		Moto moto = new Moto();
		moto.setCodigo(codigo);
		motoDao.excluir(moto);
	}


}
