package com.crudedemo.cntr;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crudedemo.dto.Student;
import com.crudedemo.service.StudentService;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins ="*")
public class StudentCntr {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping(value="welcome")
	public String getWelcome() {
		return "Project has been running";
	}
	
	@PostMapping(path="addStudent")
	public String addStudent(@RequestBody Student student) {
		
		System.out.println("add student "+student);
		
		Boolean isInserted=studentService.insertStudent(student);
		
		if(isInserted) {
			return "Data has been insterted";
		}else {
			return "Data not inserted";
		}
		
	}
	
	@GetMapping(path="getStudent/{id}")
	public String getStuent(@PathVariable Integer id) {
		
		Student getStudent=studentService.getStudentbyId(id);
		
		return getStudent.toString();
		
	}
	
	@GetMapping(path="getQueryParam")
	public Student getStuent(@RequestParam(value="name") String name,@RequestParam(value="key") String key) {
		System.out.println(Integer.parseInt(key)+" "+name);
		
		return studentService.getStudentByIdAndName(Integer.parseInt(key),name);
		
		
	}
	
	@GetMapping(path="getAllQueryParam")
	public List<Student> getAllStudent(@RequestParam(value="age") String age,@RequestParam(value="name") String name) {
		//System.out.println(age+" "+name);
		
		return studentService.getAllStudentByAgeAndName(Integer.parseInt(age),name);
		
		
	}
	
	@PutMapping(path="updateStudent")
	public String updateStudent(@RequestBody Student student) {
		
		Boolean isUpdated=studentService.updateStudentById(student);
		
		if(isUpdated) {
			return "Data has been updated";
		}else {
			return "Data is not updated, look like data is not present in database";
		}
		
	}
	
	@DeleteMapping(path="deleteStudent/{id}")
	public String deleteStudent(@PathVariable Integer id) {
		
		Boolean isDeleted=studentService.deleteStudentById(id);
		
		if(isDeleted) {
			return "Data has been deleted";
		}else {
			return "Data is not deleted, look like data is not present in database";
		}
		
	}
	
	@PatchMapping(path="patchUpdateStudent")
	public String patchUpdateStudent(@RequestBody Student student) {
		
		Boolean isUpdated=studentService.updateStudentById(student);
		
		if(isUpdated) {
			return "Data has been patch updated";
		}else {
			return "Data is not patch updated, look like data is not present in database";
		}
		
	}
	
	
}
