package com.mob.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mob.beans.Mobiles;
import com.mob.service.MobService;

@RestController
@RequestMapping("/mobiles")
public class HomeController {


	@Autowired
	MobService mservice;
	
	
	@GetMapping("/show")
	
	public List<Mobiles> showMobiles()
	{
		return mservice.getAllMobile();
	}

	@GetMapping("/show/{id}")
	public Optional<Mobiles> showMobile(@PathVariable("id") int pid)
	{
		return mservice.getSingleMobile(pid);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteMobile(@PathVariable("id") int pid)
	{
		mservice.deleteMobile(pid);
		return "Data Deleted....";
	}
}
