package com.dispatcher.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dispatcher.exception.ResourceNotFoundException;
import com.dispatcher.repository.EventRepository;
import com.dispatcher.entity.Event;
import com.dispatcher.entity.EmailConfig;
//import com.dispatcher.service.MessageParser;


@Service
public class EmailService {
	
	//Event event= new Event();
	
	@Autowired
	private EmailConfig emailConfig;
	
	@Autowired
	private EventRepository eventRepository;

	Folder emailFolder;
	Store store;
	Properties properties = new Properties();
	 String email="";
	 
	@PostConstruct
	public void setupEmail() {
		String server = emailConfig.getHost();
		properties.put("mail.pop3.host", server);
		properties.put("mail.pop3.port", emailConfig.getPort());
		//properties.put("mail.pop3.starttls.enable", "true");
		Session emailSession = Session.getDefaultInstance(properties);
		Store store = null;
		try {
			store = emailSession.getStore("pop3s");
			store.connect(server, emailConfig.getUsername(), emailConfig.getPassword());
			emailFolder = store.getFolder("INBOX");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	
	@Scheduled(fixedRate = 5000)
	public synchronized String readEmail() throws MessagingException, IOException {
//		 String endpoint = "http://localhost:8080/dispatcher/v1.0/email";
		 try {
		
		emailFolder.open(Folder.READ_ONLY);
		Message[] messages = emailFolder.getMessages();
		for (int i = 0; i < messages.length; i++) {
			Message message = messages[i];
			 
			System.out.println("Subject: "+message.getSubject());
			System.out.println("Body: "+MessageParser.getMessageBody(message));
			
//			Event event = new Event();
//			event.setAction(endpoint);
//			event.setValidation(message.getSubject());
//			dispatcherDbRepository.save(event);
			 {
			email+="Subject: "+message.getSubject()+"\n"+"Body:"+MessageParser.getMessageBody(message);	
			}
			
		}
		
		emailFolder.close();
		
	}
			catch(MessagingException me){
				me.printStackTrace();
				
			}
		 return email;
	 }	
	
//	public ResponseEntity<List<String>> getActionsByValidation(String checkValidation)
//			throws ResourceNotFoundException {
//		
//		    List<Event> events = eventRepository.findByValidation(checkValidation);
//		    List<String> actions = new ArrayList<>();
//		    
//		    for(Event event: events) {
//		    	
//		    	actions.add(event.getAction());
//		    	
//		    }
//				return ResponseEntity.ok().body(actions);
//	}
}
