package com.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.entity.Student;
import com.project.service.StudentService;

@Controller
public class StudentController {
	
	private StudentService studentservice;

	public StudentController(StudentService studentservice) {
		super();
		this.studentservice = studentservice;
	}
	
	//handler method to handle list students and return mode and view
	@GetMapping("/students")
	public String listStudents(Model model) {
		model.addAttribute("students", studentservice.getAllStudents());
		return "students";
	}
	
	@GetMapping("/students/new")
	public String createStudentForm(Model model) {
		
		//create student object to hold student form data
		Student student = new Student();
		//model.addAttribute("student", student);
		model.addAttribute("student", student);
		return "create_student";
	}
	
	@PostMapping("/students")
//	public String saveStudent(@ModelAttribute("student") Student student) {
//		studentservice.saveStudent(student);
//		return "redirect:/students";
//	}
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentservice.saveStudent(student);
		return "redirect:/students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("student", studentservice.getStudentById(id));
		return "edit_student";		
	}
	
	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,
			Model model) {
		
		
		//get student from database by id
		Student existingStudent = studentservice.getStudentById(id);
		existingStudent.setId(id);
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		
		//save updated student object
		studentservice.UpdateStudent(existingStudent);
		return "redirect:/students";
			
	}
	//handler method handle to delete the file
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) {
		studentservice.deleteStudentById(id);
		return "redirect:/students";
	}

}
