package com.example.demo.student;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path= "api/v1/student")
public class StudentController {
	
	private final StudentService studentService;
	
	
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}


	@GetMapping()
	public List<student> getStudents()
	{
		return studentService.getStudents();
	}
	@PostMapping
	public void registerNewStudent(@RequestBody student Student) {
		studentService.addNewStudent(Student);
	}
	@DeleteMapping(path="{studentId")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {
		studentService.deleteStudent(studentId);
	}

}
