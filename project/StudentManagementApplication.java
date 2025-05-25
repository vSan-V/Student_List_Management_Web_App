package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.entity.Student;
import com.project.repository.StudentRepository;

@SpringBootApplication
public class StudentManagementApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}
	
	@Autowired
	private StudentRepository studentrepository;

	@Override
	public void run(String... args) throws Exception {
//		Student student1 = new Student("sanjai","v","sanjai@gmail.com");
//		studentrepository.save(student1);
//		
//		Student student2 = new Student("naveen", "kumar","naveen@gmail.com");
//		studentrepository.save(student2);
		
	}

}
