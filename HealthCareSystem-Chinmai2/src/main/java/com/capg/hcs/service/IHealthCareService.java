package com.capg.hcs.service;

import java.util.List;


import com.capg.hcs.entity.DiagnosticCenterBean;

public interface IHealthCareService {
	public DiagnosticCenterBean addCenter(DiagnosticCenterBean center);
	
	public DiagnosticCenterBean getCenter(int center_id);
	
	public List<DiagnosticCenterBean> displaycenter();
	
	public DiagnosticCenterBean deleteCenter(int center_id);
	

}
