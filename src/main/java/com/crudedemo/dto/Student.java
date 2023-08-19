package com.crudedemo.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="STUDENT")
public class Student {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="AGE")
	private int age;
	
	@Column(name="ADD")
	private String add;
	
	Student(){
		
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public void setAdd(String add) {
		this.add=add;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
	return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	
	public String getAdd() {
	return this.add;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.id+" | "+this.name+" | "+this.age +" | "+this.add;
	}
	
}
