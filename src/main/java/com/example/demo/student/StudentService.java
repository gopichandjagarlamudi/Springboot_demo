package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
	
	private final StudentRepository studentRepository;
	
	@Autowired	
	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}



	public List<student> getStudents(){
		return studentRepository.findAll();
				}



	public void addNewStudent(student student) {
		Optional<student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
		if(studentOptional.isPresent()) {
			throw new IllegalStateException("email taken");
		}
		studentRepository.save(student);
	}



	public void deleteStudent(Long StudentId) {
		boolean exists = studentRepository.existsById(StudentId);
		if(!exists) {
			throw new IllegalStateException("student with id" + StudentId + " does not exists");
			
		}
		studentRepository.deleteById(StudentId);
	}
}
