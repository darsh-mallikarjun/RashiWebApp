package com.rashi.application.service;


import com.rashi.application.dto.UserRegistrationDTO;
import com.rashi.application.model.User;

public interface UserService {

	User save(UserRegistrationDTO registration);
	
	public User findUserByEmail(String email ,String password);
	
}
