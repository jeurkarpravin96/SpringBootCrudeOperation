package com.crudedemo.repo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crudedemo.dto.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {

	@Query(value ="select * from student  where id=? and name=?",nativeQuery = true)
	public Student getStudentByNameId(int id,String name);
	
	@Modifying
	@Transactional
	@Query(value="select * from student where age=? and name=?",nativeQuery = true)
	public List<Student> getAllStudentByAgeAndName(int age,String name);
	
}
