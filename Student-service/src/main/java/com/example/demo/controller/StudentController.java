package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.StudentRepository;
import com.example.demo.model.Student;

@RequestMapping("/students")
@RestController
public class StudentController {
	private final StudentRepository studentRepository;

	public StudentController(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	
	@PostMapping
	public Student addStudent(@RequestBody Student student) {
		return studentRepository.save(student);
	}
	@GetMapping
	public List<Student> getAllStudents(){
		return studentRepository.findAll();	
	}
	@GetMapping("/{id}")
	public Student findById(@PathVariable("id") int id) {
		return studentRepository.findById(id).orElse(null);
	}
	
}
