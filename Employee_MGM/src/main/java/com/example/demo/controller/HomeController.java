package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.beans.Employee;
import com.example.demo.dao.EmpRepo;

@Controller
public class HomeController
{
	
	@Autowired
	EmpRepo eRepo;
	
	@RequestMapping("/home")
	public String home()
	{
		return "index";
	}
	
	@RequestMapping("/register")
	public String register()
	{
		return "register";
	}
	
	@RequestMapping("/saveEmp")
	public String saveData(@ModelAttribute("emp") Employee emp,Model md)
	{
		eRepo.save(emp);
		md.addAttribute("msg", "Data Inserted Succsessfully...");
		return "register";
		
	}
	
	@RequestMapping("/showEmp")
	public String showData(Model md)
	{
		List<Employee> emp=(List<Employee>) eRepo.findAll();
		md.addAttribute("Empl", emp);
		return "show";
		
	}
	
	@RequestMapping("/editEmp/{id}")
	public String editData(@PathVariable("id") int id,Model md)
	{
		Optional<Employee> emp= eRepo.findById(id);
		md.addAttribute("Empl", emp);
		return "edit";
		
	}
	
	@RequestMapping("/editEmp")
	public String editData(Employee em,Model md)
	{
		 eRepo.save(em);
		 List<Employee> emp=(List<Employee>) eRepo.findAll();
			md.addAttribute("Empl", emp);
			return "show";
		
	}
	
	@RequestMapping("/deleteEmp/{id}")
	public String deteteData(@PathVariable("id") int id,Model md)
	{
		eRepo.deleteById(id);
		List<Employee> emp=(List<Employee>) eRepo.findAll();
		md.addAttribute("Empl", emp);
		md.addAttribute("msg", "Record Deleted");
		return "show";
		
	}
}
