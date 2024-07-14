package com.rashi.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rashi.application.model.ProductPlots;

@Repository
public interface AutoCompleteRepo extends JpaRepository<ProductPlots ,Integer> {

	List<ProductPlots> findAll();
	
}
