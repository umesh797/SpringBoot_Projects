package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.beans.Employee;

public interface EmpRepo extends CrudRepository<Employee, Integer>{

}
