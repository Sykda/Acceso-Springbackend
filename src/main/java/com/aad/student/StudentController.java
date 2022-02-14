package com.aad.student;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

	private final StudentService studentService;

	@Autowired
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("api/v1/student")
	public List<Student> getStudent() {

		return studentService.getStudent();
	}

	@PostMapping("api/v1/student")
	public void addNewStudent(@RequestBody Student student) {
		System.out.println(student);
		studentService.addNewStudent(student);
	}

	@DeleteMapping("api/v1/student/{studentId}")
	public void deleteStudent(@PathVariable("studentId") Long studentId) {

		studentService.deleteStudent(studentId);
	}

	@PutMapping("api/v1/student/{studentId}")
	public void updateStudent(@PathVariable("studentId") Long studentId, @RequestParam(required = true) String name,
			@RequestParam(required = true) String email) {

		studentService.updateStudent(studentId, name, email);
	}

}
