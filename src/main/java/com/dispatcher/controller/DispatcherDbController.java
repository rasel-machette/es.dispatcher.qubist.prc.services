package com.dispatcher.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.dispatcher.exception.ResourceNotFoundException;
import com.dispatcher.model.DispatcherDb;
import com.dispatcher.service.DispatcherDbService;

@RestController
@RequestMapping("/dispatcher/v1.0")
public class DispatcherDbController {
	
	@Autowired
	private DispatcherDbService dispatcherDbService;
	
	 @PostMapping(
	 	        value = "/dispatcherDb",
	 	        consumes = MediaType.APPLICATION_JSON_VALUE)
	    public DispatcherDb insertDispatcherDb(@Validated @RequestBody DispatcherDb dispatcherDb) {
			 return dispatcherDbService.insertDispatcherDb(dispatcherDb);
		}
		
	 @GetMapping(
			 value = "/dispatcherDb", params = "validation",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getDispatcherDbByValidation(@RequestParam(value = "validation") String dvalidation)
			throws ResourceNotFoundException {
		 return dispatcherDbService.getDispatcherDbByValidation(dvalidation);
	}
	 
	 
	 @GetMapping(
	   	        value = "/dispatcherDb",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	 public List<DispatcherDb> getAllDispatcherDb(){
		 return this.dispatcherDbService.getAllDispatcherDb();
		
	}	 
	 
	 

}
