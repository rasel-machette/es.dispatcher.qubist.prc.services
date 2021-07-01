package com.dispatcher.model;

import org.springframework.stereotype.Component;

@Component
public class Event {
	
	private String subject;
	private String body;
	public Event() {
		super();
	}
	public Event(String subject, String body) {
		super();
		this.subject = subject;
		this.body = body;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	@Override
	public String toString() {
		return "Event [subject=" + subject + ", body=" + body + "]";
	}
	
  
}
