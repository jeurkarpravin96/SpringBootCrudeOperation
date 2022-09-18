package com.crudedemo.service.imple;

import java.util.*;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crudedemo.dto.Student;
import com.crudedemo.repo.StudentRepo;
import com.crudedemo.service.StudentService;


@Service
public class StudentServiceImple implements StudentService{
	
	@Autowired
	private StudentRepo studentRepo;
	
	@Override
	public Boolean insertStudent(Student student) {

		Student isInserted;
			
		isInserted=studentRepo.save(student);
		
		if(isInserted!=null) {
			return true;
		}else {
			return false;
		}
		
		
	}
	@Id
	@Override
	public Student getStudentbyId(int id) {
		
		Student getStudent;
		
		getStudent=studentRepo.findById(id).get();
		
		if(getStudent!=null) {
			return getStudent;
		}else {
			return getStudent;
		}

	}
	@Override
	public Boolean deleteStudentById(int id) {

		try {
			studentRepo.deleteById(id);
			return true;
		}catch (Exception e) {
			return false;
		}
		
	}
	@Override
	public Boolean updateStudentById(Student student) {

		Optional<Student> std=studentRepo.findById(student.getId());
		
		if (std.isPresent()) {
			studentRepo.save(student);
			return true;
		}else {
			return false;
		}
		
		
	}
	@Override
	public Boolean patchUpdateStudentById(Student student) {

		Optional<Student> std=studentRepo.findById(student.getId());
		
		if (std.isPresent()) {
			studentRepo.save(student);
			return true;
		}else {
			return false;
		}
		
	}
	@Override
	public Student getStudentByIdAndName(int id,String name) {
		// TODO Auto-generated method stub
		
		Student std=studentRepo.getStudentByNameId(id, name);
		
		return std;
	}
	@Override
	public List<Student> getAllStudentByAgeAndName(int age, String name) {
		// TODO Auto-generated method stub
		
		List<Student> std=studentRepo.getAllStudentByAgeAndName(age, name);
		
		return std;
	}

}
