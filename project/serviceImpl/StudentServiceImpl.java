package com.project.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.entity.Student;
import com.project.repository.StudentRepository;
import com.project.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentrepository;
	
	
	public StudentServiceImpl(StudentRepository studentrepository) {
		super();
		this.studentrepository = studentrepository;
	}


	@Override
	public List<Student> getAllStudents() {
		return studentrepository.findAll();
	}


	@Override
	public Student saveStudent(Student student) {

		return studentrepository.save(student);
	}


	@Override
	public Student getStudentById(Long id) {
		return studentrepository.findById(id).get();
	}


	@Override
	public Student UpdateStudent(Student student) {
		return studentrepository.save(student);
	}


	@Override
	public void deleteStudentById(Long id) {
		studentrepository.deleteById(id);
		
	}

}
