package com.capg.hcs.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import com.capg.hcs.entity.DiagnosticCenterBean;

/*@Author Chinmaye*/
@Repository
@Transactional
public class HealthCareDaoImpl implements IHealthCareDao {
	
	@PersistenceContext
	EntityManager entityManager;
	@Override
	public DiagnosticCenterBean addCenter(DiagnosticCenterBean center) {
		
		entityManager.persist(center);
		 
		 return center;
		 
	}
	
	@Override
	public DiagnosticCenterBean getCenter(int center_id) {
		
		return entityManager.find(DiagnosticCenterBean.class, center_id);
	}

	@Override
	public List<DiagnosticCenterBean> displaycenter() {
		
			TypedQuery<DiagnosticCenterBean> query = entityManager.createQuery("from DiagnosticCenterBean", DiagnosticCenterBean.class);
			return query.getResultList();
	}

	@Override
	public DiagnosticCenterBean deleteCenter(int center_id) {
		
		DiagnosticCenterBean center = entityManager.find(DiagnosticCenterBean.class, center_id);
		entityManager.remove(center);
		 
		
		return center;
	}
	

}
