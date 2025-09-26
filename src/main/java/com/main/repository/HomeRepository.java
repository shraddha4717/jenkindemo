package com.main.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.model.Laptop;

@Repository
public interface HomeRepository extends CrudRepository<Laptop,Integer>{

	List<Laptop> findByUsernameAndPassword(String username, String password);
	
	Laptop getLaptopById(int id);  // Fetch laptop for editing
}
