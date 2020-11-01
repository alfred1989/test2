package com.example.demo.controllers;

import com.example.demo.models.Business;
import com.example.demo.repositories.BusinessRepository;
import com.example.demo.services.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
//@RequestMapping("/business")
public class BusinessController {
	
	@Autowired
	private BusinessService businessService;


	@GetMapping("/login")
	public  String loginRegistration(Model model){
		model.addAttribute("business", new Business());
		return "loginRegistration";
	}

	@PostMapping("/registration")
	public String registrationBusiness(Business business){
		businessService.addNew(business);
		return "redirect:/getAll";
	}

	@RequestMapping("/getAll")
	public String getAll(Model model) {
		model.addAttribute("username", "Kindson");
		List<Business> businesses = businessService.getAll();
		model.addAttribute("businesses", businesses);
		return "database";
	}
	
	@RequestMapping("/getOne")
	@ResponseBody
	public Optional<Business> getOne(Integer Id)
	{
		return businessService.getOne(Id);
	}

	@PostMapping(value="/addNew")
	public String addNew(Business business) {

		businessService.addNew(business);
		System.out.println(business.toString());
		return "redirect:/students/getAll";

	}


	@RequestMapping(value="/update", method = {RequestMethod.PUT, RequestMethod.GET})
	public String update(Business business) {
		businessService.update(business);
		return "redirect:/getAll";
	}
	
	@RequestMapping(value="/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
	public String delete(Integer Id) {
		businessService.delete(Id);
		return "redirect:/getAll";
	}




}
