package com.rashi.application.service;

import java.util.List;


import com.rashi.application.model.ProductPlots;

public interface ProductService {
	
	public List<ProductPlots> findByAddress(String address );
	
	public List<ProductPlots>findAll();
	

}
