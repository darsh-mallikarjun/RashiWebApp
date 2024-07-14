package com.rashi.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.rashi.application.model.ProductPlots;
import com.rashi.application.repository.ProductPlotRepo;



@Service
public class ProductPlotsImpl implements ProductService  {

	@Autowired
	private ProductPlotRepo productPlotReop;

	public ProductPlotsImpl(ProductPlotRepo productPlotReop) {
		super();
		this.productPlotReop = productPlotReop;
	}
	
	

	@Override
	public List<ProductPlots> findByAddress(String address ) {
		return productPlotReop.findByAddress(address);
		 
	}

	
	@Override
	public List<ProductPlots> findAll() {
		
		return productPlotReop.findAll();
	}

	}

