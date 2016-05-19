package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Moto;

public class MotoDaoImpl implements MotoDao {
	
	@PersistenceContext(unitName="SistemaMotoPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Moto> getMotos(Moto moto) {
		StringBuffer hql = new StringBuffer("from Moto c"
				+ " where 1 = 1");		
		if (moto.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (moto.getCodigo() != null) {
			query.setParameter("codigo",moto.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Moto moto) {
		moto = entityManager.merge(moto);
		entityManager.remove(moto);
	}

	@Override
	@Transactional
	public Moto salvar(Moto moto) {
		entityManager.persist(moto);
		return moto;
	}

	@Override
	@Transactional
	public void atualizar(Moto moto) {
		moto = entityManager.merge(moto);
		entityManager.persist(moto);		
	}
	

}
