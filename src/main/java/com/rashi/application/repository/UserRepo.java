package com.rashi.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rashi.application.model.User;


@Repository
public interface UserRepo extends JpaRepository<User ,Integer> {
	
	User findByEmail(String email);
	
}
