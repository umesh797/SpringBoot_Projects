package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Student;
import com.example.demo.dao.EmpRepo;

@RestController
public class HomeController
{
 
	@Autowired
	EmpRepo erepo;
	
	@RequestMapping("/home")
	public String Home()
	{
		return "homePage";
	}
	
	@RequestMapping("/addStudent")
	public Student addStudent(@RequestBody Student s)
	{
		return erepo.save(s);
		
		
	}
	
	@RequestMapping("/viewStudents")
	public List<Student> ViewStudent()
	{
		return (List) erepo.findAll();
	}
	
	@RequestMapping("/viewStudent/{id}")
	public Optional<Student> ViewStudentById(@PathVariable int id)
	{
		
				Optional<Student> st= erepo.findById(id);
				return st;
	}
	@RequestMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable int id)
	{
		
		 erepo.deleteById(id);
		 
		 return "Record "+id+" deleted";
				
	}
	
	@RequestMapping("/updateStudent/{id}")
	public Student updateStudent(@RequestBody Student stu)
	{
		
				
				return erepo.save(stu);
	}
}
