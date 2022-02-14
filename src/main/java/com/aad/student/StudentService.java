package com.aad.student;

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

	public List<Student> getStudent() {

		return studentRepository.findAll();
	}

	public void addNewStudent(Student student) {

		Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());

		if (studentOptional.isPresent()) {
			throw new IllegalStateException("The email is taken");
		} else {
			studentRepository.save(student);
		}

	}

	public void deleteStudent(Long studentId) {

		if (!studentRepository.existsById(studentId)) {
			throw new IllegalStateException("The 'id' doesnt exists");
		} else {
			studentRepository.deleteById(studentId);
		}
	}

	public void updateStudent(Long studentId, String name, String email) {
		
		if (!studentRepository.existsById(studentId)) {
			throw new IllegalStateException("The 'id' doesnt exists");
		} else {
			studentRepository.updateStudentByNameAndEmail(name, email, studentId);
		}
		
	}
	
	

}
