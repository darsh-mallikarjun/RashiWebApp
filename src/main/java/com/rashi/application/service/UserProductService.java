package com.rashi.application.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rashi.application.dto.BookingDto;
import com.rashi.application.model.BookingDetials;
import com.rashi.application.model.ProductPlots;
import com.rashi.application.model.User;
import com.rashi.application.repository.BookingDetialsRepo;
import com.rashi.application.repository.ProductPlotRepo;
import com.rashi.application.repository.UserRepo;



@Service
public class UserProductService {
	
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ProductPlotRepo productPlotRepo;
	

	@Autowired
	private BookingDetialsRepo  bookingDetialsRepo;

	public User findUserByEmail(String email , String password ) {
		User user = userRepo.findByEmail(email);
		if(user !=null && user.getPassword().equals(password)) {
			return user;
	}
	return null;
		 
	}
	
	public List<ProductPlots> findByAddress(String address)
	 {
		return productPlotRepo.findByAddress(address);
		 
	}

	public List<ProductPlots> findAll() {
		
		return productPlotRepo.findAll();
	}

	public ProductPlots findAllProductByUser(int theId) {
		 Optional<ProductPlots> result = productPlotRepo.findById(theId);

		 ProductPlots product = null;

	        if (result.isPresent()) {
	        	product = result.get();
	        }
	        else {
	            // we didn't find the employee
	            throw new RuntimeException("Did not find Product id - " + theId);
	        }

	        return product;
	}
	

	public BookingDetials save(BookingDto BookingDto) {
		BookingDetials bookingDetials =  new BookingDetials(BookingDto.getPrice(),BookingDto.getAddress(),BookingDto.getPlot_area(),BookingDto.getDimensions(),BookingDto.getImage() ,BookingDto.getName() ,BookingDto.getEmail());
		return bookingDetialsRepo.save(bookingDetials);
	}
	}
	
