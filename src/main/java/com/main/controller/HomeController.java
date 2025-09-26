package com.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.model.Laptop;
import com.main.service.HomeService;

@Controller
public class HomeController 
{

	@Autowired
	HomeService hs;
	
	
	@RequestMapping("/")
	public String preLog() 
	{
		return "login";
		
	}
	
	@RequestMapping("/openregister")
	public String preReg() 
	{
		return "register";
		
	}
	
	@RequestMapping("/save")
	public String saveData(@ModelAttribute Laptop l) 
	{
		System.out.println("data save");
		hs.saveLaptop(l);
		return "login";
		
	}

	@RequestMapping("/log")
	public String myLog(@RequestParam("username") String username, @RequestParam("password") String password,
			Model model) 
	{

		if (username.isEmpty() || password.isEmpty()) 
		{
			model.addAttribute("error", "Please enter valid username and password.");
			return "login"; // Stay on login page if details are missing
		}

		if ("admin".equals(username) && "admin".equals(password))
		{
			List<Laptop> laptopList = hs.getAllLaptops();
			model.addAttribute("data", laptopList);
			return "success";
		} 
		else 
		{
			List<Laptop> laptopList = hs.singleData(username, password);
			if (!laptopList.isEmpty()) 
			{
				model.addAttribute("data", laptopList);
				return "success";
			}
			else
			{
				model.addAttribute("error", "Invalid username or password.");
				return "login"; // Redirect back to login on failed login
			}
		}
	}
	
	@RequestMapping("/delete")
	public String deleteLaptop(@RequestParam("id") Integer id, Model model) 
	{
		hs.deleteLaptopById(id); // Deletes laptop by ID
		List<Laptop> laptopList = hs.getAllLaptops(); // Reload updated list
		model.addAttribute("data", laptopList);
		return "success"; // Redirects to the success page with updated data
	}
	
	@RequestMapping("/edit")
    public String editLaptop(@RequestParam("id") int id, Model model) 
	{
        Laptop laptop = hs.getLaptopById(id);  // Fetch the laptop by ID
        model.addAttribute("laptop", laptop);  // Pass laptop to edit page
        return "edit";  // Redirect to edit page
    }

    
    
    @RequestMapping("/update")
    public String updateLaptop(@ModelAttribute Laptop laptop, Model model) {
        if (laptop.getId() != null) {  // Ensure the ID is present
            hs.updateLaptop(laptop);    // Save the updated laptop
        }

        List<Laptop> laptopList = hs.getAllLaptops();  // Reload the updated list
        model.addAttribute("data", laptopList);
        return "success";  // Redirect to the success page after update
    }
}
