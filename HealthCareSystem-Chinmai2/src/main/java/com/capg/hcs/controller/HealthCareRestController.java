package com.capg.hcs.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.hcs.entity.DiagnosticCenterBean;
import com.capg.hcs.exception.HealthCareException;
import com.capg.hcs.service.HealthCareServiceImpl;

/*@Author Chinmaye*/


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/healthcare" )
public class HealthCareRestController {
	
	@Autowired
	HealthCareServiceImpl healthCareSystemImpl;
	
	/*
	 * http:localhost:8098/healthcare/add // POSTMAN (Post : body{
	 * "center_name": "Apolo","center_location":"Kompally"
	 * "test_1":"blood Pressure","test":"Blood Sugar", "test_3": "Blood Group"}
	 * dont insert id , id is :@GeneratedValue(strategy = GenerationType.SEQUENCE)
	 */	 @PostMapping(value="/add")
	 public ResponseEntity<Boolean> addCenter(@RequestBody DiagnosticCenterBean center) {
			DiagnosticCenterBean diagnosticCenter = healthCareSystemImpl.addCenter(center);
			ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
			System.out.println("response entity=" + responseEntity);

			return responseEntity;
		}
			
		
	 
	 @GetMapping(value="/getCenter/{center_id}")  //GET:http://localhost:8098/healthcare/getCenter/7
	 //the details of particular id
	 @ResponseBody
	 public DiagnosticCenterBean getCenter(@PathVariable int center_id) throws HealthCareException{
		 DiagnosticCenterBean diagnosticCenter =  healthCareSystemImpl. getCenter( center_id);
		 if (diagnosticCenter == null) {
				throw new HealthCareException("Invalid id");
			}
		 return diagnosticCenter;
	 }
	 
	 
		@GetMapping(value = "/display")
		/*
		 * GET:http://localhost:8098/healthcare/display
		 */		public ResponseEntity<List<DiagnosticCenterBean>> displayCenter() {

			List<DiagnosticCenterBean> center =  healthCareSystemImpl.displaycenter();
		  return new ResponseEntity<List<DiagnosticCenterBean>>(center,new HttpHeaders(),HttpStatus.OK);
		}

	 @DeleteMapping(value="/deleteCenter/{center_id}")//Delete:http://localhost:8098/healthcare/deleteCenter/3 
	 // the details with center id particularly will be deleted
	  public  ResponseEntity<Boolean>  deleteCenter(@PathVariable int center_id) throws HealthCareException 
	  {
		 healthCareSystemImpl.deleteCenter(center_id);
		 ResponseEntity<Boolean> responseEntity = new ResponseEntity(true, HttpStatus.OK);
		 if(center_id==0) {
			 throw new HealthCareException("Invalid Id");
		 }
		 System.out.println("response entity=" + responseEntity);
			return responseEntity;
	  }

	 
	 
}
