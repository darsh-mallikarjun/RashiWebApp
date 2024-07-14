package com.rashi.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rashi.application.dto.ProductPlotDto;
import com.rashi.application.model.Admin;
import com.rashi.application.model.BookingDetials;
import com.rashi.application.model.ProductPlots;
import com.rashi.application.model.User;
import com.rashi.application.repository.AdminRepo;
import com.rashi.application.repository.BookingDetialsRepo;
import com.rashi.application.repository.ProductPlotRepo;

@Service
public class AdminService {

	@Autowired
	private AdminRepo adminRepo;

	@Autowired
	private ProductPlotRepo productPlotReop;

	
  @Autowired
  private BookingDetialsRepo  bookingDetialsRepo;
  
	
public List<BookingDetials> findAllBooking() {
		
		return bookingDetialsRepo.findAll();
	}

public ProductPlots save(ProductPlotDto productPlotDto) {
	ProductPlots product =  new ProductPlots(productPlotDto.getPrice(),productPlotDto.getAddress(),productPlotDto.getPlot_area(),productPlotDto.getDimensions(),productPlotDto.getImage());
	return productPlotReop.save(product);
}

public void deleteById(int theId) {
	bookingDetialsRepo.deleteById(theId);
	
}

	public Admin findUserByName(String name , String password) {
		Admin admin = adminRepo.findByName(name);
		if(admin !=null && admin.getPassword().equals(password)) {
			return admin;
	}
	return null;
		 
	}

	
}
	
