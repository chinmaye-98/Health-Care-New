package com.capg.hcs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.hcs.dao.IHealthCareDao;
import com.capg.hcs.entity.DiagnosticCenterBean;

/* @Author Chinmaye*/
@Service
public class HealthCareServiceImpl implements IHealthCareService {
	
	
	
	@Autowired
	IHealthCareDao dao;
	
	@Override
	public DiagnosticCenterBean addCenter(DiagnosticCenterBean center) {
		
		return dao.addCenter(center);
	}
	
	@Override
	public DiagnosticCenterBean getCenter(int center_id) {
		
		return dao.getCenter(center_id);
	}

	@Override
	public List<DiagnosticCenterBean> displaycenter() {
		
		return dao.displaycenter();
	}

	@Override
	public DiagnosticCenterBean deleteCenter(int center_id) {
		
		return dao.deleteCenter(center_id);
		
	}




	
	
	

}
