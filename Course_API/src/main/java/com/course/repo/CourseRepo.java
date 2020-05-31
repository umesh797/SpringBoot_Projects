package com.course.repo;



import org.springframework.data.repository.CrudRepository;

import com.course.beans.Courses;

public interface CourseRepo extends CrudRepository<Courses, Integer> {

	
}
