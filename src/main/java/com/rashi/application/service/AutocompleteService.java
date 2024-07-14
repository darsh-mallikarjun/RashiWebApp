package com.rashi.application.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.rashi.application.model.ProductPlots;
import com.rashi.application.repository.AutoCompleteRepo;

@Service
public class AutocompleteService {
	

	private AutoCompleteRepo autoCompleterep;

	public AutocompleteService(AutoCompleteRepo autoCompleterep) {
		super();
		this.autoCompleterep = autoCompleterep;
	}
	
public List<String> getAllAddress() {
	
	List<ProductPlots> product = autoCompleterep.findAll();
	return product.stream()
			.map(ProductPlotDto -> ProductPlotDto.getAddress())
			.collect(Collectors.toList());
		
		
	}
}
