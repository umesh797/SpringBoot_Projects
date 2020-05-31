package com.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.course.beans.Courses;
import com.course.repo.CourseRepo;

@RestController
public class HomeController {
	
	@Autowired
	CourseRepo crepo;

	@GetMapping("/")
	
	public String home()
	{
		return "Welcome to Course Api";
		
	}
	
	@GetMapping("/courses")
	public List<Courses> getCourse()
	{
		List<Courses> course=(List)crepo.findAll();
		return course;
	}
	
	@RequestMapping("/saveCourse")
	public Courses SaveCourse(@RequestBody Courses course)
	{
		return crepo.save(course);
		//return "Cid->"+course.getCid()+" saved..";
	}
	
	@RequestMapping("/Course/{Cid}")
	public Optional<Courses> CourseById(@PathVariable int Cid)
	{
		return crepo.findById(Cid);
		
	}
	
	@RequestMapping("/deleteCourse/{Cid}")
	public String DeleteCourse(@PathVariable int Cid,Courses cur)
	{
		crepo.deleteById(Cid);
		return "Cid "+cur.getCid()+" is deleted.";
		
	}
	
	@RequestMapping("/updateCourse/{Cid}")
	public Courses UpdateCourse(@RequestBody Courses cur)
	{
		return crepo.save(cur);

		
	}
	
}
