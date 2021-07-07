package com.dispatcher.controller;

import java.io.IOException;
import java.util.List;
import javax.mail.Folder;
import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dispatcher.exception.ResourceNotFoundException;
import com.dispatcher.service.EmailService;


@RestController
@RequestMapping("/dispatcher/v1.0")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	Folder emailFolder;
	
	 @GetMapping(
	   	        value = "/email",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	 synchronized String read() throws MessagingException, IOException {
		 
		 
	
		 return emailService.read();
	 }
	 
	 @GetMapping(
			 value = "/dispatcher", params = "validation",
	   	        produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getDispatcherDbByValidation(@RequestParam(value = "validation") String checkValidation)
			throws ResourceNotFoundException {
		 return emailService.getDispatcherDbByValidation(checkValidation);
	}
	  

}
