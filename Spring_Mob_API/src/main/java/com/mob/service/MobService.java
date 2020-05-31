package com.mob.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mob.beans.Mobiles;
import com.mob.dao.MobileRepo;

@Service
public class MobService 
{

	@Autowired
	MobileRepo mobilerepo;
	
	public List<Mobiles> getAllMobile()
	{
		return (List)mobilerepo.findAll() ;
	}
	
	
	public Optional<Mobiles> getSingleMobile(int pid)
	{
		return mobilerepo.findById(pid);
	}
	
	public void deleteMobile(int pid)
	{
	 mobilerepo.deleteById(pid);
	}
	
}
