package com.dispatcher.controller;

import java.io.IOException;
import java.util.List;
import javax.mail.Folder;
import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dispatcher.Application;
import com.dispatcher.exception.ResourceNotFoundException;
import com.dispatcher.service.EmailService;


@RestController
public class EmailController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
	
	@Autowired
	private EmailService emailService;
	
	Folder emailFolder;
	
//	 @GetMapping(
//	   	        value = "/email",
//	   	        produces = MediaType.APPLICATION_JSON_VALUE)
//	 synchronized String readEmail() throws MessagingException, IOException {
//		 
//		 LOGGER.info("Start process");
//	
//		 return emailService.readEmail();
//	 }
	 
//	 @GetMapping(
//			 value = "/dispatcher", params = "validation",
//	   	        produces = MediaType.APPLICATION_JSON_VALUE)
//	public ResponseEntity<List<String>> getActionsByValidation(@RequestParam(value = "validation") String checkValidation)
//			throws ResourceNotFoundException {
//		 LOGGER.info("Start process");
//		 return emailService.getActionsByValidation(checkValidation);
//	}
	  

}
