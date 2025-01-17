package com.rashi.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rashi.application.model.Admin;

@Repository
public interface AdminRepo extends JpaRepository<Admin ,Integer>{

	Admin findByName(String name);
}
