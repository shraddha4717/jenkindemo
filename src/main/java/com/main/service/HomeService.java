package com.main.service;

import java.util.List;

import com.main.model.Laptop;

public interface HomeService {

	public void saveLaptop(Laptop l);

	public List<Laptop> getAllLaptops();

	public List<Laptop> singleData(String username, String password);

	public void deleteLaptopById(Integer id);

	public Laptop getLaptopById(int id);

	public void updateLaptop(Laptop laptop);

}
