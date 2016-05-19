package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Marca;

public class MarcaDaoImpl implements MarcaDao {
	
	@PersistenceContext(unitName="SistemaMotoPU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Marca> getMarcas(Marca marca) {
		StringBuffer hql = new StringBuffer("from marca c"
				+ " where 1 = 1");		
		if (marca.getCodigo() != null) {
			hql.append(" and c.codigo = :codigo");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (marca.getCodigo() != null) {
			query.setParameter("codigo",marca.getCodigo());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Marca marca) {
		marca = entityManager.merge(marca);
		entityManager.remove(marca);
	}

	@Override
	@Transactional
	public Marca salvar(Marca marca) {
		entityManager.persist(marca);
		return marca;
	}

	@Override
	@Transactional
	public void atualizar(Marca marca) {
		marca = entityManager.merge(marca);
		entityManager.persist(marca);		
	}
	

}
