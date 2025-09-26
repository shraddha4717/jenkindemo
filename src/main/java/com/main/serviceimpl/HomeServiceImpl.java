package com.main.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.model.Laptop;
import com.main.repository.HomeRepository;
import com.main.service.HomeService;

@Service
public class HomeServiceImpl implements HomeService{
	
	@Autowired
	HomeRepository hr;
	

	@Override
	public void saveLaptop(Laptop l)
	{
		
		hr.save(l);
	}


	@Override
	public List<Laptop> getAllLaptops() {
		// TODO Auto-generated method stub
		return (List<Laptop>) hr.findAll();
	}


	@Override
	public List<Laptop> singleData(String username, String password) {
		// TODO Auto-generated method stub
		return hr.findByUsernameAndPassword(username,password);
	}


	@Override
	public void deleteLaptopById(Integer id) {
		hr.deleteById(id);		// Deletes the laptop by its ID
	}


	@Override
    public Laptop getLaptopById(int id) {
        return hr.getLaptopById(id);  // Fetch laptop for edit
    }


	@Override
	public void updateLaptop(Laptop laptop) {
		// TODO Auto-generated method stub
		hr.save(laptop); // Save updated data (save() can handle updates if ID is present)
	}

}
