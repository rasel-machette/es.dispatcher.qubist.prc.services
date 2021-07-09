package com.dispatcher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dispatcher.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	
	public List<Event> findByAction(String action);
	public List<Event> findByValidation(String validation);

}
