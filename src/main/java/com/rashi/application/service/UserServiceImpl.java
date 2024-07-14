package com.rashi.application.service;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.rashi.application.dto.UserRegistrationDTO;
import com.rashi.application.model.User;
import com.rashi.application.repository.UserRepo;



@Service
public class UserServiceImpl implements UserService{
	
	
	@Autowired
	private UserRepo userrepository;
	
	
	
	public UserServiceImpl( UserRepo userrepository) {
		super();
		this.userrepository = userrepository;
	}
	
	@Override
	public User save(UserRegistrationDTO registration) {
		User user =new User(registration.getName(),registration.getEmail(),registration.getPassword(),registration.getMobile());
		return userrepository.save(user) ;
	}


	@Override
	public User findUserByEmail(String email , String password) {
		User user = userrepository.findByEmail(email);
		if(user !=null && user.getPassword().equals(password)) {
			return user;
	}
	return null;
		 
	}


	
}

	


