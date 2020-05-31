package com.course.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.course.beans.Courses;
import com.course.repo.CourseRepo;

public class CourseService  {

	@Autowired
	CourseRepo courserepo;
	public List<Courses> getCources()
	{
		return (List)courserepo.findAll(); 
	}
	
}
