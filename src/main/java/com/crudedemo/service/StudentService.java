package com.crudedemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.crudedemo.dto.Student;

public interface StudentService {

	public Boolean insertStudent(Student student);
	public Student getStudentbyId(int id);
	public Boolean deleteStudentById(int id);
	public Boolean updateStudentById(Student student);
	public Boolean patchUpdateStudentById(Student student);
	public Student getStudentByIdAndName(int id,String name);
	public List<Student> getAllStudentByAgeAndName(int age,String name);
}
