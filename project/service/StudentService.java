package com.project.service;

import java.util.List;

import com.project.entity.Student;

public interface StudentService {
	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Long id);
	
	Student UpdateStudent(Student student);
	
	void deleteStudentById(Long id);

}
