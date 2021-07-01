package com.dispatcher.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dispatcher.exception.ResourceNotFoundException;
import com.dispatcher.model.DispatcherDb;
import com.dispatcher.repository.DispatcherDbRepository;


@Service
public class DispatcherDbService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherDbService.class);
	
	@Autowired
	private DispatcherDbRepository dispatcherDbRepository;
	
	
	//String subject ="OCR";
	
	public DispatcherDb insertDispatcherDb(DispatcherDb dispatcherDb) {
		LOGGER.info("Start process");
		   return dispatcherDbRepository.save(dispatcherDb);
	}
	

//String str=" ";
	public ResponseEntity<List<String>> getDispatcherDbByValidation(String dvalidation)
				throws ResourceNotFoundException {
			
			LOGGER.info("Start process");
			
			
			    List<DispatcherDb> dispatcherDbs = dispatcherDbRepository.findByValidation(dvalidation);
			    List<String> actions = new ArrayList<>();
			    
			    for(DispatcherDb dispatcherDb: dispatcherDbs) {
			    	
			    	actions.add(dispatcherDb.getAction());
			    	//str+=dispatcherDb.getAction()+"\n";
			    }
					return ResponseEntity.ok().body(actions);
		}
		
	public List<DispatcherDb> getAllDispatcherDb(){
		LOGGER.info("Start process");
		
		
		  return this.dispatcherDbRepository.findAll();
		  
		
	}


	
	
	
}
