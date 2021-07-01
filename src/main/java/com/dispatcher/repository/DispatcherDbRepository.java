package com.dispatcher.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dispatcher.model.DispatcherDb;

@Repository
public interface DispatcherDbRepository extends JpaRepository<DispatcherDb, Long> {
	
	public List<DispatcherDb> findByAction(String action);
	public List<DispatcherDb> findByValidation(String validation);

}
