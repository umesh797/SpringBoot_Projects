package com.course.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Courses {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int Cid;
	private String CName;
	private int duration;
	private double price;
	
	
	public int getCid() {
		return Cid;
	}
	public void setCid(int cid) {
		Cid = cid;
	}
	public String getCName() {
		return CName;
	}
	public void setCName(String cName) {
		CName = cName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	

}
