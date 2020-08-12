package com.capg.hcs;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.capg.hcs.dao.IHealthCareDao;
import com.capg.hcs.entity.DiagnosticCenterBean;
import com.capg.hcs.service.IHealthCareService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HealthCareSystemChinmaiApplicationTests {
	@Autowired 
	 private IHealthCareService service;
	
	@MockBean
	private IHealthCareDao dao;
	
	@Test
	/* we are mocking the dao instead of getting the values from db */
	/* through dao we are mocking the data here */
	public void displayCenter() {
		
		when(dao.displaycenter()).thenReturn(Stream
				.of(new DiagnosticCenterBean(7,"KIMS","Secunderabad","DNA test","Blood Group","Blood Sugar"),
						new DiagnosticCenterBean(3,"Apolo","Maredpally","Blood Group","Blood Sugar","Blood Pressure")).collect(Collectors.toList()));
		assertEquals(2,service.displaycenter().size());
		
	}
	
	
	@Test
	public void getCenter() {
		DiagnosticCenterBean bean= new DiagnosticCenterBean();
		/* getting the entire bean by center and mocking the dao */
		bean.setCenter_id(bean.getCenter_id());
		bean.setCenter_name("Apolo");
		bean.setCenter_location("Hyd");
		bean.setTest_1("DNA Test");
		bean.setTest("Blood group");
		bean.setTest_3("Blood sugar");

	}
	 
	@Test
	public void addCenter() {
		DiagnosticCenterBean bean= new DiagnosticCenterBean();
		bean.setCenter_id(7);
		bean.setCenter_name("Apolo");
		bean.setCenter_location("Hyd");
		bean.setTest_1("DNA Test");
		bean.setTest("Blood group");
		bean.setTest_3("Blood sugar");
	}
	
	@Test
	public void deleteCenter() {
		DiagnosticCenterBean bean= new DiagnosticCenterBean();
		bean.setCenter_id(7);
		bean.setCenter_name("Apolo");
		bean.setCenter_location("Hyd");
		bean.setTest_1("DNA Test");
		bean.setTest("Blood group");
		bean.setTest_3("Blood sugar");
		/* giving the center_id for deleting method */
		service.deleteCenter(7);
	
	}

}	
