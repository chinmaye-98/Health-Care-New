package com.capg.hcs.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/*@Author Chinmaye*/
@Entity
@Table(name="Health_Spring")
public class DiagnosticCenterBean {
	
	 public  DiagnosticCenterBean() {
			
	}
	 
		
		public DiagnosticCenterBean(int center_id, String center_name, String center_location, String test_1,
				String test, String test_3) {
			super();
			this.center_id = center_id;
			this.center_name = center_name;
			this.center_location = center_location;
			this.test_1 = test_1;
			this.test = test;
			this.test_3 = test_3;
		}
		 
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int center_id;
	
	@NotEmpty(message="Centername is mandatory field.Please provide centername")
	@Size(min=3,message="Name should have atleast:3 characters")
	private String center_name;
	
	@NotEmpty(message="Centerlocation is mandatory field.Please provide centerlocation")
	@Size(min=5,message="Name should have atleast:5 characters")
	private String center_location;
	
	@NotEmpty(message="test is mandatory field.Please provide test")
	  private String test_1;
	
	@NotEmpty(message="test is mandatory field.Please provide test")
	  private String test;
	
	@NotEmpty(message="test is mandatory field.Please provide test")
		 private String test_3;
	
	  public String getTest_1() {
		return test_1;
	}

	public void setTest_1(String test_1) {
		this.test_1 = test_1;
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public String getTest_3() {
		return test_3;
	}

	public void setTest_3(String test_3) {
		this.test_3 = test_3;
	}


	 
	public int getCenter_id() {
		return center_id;
	}

	public void setCenter_id(int center_id) {
		this.center_id = center_id;
	}

	public String getCenter_name() {
		return center_name;
	}

	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}
	
	public String getCenter_location() {
		return center_location;
	}

	public void setCenter_location(String center_location) {
		this.center_location = center_location;
	}
	
	@Override
	public String toString() {
		return " [center_id=" +center_id + ", center_name=" + center_name + ",location=" +center_location
				+ "]";
	}
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
