package com.rashi.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rashi.application.model.BookingDetials;
@Repository
public interface BookingDetialsRepo extends JpaRepository<BookingDetials ,Integer>{
	
}
