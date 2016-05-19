package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Acessorio;

public class AcessorioDaoImpl implements AcessorioDao {
	
	@PersistenceContext(unitName="SistemaMotoPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Acessorio> getAcessorios(Acessorio acessorio) {
		StringBuffer hql = new StringBuffer("from acessorio c"
				+ " where 1 = 1");		
		if (acessorio.getCodAcessorio() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (acessorio.getCodAcessorio() != null) {
			query.setParameter("codigo",acessorio.getCodAcessorio());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Acessorio acessorio) {
		acessorio = entityManager.merge(acessorio);
		entityManager.remove(acessorio);
	}

	@Override
	@Transactional
	public Acessorio salvar(Acessorio marca) {
		entityManager.persist(marca);
		return marca;
	}

	@Override
	@Transactional
	public void atualizar(Acessorio acessorio) {
		acessorio = entityManager.merge(acessorio);
		entityManager.persist(acessorio);		
	}
}