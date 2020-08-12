package com.capg.hcs.dao;

import java.util.List;

import com.capg.hcs.entity.DiagnosticCenterBean;

public interface IHealthCareDao {
	public DiagnosticCenterBean addCenter(DiagnosticCenterBean center);
	
	public DiagnosticCenterBean getCenter(int center_id);
	
	 public List<DiagnosticCenterBean >displaycenter();
	 
	 public DiagnosticCenterBean deleteCenter(int center_id);

}
